package com.easyway.covid19.service;


import com.easyway.covid19.ServiceHelper;
import com.easyway.covid19.dao.RecordsDao;
import com.easyway.covid19.dao.UserDao;
import com.easyway.covid19.dao.UserSessionDao;
import com.easyway.covid19.model.*;
import com.easyway.covid19.model.ErrorCodeEnum;
import com.easyway.covid19.model.LoginResponse;
import com.easyway.covid19.model.RecordsObject;
import com.easyway.covid19.model.StatusCodeEnum;
import com.easyway.covid19.model.StatusMessage;
import com.easyway.covid19.model.UserObject;
import com.easyway.covid19.model.UserResponse;
import com.easyway.covid19.model.RecordsResponse;
import com.easyway.covid19.model.UserSessionResponse;
import com.easyway.covid19.util.CommonUtil;
import com.easyway.covid19.util.Constants;
import com.easyway.covid19.util.RestUtil;
import com.google.inject.Inject;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import java.io.IOException;

import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import static com.easyway.covid19.util.RestUtil.*;

public class Covid19ServiceImpl implements Covid19Service {

    private static final Logger LOGGER = Logger.getLogger(Covid19ServiceImpl.class);

    @Inject
    private UserDao userDao;

    @Inject
    private RecordsDao recordsDao;

    @Inject
    private UserSessionDao userSessionDao;

    @Inject
    private ServiceHelper serviceHelper;



    @Override
    public Response getUserByUserName(String userName, String password) {
        LoginResponse loginResponse = new LoginResponse();
        try {
            String encryptedUserPassword = CommonUtil.generateSHA512hash(password);
            LOGGER.info("#######encryptedUserPassword####" + encryptedUserPassword);
            User user = userDao.getUserByUserNameAndPassword(userName, encryptedUserPassword);
            LOGGER.info("**********************" + encryptedUserPassword + "#####user password from Db###" + user);
            if (user != null && user.getPassword().equals(encryptedUserPassword)) {
                String sessionId = UUID.randomUUID().toString();
                UserSession userSession = serviceHelper.buildUserSession(user, sessionId);
                userSessionDao.createOrUpdateUser(userSession);
                loginResponse.setUserName(userName);
                loginResponse.setUserId(user.getId());
                loginResponse.setDescription("Successfully logged in");
                loginResponse.setResult(true);
                loginResponse.setCode(StatusCodeEnum.OK);
                loginResponse.setSessionId(sessionId);
                return processResponse(loginResponse);
            } else {
                loginResponse.setResult(true);
                loginResponse.setCode(StatusCodeEnum.ERROR);
                loginResponse.setDescription("Invalid userName or password");
                return processErrorResponseCode(loginResponse, ErrorCodeEnum.REQUEST_INVALID,
                        Constants.INVALID_USERNAME_AND_PASSWORD, LOGGER);
            }
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.info("Exception occured while communicating with Database with exception :{} " + e);
            String error = "Something went wrong,please try again later";
            return processErrorResponse(new UserSessionResponse(), ErrorCodeEnum.SERVICE_ERROR, error, LOGGER);
        }
    }


    @Override
    public Response addUserInfo(String userInfo) {
        UserResponse userResponse = new UserResponse();
        try {
            UserObject userObject = (UserObject) RestUtil.readObject(userInfo, UserObject.class);
            if (StringUtils.isBlank(userObject.getEmail())
                    || StringUtils.isBlank(userObject.getUserName()) || StringUtils.isBlank(userObject.getPassword())) {
                return processErrorResponseCode(userResponse, ErrorCodeEnum.REQUEST_INVALID,
                        Constants.REQUIRED_FIELD_NOT_NULL, LOGGER);
            }
            User user = serviceHelper.buildUser(userObject);
            userDao.addUserInfo(user);
            User user1 = userDao.getUserByUserName(user.getUserName());
            LOGGER.info("*********************" + user1);
            userResponse.setCode(StatusCodeEnum.OK);
            userResponse.setDescription("Successfully added User details");
            userResponse.setResult(true);
        } catch (Exception e) {
            e.printStackTrace();
            String exception = null;
            if (e.getCause() != null) {
                exception = RestUtil.getExceptionMessage(e.getCause());
            }
            if (StringUtils.isNotBlank(exception) && exception.contains("Duplicate entry")) {
                LOGGER.info("Exception occured due to uniqueKeyconstraint  :{}" + e);
                String error = "The userName already exists,Please try with different userNName";
                return processErrorResponseCode(new UserResponse(), ErrorCodeEnum.DUPLICATE_ENTRY, error, LOGGER);
            }
            LOGGER.info("Exception occured while communicating with database with exception :{}" + e);
            String error = "Something went wrong,please try again later";
            return processErrorResponse(new UserResponse(), ErrorCodeEnum.SERVICE_ERROR, error, LOGGER);
        }
        return processResponse(userResponse);
    }

