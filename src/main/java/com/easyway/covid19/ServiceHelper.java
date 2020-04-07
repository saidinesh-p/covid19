package com.easyway.covid19;

import com.easyway.covid19.model.Records;
import com.easyway.covid19.model.User;
import com.easyway.covid19.model.UserObject;
import com.easyway.covid19.model.RecordsObject;
import com.easyway.covid19.model.UserSession;
import com.easyway.covid19.util.CommonUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.nio.charset.Charset;

public class ServiceHelper {

    private static final Charset UTF_8 = Charset.forName("UTF-8");

    private static final Log LOGGER = LogFactory.getLog(ServiceHelper.class);


    public UserSession buildUserSession(User user, String sessionId) throws Exception {
        UserSession userSession = new UserSession();
        userSession.setSessionToken(sessionId);
        userSession.setSessionStartTime(CommonUtil.getDateByTimeMills(System.currentTimeMillis()));
        userSession.setSessionExpiryTime(CommonUtil.getDateByTimeMills(System.currentTimeMillis() + 1000));
        userSession.setUserInfoId(user.getId());
        return userSession;
    }

    public User buildUser(UserObject userObject) throws Exception {
        User user = new User();
        user.setEmail(StringUtils.isNotBlank(userObject.getEmail()) ? userObject.getEmail() : null);
        user.setFirstName(StringUtils.isNotBlank(userObject.getFirstName()) ? userObject.getFirstName() : null);
        user.setLastName(StringUtils.isNotBlank(userObject.getLastName()) ? userObject.getLastName() : null);
        user.setUserName(userObject.getUserName());
        user.setPassword(CommonUtil.generateSHA512hash(userObject.getPassword()));
        return user;
    }

    public RecordsObject buildRecordsObject(Records records) {
        RecordsObject recordsObject = new RecordsObject();
        recordsObject.setId(records.getId());
        recordsObject.setState(records.getState());
        recordsObject.setTotal(records.getTotal());
        recordsObject.setActive(records.getActive());
        recordsObject.setRecovered(records.getRecovered());
        recordsObject.setDeaths(records.getDeaths());
        return recordsObject;
    }
}
