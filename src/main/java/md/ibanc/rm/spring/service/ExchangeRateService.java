/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package md.ibanc.rm.spring.service;

import java.util.List;
import md.ibanc.rm.entities.ExchangeRate;

/**
 *
 * @author Zaițev.Victor
 */
public interface ExchangeRateService {

    public void save(ExchangeRate exchangeRate);

    public List findAll();

}
