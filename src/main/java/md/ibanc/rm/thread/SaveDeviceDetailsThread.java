/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package md.ibanc.rm.thread;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import md.ibanc.rm.entities.Customers;
import md.ibanc.rm.entities.Devices;
import md.ibanc.rm.entities.SingInOutSessions;
import md.ibanc.rm.read.message.FactoryPatternDemo;
import md.ibanc.rm.spring.service.DevicesService;
import md.ibanc.rm.spring.service.MessageService;
import md.ibanc.rm.spring.service.SingInOutSessionsService;
import md.ibanc.rm.util.SendMailNewDevices;

/**
 *
 * @author Zaițev.Victor
 */
public class SaveDeviceDetailsThread implements Runnable {

    private Thread thread;
    private final Customers customers;
    private final SingInOutSessions singInOutSessions;
    private final Map<String, String> devicesDetail;
    private SendMailNewDevices sendMailNewDevices;
    private String filePach;

    private DevicesService devicesService;
    private SingInOutSessionsService singInOutSessionsService;

    private MessageService messageService;

    private HttpServletRequest request;

    public SaveDeviceDetailsThread(Customers customers, SingInOutSessions singInOutSessions, Map<String, String> devicesDetail) {
        this.customers = customers;
        this.singInOutSessions = singInOutSessions;
        this.devicesDetail = devicesDetail;
    }

    public void setDevicesService(DevicesService devicesService) {
        this.devicesService = devicesService;
    }

    public void setSingInOutSessionsService(SingInOutSessionsService singInOutSessionsService) {
        this.singInOutSessionsService = singInOutSessionsService;
    }

    public void setRequest(HttpServletRequest request) {
        this.request = request;
        filePach = request.getRealPath("/");
    }

    public void setMessageService(MessageService messageService) {
        this.messageService = messageService;
    }

    @Override
    public void run() {

        Devices devices = devicesService.saveDevicesDetail(devicesDetail);
        boolean isExistDevices = singInOutSessionsService.findSingInOutSessionsByCustomersAndDevices(customers, devices);

        singInOutSessions.setDevices(devices);
        singInOutSessionsService.save(singInOutSessions);

        if (!isExistDevices) {
            FactoryPatternDemo factoryPatternDemo = new FactoryPatternDemo(messageService);
            Map<String, String> messageDetailsMap = factoryPatternDemo.getMessage("NewDevices", singInOutSessions);
            sendMailNewDevices.sendMail(messageDetailsMap.get("messageSubject"), messageDetailsMap.get("messageContent"));
        }

    }

    public void start() {
        sendMailNewDevices = new SendMailNewDevices(singInOutSessions.getCustomers().getEmail(), filePach);
        if (thread == null) {
            thread = new Thread(this);
            thread.start();
        }
    }
}
