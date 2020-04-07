package com.easyway.covid19.model;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for StatusCodeEnum.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="StatusCodeEnum"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="Ok"/&gt;
 *     &lt;enumeration value="Warn"/&gt;
 *     &lt;enumeration value="Error"/&gt;
 *     &lt;enumeration value="Unknown"/&gt;
 *     &lt;enumeration value="DVR_NOT_REACHABLE"/&gt;
 *     &lt;enumeration value="NO_TARGET_PROGRAM_EXISTS"/&gt;
 *     &lt;enumeration value="SCHEDULE_CONFLICT"/&gt;
 *     &lt;enumeration value="DVR_IS_FULL"/&gt;
 *     &lt;enumeration value="CONFLICT_RESOLUTION_IN_PROGRESS"/&gt;
 *     &lt;enumeration value="DVR_NOT_READY"/&gt;
 *     &lt;enumeration value="ALREADY_SCHEDULED"/&gt;
 *     &lt;enumeration value="PPV_PROGRAM_NOT_PURCHASED"/&gt;
 *     &lt;enumeration value="INVALID_PARAMETER"/&gt;
 *     &lt;enumeration value="NO_PROGRAMS_SCHEDULED"/&gt;
 *     &lt;enumeration value="NO_SUBSCRIPTION_TO_CHANNEL"/&gt;
 *     &lt;enumeration value="NO_EPG_AVAILABLE_FOR_PROGRAM"/&gt;
 *     &lt;enumeration value="AMS_ERROR"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "StatusCodeEnum")
@XmlEnum
public enum StatusCodeEnum {

    @XmlEnumValue("Ok")
    OK("Ok"),
    @XmlEnumValue("Warn")
    WARN("Warn"),
    @XmlEnumValue("Error")
    ERROR("Error"),
    @XmlEnumValue("Unknown")
    UNKNOWN("Unknown"),
    DVR_NOT_REACHABLE("DVR_NOT_REACHABLE"),
    NO_TARGET_PROGRAM_EXISTS("NO_TARGET_PROGRAM_EXISTS"),
    SCHEDULE_CONFLICT("SCHEDULE_CONFLICT"),
    DVR_IS_FULL("DVR_IS_FULL"),
    CONFLICT_RESOLUTION_IN_PROGRESS("CONFLICT_RESOLUTION_IN_PROGRESS"),
    DVR_NOT_READY("DVR_NOT_READY"),
    ALREADY_SCHEDULED("ALREADY_SCHEDULED"),
    PPV_PROGRAM_NOT_PURCHASED("PPV_PROGRAM_NOT_PURCHASED"),
    INVALID_PARAMETER("INVALID_PARAMETER"),
    NO_PROGRAMS_SCHEDULED("NO_PROGRAMS_SCHEDULED"),
    NO_SUBSCRIPTION_TO_CHANNEL("NO_SUBSCRIPTION_TO_CHANNEL"),
    NO_EPG_AVAILABLE_FOR_PROGRAM("NO_EPG_AVAILABLE_FOR_PROGRAM"),
    AMS_ERROR("AMS_ERROR");
    private final String value;

    StatusCodeEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static StatusCodeEnum fromValue(String v) {
        for (StatusCodeEnum c: StatusCodeEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
