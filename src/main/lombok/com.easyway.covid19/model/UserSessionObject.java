package com.easyway.covid19.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.Date;

@Data
@XmlType(name = "UserSessionObject", propOrder = {
        "id",
        "sessionToken",
        "sessionStartTime",
        "sessionExpiryTime",
        "userInfoId"
})
@XmlAccessorType(XmlAccessType.FIELD)
public class UserSessionObject {

    @XmlElement(name = "id")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    protected Integer id;

    @XmlElement(name = "sessionToken")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    protected String sessionToken;

    @XmlElement(name = "sessionStartTime")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    protected Date sessionStartTime;

    @XmlElement(name = "sessionExpiryTime")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    protected Date sessionExpiryTime;

    @XmlElement(name = "userInfoId")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    protected UserObject userInfoId;

}
