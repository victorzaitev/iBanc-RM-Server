/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package md.ibanc.rm.spring.dao;

import java.util.List;
import md.ibanc.rm.entities.ExchangeRate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Zaițev.Victor
 */
@Repository
public class ExchangeRateDAOImpl extends AbstractSpringDao implements ExchangeRateDAO {

    @Override
    public void save(ExchangeRate exchangeRate) {
        super.saveOrUpdate(exchangeRate);
    }

    @Override
    public List findAll() {
        return super.findAll(ExchangeRate.class);
    }

}
