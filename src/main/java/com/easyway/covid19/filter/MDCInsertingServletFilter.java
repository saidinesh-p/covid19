package com.easyway.covid19.filter;

import org.apache.log4j.Logger;
import org.apache.log4j.MDC;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


public class MDCInsertingServletFilter implements Filter {

    private static final Logger txnLogger = Logger.getLogger("txnlog");

    public static final String USER_MDC_KEY = "user";

    public static final String LOGBACK_CONTEXT_SELECTOR = "logback.ContextSelector";
    public static final String JNDI_CONFIGURATION_RESOURCE = "java:comp/env/logback/configuration-resource";
    public static final String JNDI_CONTEXT_NAME = "java:comp/env/logback/context-name";

    public static final int MAX_DOTS = 16;

    public static final int DEFAULT_MAX_CALLEDER_DATA_DEPTH = 8;

    public static final String REQUEST_REMOTE_HOST_MDC_KEY = "req.remoteHost";
    public static final String REQUEST_USER_AGENT_MDC_KEY = "req.userAgent";
    public static final String REQUEST_REQUEST_URI = "req.requestURI";
    public static final String REQUEST_QUERY_STRING = "req.queryString";
    public static final String REQUEST_REQUEST_URL = "req.requestURL";
    public static final String REQUEST_X_FORWARDED_FOR = "req.xForwardedFor";

    public static final String REQUEST_METHOD = "req.method";
    public static final String CONTENT_TYPE = "req.contenttype";
    public static final String TIMESTAMP = "timestamp";
    public static final String METHOD_PATH = "methodPath";
    public static final String APPLICATION = "application";

    private static final String Host = "Host";
    private static final String Connection = "Connection";
    private static final String AcceptEncoding = "Accept-Encoding";

    private static final String CLIENT_REMOTE_ADDRESS = "clientRemoteAddress";
    private static final String TRANSACTION_ID = "TRANSACTION_ID";

    public static final String GAFFER_CONFIGURATOR_FQCN = "ch.qos.logback.classic.gaffer.GafferConfigurator";

    public static final String FINALIZE_SESSION = "FINALIZE_SESSION";

    public void destroy() {
        // do nothing
    }

    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {

        insertIntoMDC(request);

        long start = System.currentTimeMillis();

        String application = "/covid19/";
        String userAgent = ((HttpServletRequest) request)
                .getHeader("User-Agent");
        String timeStampStart = new Date().toString();
        String httpMethod = ((HttpServletRequest) request).getMethod();
        txnLogger.info("TxnLogging - [txnmarker=TXNStart] [application="
                + application + "] [httpMethod=" + httpMethod + "] [timestamp="
                + timeStampStart + "] [user-agent=" + userAgent + "] ");
        try {
            txnLogger.info("Just here");
            if (response instanceof HttpServletResponse) {
                HttpServletResponse alteredResponse = ((HttpServletResponse) response);
                addCorsHeader(alteredResponse);
            }
            chain.doFilter(request, response);

        } finally {
            int status = ((HttpServletResponse) response).getStatus();
            String timeStampEnd = new Date().toString();
            long duration = System.currentTimeMillis() - start;

            txnLogger.info("TxnLogging - [txnmarker=TXNEnd] [application="
                    + application + "] [entity=Response Status:" + status
                    + "] [duration=" + duration + "] [status=" + status
                    + "] [timestamp=" + timeStampEnd + "]");
            MDC.clear();
        }

    }

    void addCorsHeader(HttpServletResponse response) {
        //TODO: externalize the Allow-Origin
        response.addHeader("Access-Control-Allow-Origin", "*");
        response.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE, HEAD");
        response.addHeader("Access-Control-Allow-Headers", "X-PINGOTHER, Origin, userName, sessionToken, userId, Content-Type, Accept");
        response.addHeader("Access-Control-Allow-Credentials", "true");
        response.addHeader("Access-Control-Max-Age", "1728000");
        response.addHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        response.addHeader("Pragma", "no-cache");
        response.addHeader("Expires", "0");
    }

    void insertIntoMDC(ServletRequest request) {

        if (request instanceof HttpServletRequest) {
            HttpServletRequest httpServletRequest = (HttpServletRequest) request;

            MDC.put("REQUEST_METHOD", httpServletRequest.getMethod());
            MDC.put("CLIENT_REMOTE_ADDRESS", request.getRemoteAddr());
            MDC.put("METHOD_PATH", httpServletRequest.getRequestURI()
                    .replaceAll("/covid19/", "/"));

            String generatedId = generateUniqueTransactionID();
            MDC.put("TRANSACTION_ID", generatedId);

        }

    }

    private String generateUniqueTransactionID() {
        Calendar date = new GregorianCalendar();
        long txid = date.getTimeInMillis();
        return Long.toString(txid);

    }

    public void init(FilterConfig arg0) throws ServletException {
        // do nothing
    }
}
