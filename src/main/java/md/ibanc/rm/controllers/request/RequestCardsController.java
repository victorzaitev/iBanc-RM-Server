/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package md.ibanc.rm.controllers.request;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import md.ibanc.rm.constant.RetCodeConst;
import md.ibanc.rm.constant.RetDescriptionConst;
import md.ibanc.rm.entities.Cards;
import md.ibanc.rm.entities.Customers;
import md.ibanc.rm.entities.form.RegisterForm;
import md.ibanc.rm.entities.form.RequestForm;
import md.ibanc.rm.entities.utils.CardsDetails;
import md.ibanc.rm.entities.utils.CardsList;
import md.ibanc.rm.spring.service.CardsService;
import md.ibanc.rm.spring.service.CustomersService;
import md.ibanc.rm.util.GuidCode;
import md.ibanc.rm.util.MaskHelper;
import md.ibanc.rm.validators.CustomerRequestValidator;
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
public class RequestCardsController {

    @Autowired
    @Qualifier(value = "customersService")
    private CustomersService customersService;

    @Autowired
    @Qualifier(value = "cardsService")
    private CardsService cardsService;

    private String mask = "xxxxxxxxxxxx####";

    @RequestMapping(value = "/find/cards", method = RequestMethod.POST)
    public ResponseEntity<CardsDetails> getCardsByUser(@Valid @RequestBody RequestForm requestForm, BindingResult bindingResult, HttpServletRequest request) {

//        if (bindingResult.hasFieldErrors()) {
//            return showFieldErrors(bindingResult);
//        }
//
//       // Customers customers = customersService.findCustomersByPersonalId(requestForm.getPersonalId());
//
//        CustomerRequestValidator customersValidator = new CustomerRequestValidator(customers, requestForm.getGuid());
//        customersValidator.validate();
//
////        if (!customersValidator.isIsCustomersValid()) {
////            return customersValidator.getResponseEntity();
////        }
        Customers customers = customersService.findCustomersBySession(requestForm.getGuid(), null);

        if (customers == null) {
            CardsDetails cardsDetails = new CardsDetails();
            cardsDetails.setReturnCode(RetCodeConst.UNAUTHORIZED);
            cardsDetails.setReturnDescription(RetDescriptionConst.GUID_VALIDATION_ERROR);
            return new ResponseEntity<>(cardsDetails, HttpStatus.UNAUTHORIZED);
        }

        List<Cards> cardsList = cardsService.findCardsByCustomer(customers.getPersonalId());

        CardsDetails cardsDetails = new CardsDetails();

        cardsDetails.setReturnCode(RetCodeConst.RETCOD_OK);
        cardsDetails.setReturnDescription(RetDescriptionConst.RETCOD_OK);
        cardsDetails.setToken(GuidCode.getGuid());

        for (int i = 0; i < cardsList.size(); i++) {
            CardsList list = new CardsList();

            String description = cardsList.get(i).getDescription() + "(" + cardsList.get(i).getAccounts().getBalance().toString() + " " + cardsList.get(i).getAccounts().getValuta().getShortName() + ")";

            list.setStatus(cardsList.get(i).getStatus().getDescription());
            list.setTypes(cardsList.get(i).getTypes().getDescription());
            list.setDescription(description);
            list.setPan(cardsList.get(i).getPan());
            list.setMaskPan(MaskHelper.maskNumber(cardsList.get(i).getPan(), mask));

            cardsDetails.cardsList.add(list);

        }

        //  System.out.println("Json" + new ResponseEntity<>(cardsDetails.getCardsList(), HttpStatus.OK).toString());
        return new ResponseEntity<>(cardsDetails, HttpStatus.OK);

    }

    private ResponseEntity<CardsDetails> showFieldErrors(BindingResult bindingResult) {
        CardsDetails cardsDetails = new CardsDetails();

        switch (bindingResult.getFieldError().getField()) {
            case "userName": {
                cardsDetails.setReturnCode(RetCodeConst.FIELD_VALIDATION_ERROR);
                cardsDetails.setReturnDescription(RetDescriptionConst.USERNAME_VALIDATION_ERROR);
            }
            break;
            case "GUID": {
                cardsDetails.setReturnCode(RetCodeConst.FIELD_VALIDATION_ERROR);
                cardsDetails.setReturnDescription(RetDescriptionConst.GUID_VALIDATION_ERROR);
            }
            break;
            default: {
                cardsDetails.setReturnCode(RetCodeConst.UNKNOW_FIELD_ERROR);
                cardsDetails.setReturnDescription(RetDescriptionConst.UNKNOW_FIELD_VALIDATION_ERROR);
            }
        }
        return new ResponseEntity<>(cardsDetails, HttpStatus.BAD_REQUEST);
    }

}
