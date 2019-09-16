package com.dataeconomy.datamigration.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.dataeconomy.datamigration.models.userConfig.User;
import com.dataeconomy.framework.dao.BaseDAOImpl;
import com.dataeconomy.workbench.constant.UserStatus;

/**
 * 
 * @author Guvala
 *
 */
@Repository
public class UserDAOImpl extends BaseDAOImpl<User, Long> implements UserDAO {

	public UserDAOImpl() {
		super(User.class);
	}

	@Override
	public User getUser(String uname) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<User> cQuery = builder.createQuery(User.class);
		Root<User> user = cQuery.from(User.class);
		cQuery.select(user).where(
				builder.or(builder.equal(user.get("userName"), uname), builder.equal(user.get("userEmail"), uname)));
		List<User> userList = entityManager.createQuery(cQuery).getResultList();
		if (null != userList && !userList.isEmpty()) {
			return userList.get(0);
		} else {
			return null;
		}
	}

	@Override
	public boolean uniqueUserName(String userName) {
		TypedQuery<Long> query = entityManager
				.createQuery("SELECT count(u) from User u where userName ='" + userName + "'", Long.class);
		if (query.getSingleResult() == 0) {
			return false;
		} else {
			return true;
		}

	}

	@Override
	public boolean uniqueUserEmail(String email) {
		TypedQuery<Long> query = entityManager
				.createQuery("SELECT count(u) from User u where userEmail ='" + email + "'", Long.class);
		if (query.getSingleResult() == 0) {
			return false;
		} else {
			return true;
		}

	}

	@Override
	public boolean uniqueUserEmail(String email, String userId) {
		TypedQuery<Long> query = entityManager.createQuery(
				"SELECT count(u) from User u where userEmail ='" + email + "' and userId != '" + userId + "'",
				Long.class);
		if (query.getSingleResult() == 0) {
			return false;
		} else {
			return true;
		}

	}

	@Override
	public void resetpwd(Long userid, String salt, String hash) {
		User user = findOne(userid);
		user.setUserSalt(salt);
		user.setPasswordHash(hash);
		update(user);
	}

	@Override
	public void unlockUser(Long userid) {
		User user = findOne(userid);
		if (user.getUserStatus().equals(Integer.valueOf(UserStatus.USER_LOCKED.value))) {
			user.setLoginAttempts(0);
			user.setUserStatus(UserStatus.USER_ENABLED.value);
			update(user);
		}
	}

	@Override
	public void updateUserGroup(Long userId, int groupid) {
		User user = findOne(userId);
		user.setGroupid(groupid);
		update(user);
	}

	

	@Override
	public List<String> getTaskAccessRights(Integer groupId) {
		List<String> taskAccessRigts = new ArrayList<String>();
		Query query = entityManager.createQuery(
				"select hs.partnerName,hs.fileName,hs.entityFileTypeId from HsSecurityAccess hs where hs.groupId = ?1 group by hs.partnerName,hs.fileName,hs.entityFileTypeId");
		query.setParameter(1, groupId);
		List<Object[]> queryResults = query.getResultList();
		for (Object[] result : queryResults) {
			// Include Partner name, File Name, EntityFileTypeID
			taskAccessRigts.add(result[0].toString().concat("_").concat(result[1].toString()).concat("_")
					.concat(result[2].toString()));
			// Include Partner name , File Name , -EntityFileTypeID for tasks
			// created in BDW
			taskAccessRigts.add(result[0].toString().concat("_").concat(result[1].toString()).concat("_").concat("-")
					.concat(result[2].toString()));
		}
		return taskAccessRigts;
	}

	// To get users based on groupId
	@Override
	public List<Long> getUsers(Integer groupId) {
		TypedQuery<Long> query = entityManager.createQuery("select userId from User where groupid = :groupID",
				Long.class);
		query.setParameter("groupID", groupId);
		return query.getResultList();
	}

	// To get users based on groupId
	@Override
	public List<User> getUsersList(Integer groupId) {
		TypedQuery<User> query = entityManager.createQuery("from User where groupid = :groupID", User.class);
		query.setParameter("groupID", groupId);
		return query.getResultList();
	}

	@Override
	public List<String> getUserNames() {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<String> query = cb.createQuery(String.class);
		Root<User> root = query.from(User.class);
		query.distinct(true).select(root.<String> get("userName"));
		return this.entityManager.createQuery(query).getResultList();
	}

	@Override
	public List<User> getUsersList() {
		TypedQuery<User> query = entityManager.createQuery("from User where sadmin = false and admin = false ",
				User.class);
		return query.getResultList();
	}

	@Override
	public List<String> getAllDGOs() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<String> query = builder.createQuery(String.class);
		Root<User> categoryRoot = query.from(User.class);
		query.select(categoryRoot.get("userEmail")).where(builder.equal(categoryRoot.get("dgo"), true));
		return entityManager.createQuery(query).getResultList();
	}
	
	
	@Override
	public boolean checkRoleNameAssigendOrNot(Integer roleId) {
		TypedQuery<Long> query = entityManager
				.createQuery("SELECT count(u) from User u where roleId ='" + roleId + "'", Long.class);
		if (query.getSingleResult() == 0) {
			return false;
		} else {
			return true;
		}

	}
	
	public List<User> checkOrgIdAssinedOrNot(List<Long> ids) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
		Root<User> root = criteriaQuery.from(User.class);
		criteriaQuery.select(root).where(criteriaBuilder.in(root.get("orgId")).value(ids));
		return entityManager.createQuery(criteriaQuery).getResultList();
	}
	
	@Override
	public List<User> getUserIdNameByRoleId(Integer roleId)
	{
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
		Root<User> root = criteriaQuery.from(User.class);
		criteriaQuery.multiselect((root.get("userId")), root.get("userName")).distinct(true);
		criteriaQuery.where(criteriaBuilder.equal(root.get("roleId"), roleId));
		return entityManager.createQuery(criteriaQuery).getResultList();
	}
	
	
}
