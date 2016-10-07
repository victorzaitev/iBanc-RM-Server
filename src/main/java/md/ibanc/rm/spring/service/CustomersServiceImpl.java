/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package md.ibanc.rm.spring.service;

import java.util.List;
import md.ibanc.rm.entities.Customers;
import md.ibanc.rm.spring.dao.CustomersDAO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Zaițev.Victor
 */
@Service
public class CustomersServiceImpl implements CustomersService {

    private CustomersDAO customersDAO;

    public void setCustomersDAO(CustomersDAO customersDAO) {
        this.customersDAO = customersDAO;
    }

    @Override
    @Transactional
    public void save(Customers customers) {
        customersDAO.save(customers);
    }

    @Override
    @Transactional
    public List findAll() {
        return customersDAO.findAll();
    }

    @Override
    @Transactional
    public Customers findCustomersByEmail(String email) {
        return customersDAO.findCustomersByEmail(email);
    }

}
