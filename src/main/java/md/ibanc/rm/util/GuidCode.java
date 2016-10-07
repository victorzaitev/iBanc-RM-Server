/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package md.ibanc.rm.util;

import java.util.UUID;

/**
 *
 * @author Zaițev.Victor
 */
public class GuidCode {

    public static String getGuid() {
        UUID guid = UUID.randomUUID();
        return String.valueOf(guid);
    }
}
