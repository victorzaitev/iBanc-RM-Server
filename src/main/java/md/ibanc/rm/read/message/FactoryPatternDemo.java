/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package md.ibanc.rm.read.message;

import java.util.Map;
import md.ibanc.rm.entities.SingInOutSessions;
import md.ibanc.rm.spring.service.MessageService;

/**
 *
 * @author PC01017745
 */
public class FactoryPatternDemo {

    private final MessageService messageService;

    public FactoryPatternDemo(MessageService messageService) {
        this.messageService = messageService;
    }

    public Map<String, String> getMessage(String typeMessage, SingInOutSessions singInOutSessions) {
        MessageFactory messageFactory = new MessageFactory(messageService);
        Message message = messageFactory.getMessage(typeMessage);
        return message.getMessageFromDatabse(singInOutSessions);
    }

}
