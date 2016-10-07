/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package md.ibanc.rm.controllers.request;

import javax.servlet.http.HttpServletRequest;
import md.ibanc.rm.entities.form.LoginForm;
import javax.validation.Valid;
import md.ibanc.rm.constant.RetCodeConst;
import md.ibanc.rm.constant.RetDescriptionConst;
import md.ibanc.rm.entities.Customers;
import md.ibanc.rm.entities.SingInOutSessions;
import md.ibanc.rm.entities.utils.CustomersDetails;
import md.ibanc.rm.spring.service.CustomersService;
import md.ibanc.rm.spring.service.DevicesService;
import md.ibanc.rm.spring.service.MessageService;
import md.ibanc.rm.spring.service.SingInOutSessionsService;
import md.ibanc.rm.spring.service.StatusService;
import md.ibanc.rm.spring.service.WrongPasswordService;
import md.ibanc.rm.thread.SaveDeviceDetailsThread;
import md.ibanc.rm.util.GuidCode;
import md.ibanc.rm.validators.CustomersValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Zaițev.Victor
 */
@RestController
public class RequestCustomersController {

    @Autowired
    @Qualifier(value = "customersService")
    private CustomersService customersService;

    @Autowired
    @Qualifier(value = "singInOutSessionsService")
    private SingInOutSessionsService singInOutSessionsService;

    @Autowired
    @Qualifier(value = "devicesService")
    private DevicesService devicesService;

    @Autowired
    @Qualifier(value = "messageService")
    private MessageService messageService;

    @Autowired
    @Qualifier(value = "wrongPasswordService")
    private WrongPasswordService wrongPasswordService;

    @Autowired
    @Qualifier(value = "statusService")
    private StatusService statusService;

    //--------------- login customers ----------------------------------------------------
    @RequestMapping(value = "/login/customers", method = RequestMethod.POST)
    public ResponseEntity<CustomersDetails> loginCustomers(@Valid @RequestBody LoginForm loginForm, BindingResult bindingResult, HttpServletRequest request) {

        if (bindingResult.hasFieldErrors()) {
            return showFieldErrors(bindingResult);
        }

        Customers customers = customersService.findCustomersByEmail(loginForm.getmEmail());

        CustomersValidator customersValidator = new CustomersValidator(customers, loginForm, request);

        customersValidator.setCustomersService(customersService);
        customersValidator.setDevicesService(devicesService);
        customersValidator.setMessageService(messageService);
        customersValidator.setWrongPasswordService(wrongPasswordService);
        customersValidator.setStatusService(statusService);

        customersValidator.validate();

        if (!customersValidator.isIsCustomersValid()) {
            return customersValidator.getResponseEntity();
        }

        String guidId = GuidCode.getGuid();

        CustomersDetails customersDetails = getCustomersDetails(customers, guidId);

        SingInOutSessions singInOutSessions = singInOutSessionsService.save(guidId, customers, request);

        SaveDeviceDetailsThread saveDeviceDetailsThread = new SaveDeviceDetailsThread(customers, singInOutSessions, loginForm.getDevicesDetail());

        saveDeviceDetailsThread.setDevicesService(devicesService);
        saveDeviceDetailsThread.setSingInOutSessionsService(singInOutSessionsService);
        saveDeviceDetailsThread.setRequest(request);
        saveDeviceDetailsThread.setMessageService(messageService);

        saveDeviceDetailsThread.start();

        return new ResponseEntity<>(customersDetails, HttpStatus.OK);
    }

    private CustomersDetails getCustomersDetails(Customers customers, String guidId) {
        CustomersDetails customersDetails = new CustomersDetails();

        customersDetails.setReturnCode(RetCodeConst.RETCOD_OK);
        customersDetails.setReturnDescription(RetDescriptionConst.RETCOD_OK);

        customersDetails.setFirstName(customers.getFirstName());
        customersDetails.setLastName(customers.getLastName());
        customersDetails.setPersonalId(customers.getPersonalId());
        customersDetails.setEmail(customers.getEmail());
        customersDetails.setLasstAcces(customers.getLasstAcces());
        customersDetails.setAdress(customers.getAdress());
        customersDetails.setPhone(customers.getPhone());
        customersDetails.setRegisteDate(customers.getRegisteDate());
        customersDetails.setGuid(guidId);
        customersDetails.setToken(GuidCode.getGuid());

        return customersDetails;
    }

    private ResponseEntity<CustomersDetails> showFieldErrors(BindingResult bindingResult) {
        CustomersDetails customersDetails = new CustomersDetails();

        switch (bindingResult.getFieldError().getField()) {
            case "mEmail": {
                customersDetails.setReturnCode(RetCodeConst.FIELD_VALIDATION_ERROR);
                customersDetails.setReturnDescription(RetDescriptionConst.EMAIL_VALIDATION_ERROR);
            }
            break;
            case "mPassword": {
                customersDetails.setReturnCode(RetCodeConst.FIELD_VALIDATION_ERROR);
                customersDetails.setReturnDescription(RetDescriptionConst.PASSWORD_VALIDATION_ERROR);
            }
            break;
            default: {
                customersDetails.setReturnCode(RetCodeConst.UNKNOW_FIELD_ERROR);
                customersDetails.setReturnDescription(RetDescriptionConst.UNKNOW_FIELD_VALIDATION_ERROR);
            }
        }
        return new ResponseEntity<>(customersDetails, HttpStatus.BAD_REQUEST);
    }

}
