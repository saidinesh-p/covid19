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
@XmlType(name = "UserResponse", propOrder = {
        "userObject",
        "result"
})
@XmlAccessorType(XmlAccessType.FIELD)
public class UserResponse extends StatusMessage {
    @XmlElement(name = "userObject", required = true)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    protected List<UserObject> userObjectList;

    @XmlElement(name = "result", required = true)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    protected Boolean result;


}
