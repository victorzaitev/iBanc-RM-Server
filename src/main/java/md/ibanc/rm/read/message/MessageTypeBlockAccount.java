/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package md.ibanc.rm.read.message;

import java.util.HashMap;
import java.util.Map;
import md.ibanc.rm.entities.SingInOutSessions;
import md.ibanc.rm.spring.service.MessageService;

/**
 *
 * @author PC01017745
 */
public class MessageTypeBlockAccount implements Message {

    private final MessageService messageService;

    public MessageTypeBlockAccount(MessageService messageService) {
        this.messageService = messageService;
    }

    @Override
    public Map<String, String> getMessageFromDatabse(SingInOutSessions singInOutSessions) {
        md.ibanc.rm.entities.Message message = messageService.findMessageByTypeAndLang("BlockAccount", singInOutSessions.getCustomers().getLanguages().getShortName());
        String messageContent = message.getContent();

        messageContent = messageContent.replaceAll("\\$\\{Last_Name\\}", singInOutSessions.getCustomers().getLastName());
        messageContent = messageContent.replaceAll("\\$\\{First_Name\\}", singInOutSessions.getCustomers().getFirstName());
        messageContent = messageContent.replaceAll("\\$\\{Location\\}", singInOutSessions.getIp());
        messageContent = messageContent.replaceAll("\\$\\{Device_Brand\\}", singInOutSessions.getDevices().getNetworkOperatorManufacturer().getManufacturer().getBrand());
        messageContent = messageContent.replaceAll("\\$\\{Device_Product\\}", singInOutSessions.getDevices().getNetworkOperatorManufacturer().getManufacturer().getProduct());
        messageContent = messageContent.replaceAll("\\$\\{Device_Model\\}", singInOutSessions.getDevices().getNetworkOperatorManufacturer().getManufacturer().getModel());

        messageContent = messageContent.replaceAll("\\$\\{Device_Network_Operator\\}", singInOutSessions.getDevices().getNetworkOperatorManufacturer().getNetworkOperator().getNetworkOperatorName());
        messageContent = messageContent.replaceAll(" +", " ").trim();

        String messageSubject = message.getSubject();
        messageSubject = messageSubject.replaceAll(" +", " ").trim();

        Map<String, String> mesaagesDetailsMap = new HashMap<>();
        mesaagesDetailsMap.put("messageSubject", messageSubject);
        mesaagesDetailsMap.put("messageContent", messageContent);

        return mesaagesDetailsMap;
    }

}
