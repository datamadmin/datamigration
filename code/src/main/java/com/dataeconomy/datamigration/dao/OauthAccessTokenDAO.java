package com.dataeconomy.datamigration.dao;

import com.dataeconomy.datamigration.models.dbo.OauthAccessToken;
import com.dataeconomy.framework.dao.BaseDAO;

public interface OauthAccessTokenDAO extends BaseDAO<OauthAccessToken, String>{
	
	public void deleteOauthTokenName(String userName);

}
