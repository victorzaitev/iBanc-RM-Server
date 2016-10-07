/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package md.ibanc.rm.read.message;

import md.ibanc.rm.spring.service.MessageService;

/**
 *
 * @author PC01017745
 */
public class MessageFactory {

    private MessageService messageService;

    public MessageFactory() {
    }

    public MessageFactory(MessageService messageService) {
        this.messageService = messageService;
    }

    public Message getMessage(String messageType) {

        if (messageType == null) {
            return null;
        }

        if (messageType.equalsIgnoreCase("NewDevices")) {
            return new MessageTypeNewDevices(messageService);

        } else if (messageType.equalsIgnoreCase("WrongPassword")) {
            return new MessageTypeWrongPassword(messageService);
            
        } else if (messageType.equalsIgnoreCase("BlockAccount")) {
            return new MessageTypeBlockAccount(messageService);
            
        }
        
        return null;
    }
}
