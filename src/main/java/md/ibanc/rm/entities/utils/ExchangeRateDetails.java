/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package md.ibanc.rm.entities.utils;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PC01017745
 */
public class ExchangeRateDetails extends BaseEntity{
     public List<ExchangeRateList> exchangeRateList = new ArrayList<>();

    public List<ExchangeRateList> getExchangeRateList() {
        return exchangeRateList;
    }

    public void setExchangeRateList(List<ExchangeRateList> exchangeRateList) {
        this.exchangeRateList = exchangeRateList;
    }
     
}
