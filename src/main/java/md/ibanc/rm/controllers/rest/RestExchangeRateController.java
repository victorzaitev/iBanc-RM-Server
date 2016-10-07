/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package md.ibanc.rm.controllers.rest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import md.ibanc.rm.entities.ExchangeRate;
import md.ibanc.rm.spring.service.ExchangeRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Zaițev.Victor
 */
@RestController
public class RestExchangeRateController {

    //ExchangeRate Service which will do all data retrieval/manipulation work
    @Autowired
    @Qualifier(value = "exchangeRateService")
    private ExchangeRateService exchangeRateService;

    //---------------------- Retrieve All Value of ExchangeRate --------------------------------------------------
    @RequestMapping(value = "/rest/valueExchangeRate", method = RequestMethod.GET)
    public ResponseEntity<List<ExchangeRate>> getAllExchangeRate() {

        ExchangeRate exchangeRate = new ExchangeRate();
        exchangeRate.setBuyCurs(BigDecimal.ONE);
        exchangeRate.setDataIns(new Date());
        exchangeRate.setOfficialCurs(BigDecimal.TEN);
        exchangeRate.setSellCurs(BigDecimal.TEN);
        exchangeRateService.save(exchangeRate);

        List<ExchangeRate> ExchangeRateRestList = (ArrayList<ExchangeRate>) exchangeRateService.findAll();

        return new ResponseEntity<>(ExchangeRateRestList, HttpStatus.OK);
    }

}
