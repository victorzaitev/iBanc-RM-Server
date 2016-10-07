/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package md.ibanc.rm.read.message;

import java.util.Map;
import md.ibanc.rm.entities.SingInOutSessions;

/**
 *
 * @author PC01017745
 */
public interface Message {

    Map<String, String> getMessageFromDatabse(SingInOutSessions singInOutSessions);
}
