package com.dataeconomy.migration.app.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dataeconomy.migration.app.connection.HDFSConnectionService;
import com.dataeconomy.migration.app.exception.DataMigrationException;
import com.dataeconomy.migration.app.model.DMUBasketDto;
import com.dataeconomy.migration.app.mysql.entity.DMUBasketTemp;
import com.dataeconomy.migration.app.mysql.entity.DMUHIstoryDetailPK;
import com.dataeconomy.migration.app.mysql.entity.DMUHistoryDetail;
import com.dataeconomy.migration.app.mysql.entity.DMUHistoryMain;
import com.dataeconomy.migration.app.mysql.entity.DMUPtgyPK;
import com.dataeconomy.migration.app.mysql.entity.DMUPtgyTemp;
import com.dataeconomy.migration.app.mysql.entity.DMUReconDetail;
import com.dataeconomy.migration.app.mysql.entity.DMUReconMain;
import com.dataeconomy.migration.app.mysql.repository.BasketTempRepository;
import com.dataeconomy.migration.app.mysql.repository.DMUHistoryMainRepository;
import com.dataeconomy.migration.app.mysql.repository.DMUPgtyRepository;
import com.dataeconomy.migration.app.mysql.repository.DMUPtgyTempRepository;
import com.dataeconomy.migration.app.mysql.repository.DMUReconDetailRepository;
import com.dataeconomy.migration.app.mysql.repository.DMUReconMainRepository;
import com.dataeconomy.migration.app.mysql.repository.HistoryDetailRepository;
import com.dataeconomy.migration.app.util.Constants;
import com.google.common.collect.Lists;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DMUBasketService {

	@Autowired
	private BasketTempRepository basketTempRepository;

	@Autowired
	private DMUPgtyRepository dmuPgtyRepository;

	@Autowired
	private HDFSConnectionService hdfcConnectionService;

	@Autowired
	private DMUReconMainRepository reconMainRepository;

	@Autowired
	private HistoryDetailRepository historyDetailRepository;

	@Autowired
	private DMUReconDetailRepository dmuReconDetailRepository;

	@Autowired
	private DMUHistoryMainRepository dmuHistoryMainRepository;

	@Autowired
	private DMUPtgyTempRepository dmuPtgyRepository;

	public List<DMUBasketDto> getAllBasketDetails() {
		try {
			return Optional.ofNullable(basketTempRepository.findAll()).orElse(new ArrayList<>()).stream()
					.map(basketObj -> {
						return DMUBasketDto.builder().srNo(basketObj.getSrNo()).userId(basketObj.getUserId())
								.schemaName(basketObj.getSchemaName()).tableName(basketObj.getTableName())
								.filterCondition(basketObj.getFilterCondition())
								.targetS3Bucket(basketObj.getTargetS3Bucket())
								.incrementalFlag(basketObj.getIncrementalFlag()).requestType(basketObj.getRequestType())
								.incrementalClmn(basketObj.getIncrementalClmn()).labelName(basketObj.getLabelName())
								.build();
					}).collect(Collectors.toList());
		} catch (Exception exception) {
			return Collections.emptyList();
		}

	}

	@Transactional(rollbackFor = Exception.class)
	public synchronized boolean saveBasketDetails(List<DMUBasketDto> dmuBasketDtoList, String userName)
			throws DataMigrationException {
		try {

			Optional.ofNullable(dmuBasketDtoList).orElse(new ArrayList<>()).stream()
					.filter(basketDto -> basketDto.isAddtoBasket()).forEach(dmuBasketDto -> {
						basketTempRepository.save(
								DMUBasketTemp.builder().srNo(dmuBasketDto.getSrNo()).userId(dmuBasketDto.getUserId())
										.schemaName(dmuBasketDto.getSchemaName()).tableName(dmuBasketDto.getTableName())
										.filterCondition(dmuBasketDto.getFilterCondition())
										.targetS3Bucket(dmuBasketDto.getTargetS3Bucket())
										.incrementalFlag(dmuBasketDto.getIncrementalFlag())
										.requestType(dmuBasketDto.getRequestType())
										.incrementalClmn(dmuBasketDto.getIncrementalClmn())
										.labelName(dmuBasketDto.getLabelName()).build());
					});
			if (CollectionUtils.isNotEmpty(dmuBasketDtoList)) {
				dmuPgtyRepository.save(DMUPtgyTemp.builder()
						.id(DMUPtgyPK.builder().userId(dmuBasketDtoList.get(0).getUserId())
								.labelName(dmuBasketDtoList.get(0).getLabelName()).build())
						.tknztnEnabled(dmuBasketDtoList.get(0).isTknztnEnabled() ? Constants.YES : Constants.NO)
						.tknztnFilePath(dmuBasketDtoList.get(0).getTknztnFilePath()).build());
			}
			return true;
		} catch (Exception exception) {
			log.info(" Exception occured at DMUBasketService :: saveBasketDetails {} ",
					ExceptionUtils.getStackTrace(exception));
			throw new DataMigrationException("Unable to persist basket details to database ");
		}
	}

	@Transactional(rollbackFor = Exception.class)
	public synchronized boolean saveBasketDetailsAndPurge(List<DMUBasketDto> dmuBasketDtoList, String userName)
			throws DataMigrationException {
		log.info(" called => DMUBasketService :: saveBasketDetailsAndPurge " + dmuBasketDtoList.toString());
		try {
			Optional.ofNullable(dmuBasketDtoList).orElse(new ArrayList<>()).stream()
					.filter(basketDto -> basketDto.isAddtoBasket()).forEach(dmuBasketDto -> {
						dmuHistoryMainRepository.save(DMUHistoryMain.builder().userId(dmuBasketDto.getUserId())
								.requestedTime(LocalDateTime.now()).status(Constants.SUBMITTED)
								.requestType(dmuBasketDto.getRequestType()).requestNo(dmuBasketDto.getLabelName())
								.tknztnEnabled(dmuBasketDto.isTknztnEnabled() ? Constants.YES : Constants.NO)
								.tknztnFilePath(dmuBasketDto.getTknztnFilePath()).build());

						reconMainRepository.save(DMUReconMain.builder().userId(dmuBasketDto.getUserId())
								.requestedTime(LocalDateTime.now()).status(Constants.NOT_STARTED)
								.requestType(dmuBasketDto.getRequestType()).requestNo(dmuBasketDto.getLabelName())
								.build());

						historyDetailRepository.save(DMUHistoryDetail.builder()
								.dmuHIstoryDetailPK(DMUHIstoryDetailPK.builder().srNo(dmuBasketDto.getSrNo())
										.requestNo(dmuBasketDto.getLabelName()).build())
								.schemaName(dmuBasketDto.getSchemaName()).tableName(dmuBasketDto.getTableName())
								.filterCondition(dmuBasketDto.getFilterCondition())
								.targetS3Bucket(dmuBasketDto.getTargetS3Bucket())
								.incrementalFlag(dmuBasketDto.getIncrementalFlag())
								.incrementalClmn(dmuBasketDto.getIncrementalClmn()).status(Constants.SUBMITTED)
								.build());

						dmuReconDetailRepository.save(DMUReconDetail.builder()
								.dmuHIstoryDetailPK(DMUHIstoryDetailPK.builder().srNo(dmuBasketDto.getSrNo())
										.requestNo(dmuBasketDto.getLabelName()).build())
								.schemaName(dmuBasketDto.getSchemaName()).tableName(dmuBasketDto.getTableName())
								.filterCondition(dmuBasketDto.getFilterCondition())
								.targetS3Bucket(dmuBasketDto.getTargetS3Bucket())
								.incrementalFlag(dmuBasketDto.getIncrementalFlag())
								.incrementalColumn(dmuBasketDto.getIncrementalClmn()).status(Constants.NOT_STARTED)
								.build());
					});

			if (CollectionUtils.isNotEmpty(dmuBasketDtoList)) {
				dmuPgtyRepository.save(DMUPtgyTemp.builder()
						.id(DMUPtgyPK.builder().userId(dmuBasketDtoList.get(0).getUserId())
								.labelName(dmuBasketDtoList.get(0).getLabelName()).build())
						.tknztnEnabled(dmuBasketDtoList.get(0).isTknztnEnabled() ? Constants.YES : Constants.NO)
						.tknztnFilePath(dmuBasketDtoList.get(0).getTknztnFilePath()).build());
			}
			basketTempRepository.deleteById(userName);
			dmuPtgyRepository.deleteByRequestedUserName(userName);
			return true;
		} catch (Exception e) {
			throw new DataMigrationException("Unable to persist basket details to database ");
		}

	}

	public List<DMUBasketDto> getBasketDetailsByUserId(String userId) {
		try {
			return Optional.ofNullable(basketTempRepository.findAll()).orElse(new ArrayList<>()).stream()
					.map(basketObj -> {
						return DMUBasketDto.builder().srNo(basketObj.getSrNo()).userId(basketObj.getUserId())
								.schemaName(basketObj.getSchemaName()).tableName(basketObj.getTableName())
								.filterCondition(basketObj.getFilterCondition())
								.targetS3Bucket(basketObj.getTargetS3Bucket())
								.incrementalFlag(basketObj.getIncrementalFlag())
								.incrementalClmn(basketObj.getIncrementalClmn()).labelName(basketObj.getLabelName())
								.build();
					}).collect(Collectors.toList());
		} catch (Exception exception) {
			return Collections.emptyList();
		}
	}

	@Transactional
	public boolean purgeBasketDetailsByUserId(String userId) throws DataMigrationException {
		try {
			basketTempRepository.deleteById(userId);
			dmuPtgyRepository.deleteByRequestedUserName(userId);
			return true;
		} catch (Exception e) {
			throw new DataMigrationException("Unable to delete basket details ");
		}
	}

	public List<DMUBasketDto> getBasketDetailsBySearchParam(String searchParam) {
		try {
			return new JdbcTemplate(hdfcConnectionService.getValidDataSource(Constants.REGULAR))
					.query("USE " + searchParam + "; SHOW TABLES;", new ResultSetExtractor<List<DMUBasketDto>>() {

						@Override
						public List<DMUBasketDto> extractData(ResultSet rs) throws SQLException, DataAccessException {
							List<DMUBasketDto> dmuBasketDtoList = Lists.newArrayList();
							while (rs.next()) {
								Long i = 0L;
								dmuBasketDtoList.add(DMUBasketDto.builder().srNo(++i).schemaName(rs.getString(1))
										.tableName(rs.getString(1)).filterCondition(null)
										.targetS3Bucket(searchParam + "/" + rs.getString(1))
										.incrementalFlag(Constants.NO).incrementalClmn(null).build());
							}
							return dmuBasketDtoList;
						}
					});
		} catch (Exception exception) {
			return Collections.emptyList();
		}
	}

	@Transactional(rollbackFor = Exception.class)
	public boolean purgeBasketDetailsBySrNo(Long srNo) throws DataMigrationException {
		try {
			basketTempRepository.deleteBySrNo(srNo);
			return true;
		} catch (Exception exception) {
			throw new DataMigrationException("Unable to delete basket details ");
		}
	}

	@Transactional(rollbackFor = Exception.class)
	public boolean clearBasketDetails(String userName) throws DataMigrationException {
		try {
			basketTempRepository.deleteById(userName);
			dmuPtgyRepository.deleteByRequestedUserName(userName);
			return true;
		} catch (Exception exception) {
			throw new DataMigrationException("Unable to clear basket details " + exception);
		}
	}
}