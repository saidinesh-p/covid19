package com.easyway.covid19.model;

import javax.xml.bind.annotation.adapters.XmlAdapter;


public class StatusCodeAdapter extends XmlAdapter<String, StatusCodeEnum>{

    public String marshal(StatusCodeEnum enumObject) {
        return enumObject.value();
    }

    public StatusCodeEnum unmarshal(String val) {
        return StatusCodeEnum.fromValue(val);
    }

}