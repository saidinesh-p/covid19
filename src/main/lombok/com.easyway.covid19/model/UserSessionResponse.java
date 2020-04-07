package com.easyway.covid19.model;

import com.easyway.covid19.model.StatusMessage;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

@Data
@XmlType(name = "UserSessionResponse", propOrder = {
        "userSessionObject",
        "result"
})
@XmlAccessorType(XmlAccessType.FIELD)
public class UserSessionResponse extends StatusMessage {
    @XmlElement(name = "userSessionObject", required = true)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    protected List<UserSessionObject> userSessionObjectList;

    @XmlElement(name = "result", required = true)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    protected Boolean result;


}
