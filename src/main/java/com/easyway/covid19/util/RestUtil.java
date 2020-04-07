package com.easyway.covid19.util;


import com.easyway.covid19.model.ErrorCodeEnum;
import com.easyway.covid19.model.Message;
import com.easyway.covid19.model.Error;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.AnnotationIntrospector;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.xc.JaxbAnnotationIntrospector;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.UriInfo;

import java.io.IOException;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class RestUtil {

    /** The Constant logger. */
    private static final Logger logger = Logger.getLogger(RestUtil.class);

    /** The request headers. */
    public static String[] REQUEST_HEADERS = { "if-none-match" };

    /** The response headers. */
    public static String[] RESPONSE_HEADERS = { "etag", "cache-control",
            "last-modified" };

    /**
     * Process cache response.
     *
     * @param message
     *            the message
     * @return the response
     */
    public static Response processCacheResponse(Message message) {

        return Response.status(304).entity(message).build();
    }

    /**
     * Process response.
     *
     * @param message
     *            the message
     * @param headers
     *            the headers
     * @return the response
     */
    public static Response processResponse(Message message,
                                           Map<String, String> headers) {

        ResponseBuilder builder = Response.ok(message);
        if (headers != null)
            for (Entry<String, String> entry : headers.entrySet()) {
                builder.header(entry.getKey(), entry.getValue());
            }

        return builder.build();
    }

    /**
     * Process response.
     *
     * @param status
     *            the status
     * @param message
     *            the message
     * @param type
     *            the type
     * @param headers
     *            the headers
     * @return the response
     */
    public static Response processResponse(int status, Message message,
                                           Class<? extends Message> type, Map<String, String> headers) {

        ResponseBuilder builder = Response.status(status);
        builder.entity(type.cast(message));

        if (headers != null)
            for (Entry<String, String> entry : headers.entrySet()) {
                builder.header(entry.getKey(), entry.getValue());
            }

        return builder.build();
    }

    /**
     * Process response.
     *
     * @param message
     *            the message
     * @return the response
     */
    public static Response processResponse(Message message) {

        ResponseBuilder builder = Response.ok(message);
        return builder.build();
    }

    /**
     * Process response.
     *
     * @param message
     *            the message
     * @return the response
     */
    public static Response processUnAuthorizedResponse(String message) {

        return Response.status(401).entity(message).build();
    }

    /**
     * Process error response.
     *
     * @param message
     *            the message
     * @param errorCode
     *            the error code
     * @param errorMessage
     *            the error message
     * @param logger
     *            the logger
     * @return the response
     */
    public static Response processErrorResponse(Message message,
                                                ErrorCodeEnum errorCode, String errorMessage, Logger logger) {

        addError(null, message, errorCode, errorMessage);
        if (logger != null) {
            logger.error(errorCode + ": " + errorMessage);
        }
        return Response.status(500).entity(message).build();
    }

    /**
     * Process error response.
     *
     * @param exception
     *            the exception
     * @param message
     *            the message
     * @param logger
     *            the logger
     * @return the response
     */
    public static Response processErrorResponse(Exception exception,
                                                Message message, Logger logger) {

        addError(exception, message, ErrorCodeEnum.SERVICE_ERROR, null);
        if (logger != null) {
            logger.error("Error", exception);
        }
        return Response.status(500).entity(message).build();
    }

    public static Response processErrorResponseCode(Message message,
                                                    ErrorCodeEnum errorCode, String errorMessage, Logger logger) {

        addError(null, message, errorCode, errorMessage);
        if (logger != null) {
            logger.error(errorCode + ": " + errorMessage);
        }
        return Response.status(200).entity(message).build();
    }

    /**
     * Adds the error.
     *
     * @param message
     *            the message
     * @param errorCode
     *            the error code
     * @param errorMessage
     *            the error message
     * @return the message
     */
    public static Message addError(Message message, ErrorCodeEnum errorCode,
                                   String errorMessage) {
        return addError(null, message, errorCode, errorMessage);
    }

    /**
     * Adds the error.
     *
     * @param exception
     *            the exception
     * @param message
     *            the message
     * @param errorCode
     *            the error code
     * @param errorMessage
     *            the error message
     * @return the message
     */
    private static Message addError(Exception exception, Message message,
                                    ErrorCodeEnum errorCode, String errorMessage) {

        message.setError(Lists.newArrayList(createError(exception, errorCode,
                errorMessage)));
        return message;
    }

    /**
     * Creates the error.
     *
     * @param exception
     *            the exception
     * @param defaultCode
     *            the default code
     * @param message
     *            the message
     * @return the error
     */
    private static Error createError(Exception exception,
                                     ErrorCodeEnum defaultCode, String message) {
        Error error = new Error();

        ErrorCodeEnum code = getErrorCodeForException(exception, defaultCode);
        error.setCode(code);

        List<String> messages = error.getMessage();
        addMessages(messages, exception, message);
        error.setTimestamp(new Date().getTime());
        return error;
    }

    /**
     * Creates a list of messages to include in an error response Adds each
     * message from the exception stack.
     *
     * @param messageList
     *            The message list to add messages to
     * @param exception
     *            The exception being processed
     * @param message
     *            A message to add to the top of the message list (optional)
     */
    private static void addMessages(List<String> messageList,
                                    Exception exception, String message) {
        if (StringUtils.isNotBlank(message)) {
            messageList.add(message);
        }
        if (exception != null) {
            String msg = getExceptionMessage(exception);
            Throwable t;
            Throwable last = exception;
            while (StringUtils.isNotBlank(msg)) {
                messageList.add(msg);
                t = last.getCause();
                if (t != null && t != last) {
                    msg = getExceptionMessage(t);
                } else {
                    msg = null;
                }
                last = t;
            }
        }
    }

    /**
     * Gets the message from the the exception, or the name of the exception if
     * no message.
     *
     * @param t
     *            Assumed not <code>null</code>.
     * @return Never blank.
     */
    public static String getExceptionMessage(Throwable t) {

        String msg = t.getLocalizedMessage();
        if (StringUtils.isBlank(msg)) {
            msg = t.getClass().getSimpleName();
        }
        if (StringUtils.isBlank(msg)) {
            msg = t.getClass().getName();
        }
        return msg;
    }

    /**
     * Specifies the error code to return for a given exception.
     *
     * @param exception
     *            The exception to be mapped
     * @param defaultCode
     *            The error code to be used
     * @return The error code to use
     */
    private static ErrorCodeEnum getErrorCodeForException(Exception exception,
                                                          ErrorCodeEnum defaultCode) {
        ErrorCodeEnum result = null;
        if (exception != null) {
            Throwable cause = exception;
            do {
                result = ErrorCodeEnum. REQUEST_ACCESS_DENIED;
                cause = cause.getCause();
            } while (result == null && cause != null);
        }
        if (result != null) {
            return result;
        }
        if (defaultCode != null) {
            return defaultCode;
        }
        return ErrorCodeEnum.SERVICE_ACTION_FAILED;
    }

    /**
     * Read object.
     *
     * @param response
     *            the response
     * @param obj
     *            the obj
     * @return the object
     * @throws JsonParseException
     *             the json parse exception
     * @throws JsonMappingException
     *             the json mapping exception
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    public static Object readObject(String response, Class<?> obj)
            throws JsonParseException, JsonMappingException, IOException {

        ObjectMapper mapper = new ObjectMapper();
        AnnotationIntrospector introspector = new JaxbAnnotationIntrospector();
        mapper.setAnnotationIntrospector(introspector);
        return mapper.readValue(response, obj);
    }

    public static String writeValueAsString(List obj)
            throws JsonParseException, JsonMappingException, IOException {

        ObjectMapper mapper = new ObjectMapper();
        AnnotationIntrospector introspector = new JaxbAnnotationIntrospector();
        mapper.setAnnotationIntrospector(introspector);
        return mapper.writeValueAsString(obj);
    }

    /**
     * Gets the query params.
     *
     * @param info
     *            the info
     * @return the query params
     */
    public static Map<String, String> getQueryParams(UriInfo info) {
        MultivaluedMap<String, String> parameters = info.getQueryParameters();

        return getParams(parameters);
    }

    /**
     * Gets the params.
     *
     * @param parameters
     *          the parameters
     * @return the params
     */
    public static Map<String, String> getParams(
            MultivaluedMap<String, String> parameters) {
        Map<String, String> params = new HashMap<String, String>();
        for (Entry<String, List<String>> entry : parameters.entrySet()) {
            String key = entry.getKey();
            String value = parameters.getFirst(key);

            if (key != null && key.startsWith("\""))
                key = key.substring(1);
            else if (key != null && key.length() > 0 && key.endsWith("\""))
                key = key.substring(0, key.length() - 1);
            if (value != null && value.startsWith("\""))
                value = value.substring(1);
            else if (value != null && value.length() > 0
                    && value.endsWith("\""))
                value = value.substring(0, value.length() - 1);

            if (value != null) {
                params.put(key, value);
            }
        }

        logger.info("Params: " + params.toString());
        return params;
    }

    /**
     * Gets the parameters string.
     *
     * @param parameters
     *            the parameters
     * @return the parameters string
     */
    public static String getParametersString(Map<String, String> parameters) {

        String requestBody = "";
        Iterator<Entry<String, String>> entries = parameters.entrySet()
                .iterator();
        while (entries.hasNext()) {
            Entry<String, String> entry = entries.next();
            String key = entry.getKey();
            String value = parameters.get(key);
            if (value != null) {
                requestBody = requestBody + key + "=" + value;
                if (entries.hasNext()) {
                    requestBody = requestBody + "&";
                }
            }
        }
        return requestBody;
    }

    /**
     * Gets the headers.
     *
     * @param request
     *            the request
     * @return the headers
     */
    public static Map<String, String> getHeaders(HttpServletRequest request) {
        Map<String, String> headers = new HashMap<String, String>();

        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {

            String headerName = headerNames.nextElement();
            String value = request.getHeader(headerName);
            if (value != null) {
                headers.put(headerName, value);
            }
        }
        logger.info("Request Headers: " + headers.toString());
        return headers;
    }
}

