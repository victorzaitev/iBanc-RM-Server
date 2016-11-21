/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package md.ibanc.rm.util;

/**
 *
 * @author PC01017745
 */
public class MaskHelper {

    /**
     * @param number The number in plain format
     * @param mask The mask pattern. Use # to include the digit from the
     * position. Use x to mask the digit at that position. Any other char will
     * be inserted.
     *
     * @return The masked card number
     */
    public static String maskNumber(String number, String mask) {

        int index = 0;
        StringBuilder masked = new StringBuilder();
        for (int i = 0; i < mask.length(); i++) {
            char c = mask.charAt(i);
            if (c == '#') {
                masked.append(number.charAt(index));
                index++;
            } else if (c == 'x') {
                masked.append(c);
                index++;
            } else {
                masked.append(c);
            }
        }
        return masked.toString();
    }

}
