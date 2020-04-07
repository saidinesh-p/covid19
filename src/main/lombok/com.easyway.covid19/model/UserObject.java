package com.easyway.covid19.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.Date;

@Data
@XmlType(name = "UserObject", propOrder = {
        "id",
        "firstName",
        "lastName",
        "email",
        "userName",
        "password"
})
@XmlAccessorType(XmlAccessType.FIELD)
public class UserObject {

    @XmlElement(name = "id")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    protected Integer id;

    @XmlElement(name = "firstName")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    protected String firstName;

    @XmlElement(name = "lastName")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    protected String lastName;

    @XmlElement(name = "email")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    protected String email;

    @XmlElement(name = "userName")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    protected String userName;

    @XmlElement(name = "password")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    protected String password;

}
