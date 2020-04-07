
package com.easyway.covid19.model;


import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ErrorCodeEnum.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ErrorCodeEnum"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="COMMUNICATION_ERROR"/&gt;
 *     &lt;enumeration value="UNKNOWN_ERROR"/&gt;
 *     &lt;enumeration value="REQUEST_INVALID"/&gt;
 *     &lt;enumeration value="UNSUPPORTED_REQUEST"/&gt;
 *     &lt;enumeration value="AUTH_TOKEN_NOT_FOUND"/&gt;
 *     &lt;enumeration value="AUTH_TOKEN_INVALIDATED_BY_LOGOUT"/&gt;
 *     &lt;enumeration value="AUTH_TOKEN_EXPIRED"/&gt;
 *     &lt;enumeration value="AUTH_LOGIN_FAILURE"/&gt;
 *     &lt;enumeration value="SERVICE_ERROR"/&gt;
 *     &lt;enumeration value="DATA_NOT_FOUND"/&gt;
 *     &lt;enumeration value="SERVICE_ACTION_FAILED"/&gt;
 *     &lt;enumeration value="VIDEO_SESSION_LIMIT_EXCEEDED"/&gt;
 *     &lt;enumeration value="ACCOUNT_NOT_ENTITLED"/&gt;
 *     &lt;enumeration value="DUPLICATE_WATCHLIST_ERROR"/&gt;
 *     &lt;enumeration value="ACCOUNT_STANDING_ERROR"/&gt;
 *     &lt;enumeration value="WHITE_LIST_ACCOUNT_NOT_FOUND_ERROR"/&gt;
 *     &lt;enumeration value="MINIMUM_SUBSCRIPTION_ERROR"/&gt;
 *     &lt;enumeration value="MAX_ATTEMPTS_LIMIT_EXCEEDED"/&gt;
 *     &lt;enumeration value="NOT_BEHIND_MODEM"/&gt;
 *     &lt;enumeration value="USER_NAME_NOT_AVAILABLE"/&gt;
 *     &lt;enumeration value="HOH_EMAIL_FOUND"/&gt;
 *     &lt;enumeration value="STB_IDENTIFIED_BY_MAC_NOT_FOUND"/&gt;
 *     &lt;enumeration value="STB_RESUME_REQUEST_TIMED_OUT"/&gt;
 *     &lt;enumeration value="OPERATION_TIMED_OUT"/&gt;
 *     &lt;enumeration value="ERROR_SCHEDULING_DVR_RECORDING"/&gt;
 *     &lt;enumeration value="DVR_NOT_ENABLED_ON_STB"/&gt;
 *     &lt;enumeration value="ACG_INTERNAL_ERROR"/&gt;
 *     &lt;enumeration value="MOUNTAIN_STATES_LOGIN_ERROR"/&gt;
 *     &lt;enumeration value="DEVICE_NOT_ENTITLED"/&gt;
 *     &lt;enumeration value="OUT_OF_REGION"/&gt;
 *     &lt;enumeration value="STREAM_NOT_ALLOWED_OFFNET"/&gt;
 *     *     &lt;enumeration value="ERROR"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "ErrorCodeEnum")
@XmlEnum
public enum ErrorCodeEnum {

    REQUEST_ACCESS_DENIED,
    COMMUNICATION_ERROR,
    UNKNOWN_ERROR,
    REQUEST_INVALID,
    UNSUPPORTED_REQUEST,
    AUTH_TOKEN_NOT_FOUND,
    AUTH_TOKEN_INVALIDATED_BY_LOGOUT,
    AUTH_TOKEN_EXPIRED,
    AUTH_LOGIN_FAILURE,
    SERVICE_ERROR,
    DATA_NOT_FOUND,
    SERVICE_ACTION_FAILED,
    VIDEO_SESSION_LIMIT_EXCEEDED,
    ACCOUNT_NOT_ENTITLED,
    DUPLICATE_WATCHLIST_ERROR,
    ACCOUNT_STANDING_ERROR,
    WHITE_LIST_ACCOUNT_NOT_FOUND_ERROR,
    MINIMUM_SUBSCRIPTION_ERROR,
    MAX_ATTEMPTS_LIMIT_EXCEEDED,
    NOT_BEHIND_MODEM,
    USER_NAME_NOT_AVAILABLE,
    HOH_EMAIL_FOUND,
    STB_IDENTIFIED_BY_MAC_NOT_FOUND,
    STB_RESUME_REQUEST_TIMED_OUT,
    OPERATION_TIMED_OUT,
    ERROR_SCHEDULING_DVR_RECORDING,
    DVR_NOT_ENABLED_ON_STB,
    ACG_INTERNAL_ERROR,
    MOUNTAIN_STATES_LOGIN_ERROR,
    DEVICE_NOT_ENTITLED,
    OUT_OF_REGION,
    STREAM_NOT_ALLOWED_OFFNET,
    ERROR,
    DUPLICATE_ENTRY,
    PLEASE_CHECK_TERMS_AND_CONDITIONS;
    public String value() {
        return name();
    }

    public static ErrorCodeEnum fromValue(String v) {
        return valueOf(v);
    }

}
