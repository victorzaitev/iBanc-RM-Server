/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package md.ibanc.rm.spring.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import md.ibanc.rm.entities.ExchangeRate;
import md.ibanc.rm.entities.utils.ExchangeRateList;
import md.ibanc.rm.spring.dao.ExchangeRateDAO;
import md.ibanc.rm.util.MyCalendar;
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

    @Override
    @Transactional
    public List<ExchangeRateList> findExchangeRateByDate(Date date) {
        List<ExchangeRateList> exchangeRateLists = new ArrayList<>();
        List<ExchangeRate> exchangeRates  = exchangeRateDAO.findExchangeRateByDate(date);
        
        
        for(ExchangeRate exchangeRate :exchangeRates){
            ExchangeRateList rateList = new ExchangeRateList();
            
            rateList.setBuyCurs(exchangeRate.getBuyCurs().doubleValue());
            rateList.setDateCurs(exchangeRate.getDataIns());
            rateList.setImagePath(exchangeRate.getArrowUp());
            rateList.setOfficialCurs(exchangeRate.getOfficialCurs().doubleValue());
            rateList.setSellCurs(exchangeRate.getSellCurs().doubleValue());
            rateList.setValutaShortName(exchangeRate.getValuta().getShortName());
            
            
            exchangeRateLists.add(rateList);
            
        }
        
         
        
        
        return exchangeRateLists;
    }

}
