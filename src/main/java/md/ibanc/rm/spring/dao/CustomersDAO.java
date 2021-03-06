/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package md.ibanc.rm.spring.dao;

import java.util.List;
import md.ibanc.rm.entities.Customers;

/**
 *
 * @author Zaițev.Victor
 */
public interface CustomersDAO {

    public void save(Customers customers);

    public List findAll();

    public Customers findCustomersByEmail(String email);

    public Customers findCustomersByUserName(String userName);

    public Customers findCustomersByPersonalId(String personalId);

    public Customers findCustomersBySession(String guid, String token);
}
