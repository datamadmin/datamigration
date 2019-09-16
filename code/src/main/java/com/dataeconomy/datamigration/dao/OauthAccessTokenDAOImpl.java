package com.dataeconomy.datamigration.dao;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.dataeconomy.datamigration.models.dbo.OauthAccessToken;
import com.dataeconomy.framework.dao.BaseDAOImpl;

@Repository
public class OauthAccessTokenDAOImpl extends BaseDAOImpl<OauthAccessToken, String> implements OauthAccessTokenDAO {

	public OauthAccessTokenDAOImpl() {
		super(OauthAccessToken.class);
	}

	public void deleteOauthTokenName(String userName) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaDelete<OauthAccessToken> delete = criteriaBuilder.createCriteriaDelete(OauthAccessToken.class);
		Root<OauthAccessToken> oauthAccessToken = delete.from(OauthAccessToken.class);
		delete.where(criteriaBuilder.equal(oauthAccessToken.get("userName"), userName));
		Query query = entityManager.createQuery(delete);
		query.executeUpdate();
	}
}
