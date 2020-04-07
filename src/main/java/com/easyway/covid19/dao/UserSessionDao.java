package com.easyway.covid19.dao;

import com.easyway.covid19.model.UserSession;
import org.apache.ibatis.annotations.Param;


public interface UserSessionDao {


    void createOrUpdateUser(UserSession userSession) throws Exception;

    void deleteUserSessionBySessionToken(String userSessionToken) throws Exception;

    UserSession getSessionBySessionToken(@Param("sessionToken") String sessionToken, @Param("userInfoId") int userInfoId) throws Exception;


}
