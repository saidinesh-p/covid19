package com.easyway.covid19.service;

import com.easyway.covid19.model.Records;

import javax.ws.rs.core.Response;
import java.util.List;

public interface Covid19Service {
    Response getUserByUserName(String userName, String password);

    Response addUserInfo(String userInfo);

    Response logout(String userSessionToken);

    Response addRecordsDetails(List<Records> recordssObjectList);

    Response updateRecordsDetails(String recordsString);

    Response getRecordDetails(String state);

}
