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
@XmlType(name = "RecordsResponse", propOrder = {
        "recordsObject",
        "result"
})
@XmlAccessorType(XmlAccessType.FIELD)
public class RecordsResponse extends StatusMessage {
    @XmlElement(name = "recordsObject", required = true)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    protected List<RecordsObject> recordsObjectList;

    @XmlElement(name = "result", required = true)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    protected Boolean result;


}
