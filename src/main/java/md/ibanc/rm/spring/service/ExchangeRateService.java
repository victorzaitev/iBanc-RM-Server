/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package md.ibanc.rm.spring.service;

import java.util.Date;
import java.util.List;
import md.ibanc.rm.entities.ExchangeRate;
import md.ibanc.rm.entities.utils.ExchangeRateList;

/**
 *
 * @author Zaițev.Victor
 */
public interface ExchangeRateService {

    public void save(ExchangeRate exchangeRate);

    public List findAll();

    public List<ExchangeRateList> findExchangeRateByDate(Date date);
}
