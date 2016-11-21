/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package md.ibanc.rm.spring.service;

import java.util.Date;
import java.util.List;
import md.ibanc.rm.entities.Customers;
import md.ibanc.rm.entities.Sessions;
import md.ibanc.rm.entities.SingInOutSessions;
import md.ibanc.rm.spring.dao.CustomersDAO;
import md.ibanc.rm.spring.dao.SessionsDAO;
import md.ibanc.rm.spring.dao.SingInOutSessionsDAO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Zaițev.Victor
 */
@Service
public class CustomersServiceImpl implements CustomersService {

    private CustomersDAO customersDAO;
    private SessionsDAO sessionsDAO;
    private SingInOutSessionsDAO singInOutSessionsDAO;

    public void setCustomersDAO(CustomersDAO customersDAO) {
        this.customersDAO = customersDAO;
    }

    public void setSessionsDAO(SessionsDAO sessionsDAO) {
        this.sessionsDAO = sessionsDAO;
    }

    public void setSingInOutSessionsDAO(SingInOutSessionsDAO singInOutSessionsDAO) {
        this.singInOutSessionsDAO = singInOutSessionsDAO;
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

    @Override
    @Transactional
    public boolean logout(String guid, String token) {
        Sessions sessions = sessionsDAO.findSessionsByGuid(guid);

        SingInOutSessions singInOutSessions = singInOutSessionsDAO.findSingInOutSessionsBySessionsGuid(guid);
        singInOutSessions.setSingOutDate(new Date());
        singInOutSessionsDAO.save(singInOutSessions);

        return true;

    }

    @Override
    @Transactional
    public Customers findCustomersByUserName(String userName) {
        return customersDAO.findCustomersByUserName(userName);
    }

    @Override
    @Transactional
    public Customers findCustomersByPersonalId(String personalId) {
        return customersDAO.findCustomersByPersonalId(personalId);

    }

    @Override
    @Transactional
    public Customers findCustomersBySession(String guid, String token) {
        return customersDAO.findCustomersBySession(guid, token);
    }

}
