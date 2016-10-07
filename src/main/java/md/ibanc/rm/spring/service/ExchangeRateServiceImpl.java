/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package md.ibanc.rm.spring.service;

import java.util.List;
import md.ibanc.rm.entities.ExchangeRate;
import md.ibanc.rm.spring.dao.ExchangeRateDAO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Zaițev.Victor
 */
@Service
public class ExchangeRateServiceImpl implements ExchangeRateService {

    private ExchangeRateDAO exchangeRateDAO;

    public void setExchangeRateDAO(ExchangeRateDAO exchangeRateDAO) {
        this.exchangeRateDAO = exchangeRateDAO;
    }

    @Override
    @Transactional
    public void save(ExchangeRate exchangeRate) {
        exchangeRateDAO.save(exchangeRate);
    }

    @Override
    @Transactional
    public List findAll() {
        return exchangeRateDAO.findAll();
    }

}
