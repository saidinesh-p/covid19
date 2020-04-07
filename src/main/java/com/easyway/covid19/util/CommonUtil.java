package com.easyway.covid19.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Date;

public class CommonUtil {

    public static String generateSHA512hash(String input) {
        String clientSecretHash =null;
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-512");
            digest.reset();
            digest.update(input.trim().getBytes("utf8"));
            clientSecretHash = String.format("%040x", new BigInteger(1, digest.digest()));

        } catch (Exception e) {
            e.printStackTrace();
        }
        return clientSecretHash;
    }

    public static Date getDateByTimeMills(long currentTimeMills) throws Exception {
        Date resultdate = new Date(currentTimeMills);
        return resultdate;
    }


}
