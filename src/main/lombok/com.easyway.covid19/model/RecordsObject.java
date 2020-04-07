package com.easyway.covid19.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.Date;

@Data
@XmlType(name = "RecordsObject", propOrder = {
        "id",
        "state",
        "total",
        "active",
        "recovered",
        "deaths",
})
@XmlAccessorType(XmlAccessType.FIELD)
public class RecordsObject {

    @XmlElement(name = "id")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    protected Integer id;

    @XmlElement(name = "state")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    protected String state;

    @XmlElement(name = "total")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    protected Integer total;

    @XmlElement(name = "active")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    protected Integer active;

    @XmlElement(name = "recovered")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    protected Integer recovered;

    @XmlElement(name = "deaths")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    protected Integer deaths;

}
