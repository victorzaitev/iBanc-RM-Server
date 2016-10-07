/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package md.ibanc.rm.util;

/**
 *
 * @author Zaițev.Victor
 */
public class FormatPassword {

    public static String CreatePassword(int id, String pass) {
        double token = id * 2.22;

        StringBuilder passwordBilder = new StringBuilder();

        passwordBilder.append(pass.substring(0, 2));
        passwordBilder.append(token);
        passwordBilder.append(pass.substring(2, pass.length()));
        return passwordBilder.toString();
    }
}
