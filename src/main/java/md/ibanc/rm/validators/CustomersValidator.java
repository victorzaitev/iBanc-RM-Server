/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package md.ibanc.rm.validators;

import javax.servlet.http.HttpServletRequest;
import md.ibanc.rm.constant.RetCodeConst;
import md.ibanc.rm.constant.RetDescriptionConst;
import md.ibanc.rm.constant.StatusCodeConst;
import md.ibanc.rm.entities.Customers;
import md.ibanc.rm.entities.form.LoginForm;
import md.ibanc.rm.entities.utils.CustomersDetails;
import md.ibanc.rm.spring.service.CustomersService;
import md.ibanc.rm.spring.service.DevicesService;
import md.ibanc.rm.spring.service.MessageService;
import md.ibanc.rm.spring.service.StatusService;
import md.ibanc.rm.spring.service.WrongPasswordService;
import md.ibanc.rm.thread.WrongPasswordThread;
import md.ibanc.rm.util.FormatPassword;
import md.ibanc.rm.util.UtilHashMD5;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author Zaițev.Victor
 */
public class CustomersValidator {

    private final Customers customers;
    private boolean isCustomersValid;
    private ResponseEntity<CustomersDetails> responseEntity;
    private final LoginForm loginForm;
    private final HttpServletRequest request;

    private CustomersService customersService;
    private DevicesService devicesService;
    private MessageService messageService;
    private WrongPasswordService wrongPasswordService;
    private StatusService statusService;

    public CustomersValidator(Customers customers, LoginForm loginForm, HttpServletRequest request) {
        this.isCustomersValid = true;
        this.customers = customers;
        this.loginForm = loginForm;
        this.request = request;

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

    public boolean isIsCustomersValid() {
        return isCustomersValid;
    }

    public ResponseEntity<CustomersDetails> getResponseEntity() {
        return responseEntity;
    }

    public void validate() {
        if (customers == null) {
            CustomersDetails customersDetails = new CustomersDetails();
            customersDetails.setReturnCode(RetCodeConst.CUSTOMERS_NOT_FOUND);
            customersDetails.setReturnDescription(RetDescriptionConst.CUSTOMERS_NOT_FOUND);
            responseEntity = new ResponseEntity<>(customersDetails, HttpStatus.UNAUTHORIZED);
            isCustomersValid = false;
            return;
        }

        String hashPassword = UtilHashMD5.createMD5Hash(FormatPassword.CreatePassword((int) customers.getId(), loginForm.getmPassword()));

        if (!hashPassword.equals(customers.getPassword())) {
            CustomersDetails customersDetails = new CustomersDetails();
            customersDetails.setReturnCode(RetCodeConst.FAIL_PASSWORD);
            customersDetails.setReturnDescription(RetDescriptionConst.FAIL_PASSWORD);
            responseEntity = new ResponseEntity<>(customersDetails, HttpStatus.UNAUTHORIZED);
            isCustomersValid = false;

            WrongPasswordThread wrongPasswordThread = new WrongPasswordThread(customers, loginForm, request);

            wrongPasswordThread.setCustomersService(customersService);
            wrongPasswordThread.setDevicesService(devicesService);
            wrongPasswordThread.setMessageService(messageService);
            wrongPasswordThread.setWrongPasswordService(wrongPasswordService);
            wrongPasswordThread.setStatusService(statusService);

            wrongPasswordThread.start();

            return;
        }

        switch (customers.getStatus().getName()) {
            case StatusCodeConst.PASSWORD_EXPIRE: {
                CustomersDetails customersDetails = new CustomersDetails();
                customersDetails.setReturnCode(RetCodeConst.PASSWORD_EXPIRE);
                customersDetails.setReturnDescription(RetDescriptionConst.PASSWORD_EXPIRE);
                responseEntity = new ResponseEntity<>(customersDetails, HttpStatus.UNAUTHORIZED);
                isCustomersValid = false;
                return;
            }

            case StatusCodeConst.BLOCK_ACCOUNT: {
                CustomersDetails customersDetails = new CustomersDetails();
                customersDetails.setReturnCode(RetCodeConst.BLOCK_ACCOUNT);
                customersDetails.setReturnDescription(RetDescriptionConst.BLOCK_ACCOUNT);
                responseEntity = new ResponseEntity<>(customersDetails, HttpStatus.UNAUTHORIZED);
                isCustomersValid = false;
                return;
            }

        }

        if (!customers.getStatus().getName().equals(StatusCodeConst.ACTIVE)) {
            CustomersDetails customersDetails = new CustomersDetails();
            customersDetails.setReturnCode(RetCodeConst.UNAUTHORIZED);
            customersDetails.setReturnDescription(RetDescriptionConst.UNAUTHORIZED);
            responseEntity = new ResponseEntity<>(customersDetails, HttpStatus.UNAUTHORIZED);
            isCustomersValid = false;
        } else {
            CustomersDetails customersDetails = new CustomersDetails();
            customersDetails.setReturnCode(RetCodeConst.RETCOD_OK);
            customersDetails.setReturnDescription(RetDescriptionConst.RETCOD_OK);
            responseEntity = new ResponseEntity<>(customersDetails, HttpStatus.OK);
            isCustomersValid = true;
            customers.setUnSuccessfulAtempst(0);
            customersService.save(customers);

        }
    }

}
