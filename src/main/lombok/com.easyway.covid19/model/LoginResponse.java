package com.easyway.covid19.model;

import com.easyway.covid19.model.StatusMessage;
import com.easyway.covid19.model.UserObject;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

@Data
@XmlType(name = "LoginResponse", propOrder = {
        "userObject",
        "result"
})
@XmlAccessorType(XmlAccessType.FIELD)
public class LoginResponse extends StatusMessage {

       @XmlElement(name = "sessionId", required = true)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    protected String sessionId;


    @XmlElement(name = "userObject", required = true)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    protected UserObject userObject;

    @XmlElement(name = "result", required = true)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    protected Boolean result;

    @XmlElement(name = "description", required = true)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    protected String description;

    @XmlElement(name = "userId", required = true)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    protected int userId;

    @XmlElement(name = "userName", required = true)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    protected String userName;



}
