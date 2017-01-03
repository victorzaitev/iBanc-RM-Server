/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package md.ibanc.rm.controllers.request;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import md.ibanc.rm.constant.RetCodeConst;
import md.ibanc.rm.constant.RetDescriptionConst;
import md.ibanc.rm.entities.form.ExchangeRateForm;
import md.ibanc.rm.entities.utils.ExchangeRateDetails;
import md.ibanc.rm.entities.utils.ExchangeRateList;
import md.ibanc.rm.spring.service.ExchangeRateService;
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
public class RequestExchangeRateController {

    @Autowired
    @Qualifier(value = "exchangeRateService")
    private ExchangeRateService exchangeRateService;

    @RequestMapping(value = "/find/exchangeRate/Date", method = RequestMethod.POST)
    public ResponseEntity<ExchangeRateDetails> findExchangeRateByDate(@Valid @RequestBody ExchangeRateForm exchangeRateForm, BindingResult bindingResult, HttpServletRequest request) {

        //@RequestMapping(value = "/find/exchangeRate/Date", method = RequestMethod.GET)
        //public ResponseEntity<ExchangeRateDetails> findExchangeRateByDate()  {
        // SimpleDateFormat formatater = new SimpleDateFormat("yyyy-MM-dd");
        // String dateString = "2016-1216";
       
        
        List<ExchangeRateList> rateLists;
        try {
            rateLists = exchangeRateService.findExchangeRateByDate(exchangeRateForm.getDateCurs());
        } catch (Exception ex) {
            ExchangeRateDetails exchangeRateDetails = new ExchangeRateDetails();
            exchangeRateDetails.setReturnCode(403);
            exchangeRateDetails.setReturnDescription(ex.getMessage());
            return new ResponseEntity<>(exchangeRateDetails, HttpStatus.BAD_REQUEST);
        }

        ExchangeRateDetails exchangeRateDetails = new ExchangeRateDetails();
        exchangeRateDetails.setExchangeRateList(rateLists);
        exchangeRateDetails.setReturnCode(RetCodeConst.RETCOD_OK);
        exchangeRateDetails.setReturnDescription(RetDescriptionConst.RETCOD_OK);

        return new ResponseEntity<>(exchangeRateDetails, HttpStatus.OK);
    }
}
