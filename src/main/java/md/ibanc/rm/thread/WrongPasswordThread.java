/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package md.ibanc.rm.thread;

import java.util.Date;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import md.ibanc.rm.constant.StatusCodeConst;
import md.ibanc.rm.entities.Customers;
import md.ibanc.rm.entities.Devices;
import md.ibanc.rm.entities.SingInOutSessions;
import md.ibanc.rm.entities.Status;
import md.ibanc.rm.entities.WrongPassword;
import md.ibanc.rm.entities.form.LoginForm;
import md.ibanc.rm.read.message.FactoryPatternDemo;
import md.ibanc.rm.spring.service.CustomersService;
import md.ibanc.rm.spring.service.DevicesService;
import md.ibanc.rm.spring.service.MessageService;
import md.ibanc.rm.spring.service.WrongPasswordService;
import md.ibanc.rm.spring.service.StatusService;
import md.ibanc.rm.util.SendMailNewDevices;

/**
 *
 * @author Zaițev.Victor
 */
public class WrongPasswordThread implements Runnable {

    private final Customers customers;
    private final LoginForm loginForm;
    private final HttpServletRequest request;
    private Thread t;

    private String filePach = "";
    private String ip = "";
    private String location = "";
    private SendMailNewDevices sendMailNewDevices;

    private CustomersService customersService;
    private DevicesService devicesService;
    private MessageService messageService;
    private WrongPasswordService wrongPasswordService;
    private StatusService statusService;
    private Status statusActive;
    private Status statusBlockAccount;

    public WrongPasswordThread(Customers customers, LoginForm loginForm, HttpServletRequest request) {
        this.customers = customers;
        this.loginForm = loginForm;
        this.request = request;
        filePach = request.getRealPath("/");
        ip = request.getRemoteAddr();
        location = request.getRemoteUser();

    }

    public void setCustomersService(CustomersService customersService) {
        this.customersService = customersService;
    }

    public void setDevicesService(DevicesService devicesService) {
        this.devicesService = devicesService;
    }

    public void setMessageService(MessageService messageService) {
        this.messageService = messageService;
    }

    public void setWrongPasswordService(WrongPasswordService wrongPasswordService) {
        this.wrongPasswordService = wrongPasswordService;
    }

    public void setStatusService(StatusService statusService) {
        this.statusService = statusService;
    }

    @Override
    public void run() {

        Devices devices = saveWrongPassword();

        if (devices == null) {
            return;
        }

        int unSuccessfulAtempst = customers.getUnSuccessfulAtempst() + 1;

        if (unSuccessfulAtempst >= 3) {

            customers.setStatus(statusBlockAccount);
            customers.setUnSuccessfulAtempst(unSuccessfulAtempst);
            customersService.save(customers);
            sendMail(devices, "BlockAccount");
        } else {

            customers.setStatus(statusActive);
            customers.setUnSuccessfulAtempst(unSuccessfulAtempst);
            customersService.save(customers);
            sendMail(devices, "WrongPassword");
        }

    }

    public void start() {
        sendMailNewDevices = new SendMailNewDevices(customers.getEmail(), filePach);
        statusBlockAccount = statusService.findStatusByName(StatusCodeConst.BLOCK_ACCOUNT);
        statusActive = statusService.findStatusByName(StatusCodeConst.ACTIVE);
        if (t == null) {
            t = new Thread(this);
            System.out.println("Starting WrongPasswordThreat" + t.getName());
            t.start();
        }
    }

    private Devices saveWrongPassword() {
        Devices devices = devicesService.saveDevicesDetail(loginForm.getDevicesDetail());
        WrongPassword wrongPassword = new WrongPassword();
        wrongPassword.setCustomers(customers);
        wrongPassword.setDevices(devices);
        wrongPassword.setLocation(location);
        wrongPassword.setIp(ip);
        wrongPassword.setAccesDate(new Date());
        wrongPasswordService.save(wrongPassword);
        return devices;
    }

    private void sendMail(Devices devices, String typeMessage) {
        SingInOutSessions singInOutSessions = new SingInOutSessions();
        singInOutSessions.setCustomers(customers);
        singInOutSessions.setDevices(devices);
        singInOutSessions.setIp(ip);

        FactoryPatternDemo factoryPatternDemo = new FactoryPatternDemo(messageService);
        Map<String, String> messageDetailsMap = factoryPatternDemo.getMessage(typeMessage, singInOutSessions);
        sendMailNewDevices.sendMail(messageDetailsMap.get("messageSubject"), messageDetailsMap.get("messageContent"));

    }
}
