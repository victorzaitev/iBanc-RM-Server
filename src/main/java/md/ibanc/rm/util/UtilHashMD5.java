/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package md.ibanc.rm.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author Zaițev.Victor
 */
public class UtilHashMD5 {

    public static String createMD5Hash(String strToHash) {
        String hashedStr = null;

        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(strToHash.getBytes(), 0, strToHash.length());
            hashedStr = new BigInteger(1, messageDigest.digest()).toString(16);
        } catch (NoSuchAlgorithmException ex) {

        }

        while (hashedStr.length() < 32) {
            hashedStr = "0" + hashedStr;
        }
        return new String(hashedStr.getBytes());
    }
}