    @Override
    public Response logout(String userSessionToken) {
        UserSessionResponse userSessionResponse = new UserSessionResponse();

        try {
            userSessionDao.deleteUserSessionBySessionToken(userSessionToken);
            userSessionResponse.setResult(true);
            userSessionResponse.setDescription("Successfully deleted userSession");
            userSessionResponse.setCode(StatusCodeEnum.OK);
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.info("Exception occured while communicating with Database with exception :{} " + e);
            String error = "Something went wrong,please try again later";
            return processErrorResponse(new UserSessionResponse(), ErrorCodeEnum.SERVICE_ERROR, error, LOGGER);
        }
        return processResponse(userSessionResponse);
    }

    @Override
    public Response addRecordsDetails(List<Records> recordsObjectList) {
        RecordsResponse recordsResponse = new RecordsResponse();
        boolean isAdded = false;

        try {

            for (Records records : recordsObjectList) {

                recordsDao.addRecordDetails(records);
                isAdded = true;
            }
            recordsResponse.setCode(StatusCodeEnum.OK);
            recordsResponse.setResult(true);
            recordsResponse.setDescription("Successfully added the Record details");
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.info("Exception occured while communicating with Database with exception :{} " + e);
            String error = "unable to add policy details";
            return processErrorResponse(new RecordsResponse(), ErrorCodeEnum.ERROR, error, LOGGER);
        }
        return processResponse(recordsResponse);
    }

    @Override
    public Response updateRecordsDetails(String recordsString) {
        RecordsResponse recordsResponse = new RecordsResponse();
        try {
            Records records = (Records) RestUtil.readObject(recordsString, Records.class);
            /*String state=records.getState();*/
            recordsDao.updateRecordDetails(records);
            recordsResponse.setCode(StatusCodeEnum.OK);
            recordsResponse.setResult(true);
            recordsResponse.setDescription("Successfully updated the record details");

            return processResponse(recordsResponse);
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.info("Exception occured while communicating with Database with exception :{} " + e);
            String error = "unable to update record details";
            return processErrorResponse(new RecordsResponse(), ErrorCodeEnum.ERROR, error, LOGGER);
        }

    }

    @Override
    public Response getRecordDetails(String state) {
        new RecordsResponse();
        RecordsResponse recordsResponse;
        List<Records> recordsObjectList = new ArrayList<>();
        try{
            LOGGER.info("#########getRecordDetails by state####" + state);
            List<Records> recordsList = recordsDao.getRecordDetails(state);
            recordsResponse = getRecordsObjectResponse(recordsList);

            return processResponse(recordsResponse);



        } catch (Exception e) {
            e.printStackTrace();

            LOGGER.info("Exception occured while communicating with Database with exception :{} " + e);
            String error = "unable to get record details";
            return processErrorResponse(new RecordsResponse(), ErrorCodeEnum.ERROR, error, LOGGER);
        }
    }

    public RecordsResponse getRecordsObjectResponse(List<Records> recordsList)  throws Exception {
        RecordsResponse recordsResponse = new RecordsResponse();
        RecordsObject recordsObjectForResponse = null;
        List<RecordsObject> recordsObjectsList = new ArrayList<>();
        for (Records records : recordsList) {
           recordsObjectForResponse = serviceHelper.buildRecordsObject(records);
            recordsObjectsList.add(recordsObjectForResponse);
        }
        recordsResponse.setResult(true);
        recordsResponse.setCode(StatusCodeEnum.OK);
        recordsResponse.setRecordsObjectList(recordsObjectsList);
        return recordsResponse;
    }
}
