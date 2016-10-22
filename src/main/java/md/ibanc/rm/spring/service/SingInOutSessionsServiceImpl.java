/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package md.ibanc.rm.spring.service;

import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import md.ibanc.rm.entities.Customers;
import md.ibanc.rm.entities.Devices;
import md.ibanc.rm.entities.Sessions;
import md.ibanc.rm.entities.SingInOutSessions;
import md.ibanc.rm.spring.dao.SessionsDAO;
import md.ibanc.rm.spring.dao.SingInOutSessionsDAO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Zaițev.Victor
 */
@Service
public class SingInOutSessionsServiceImpl implements SingInOutSessionsService {

    private SingInOutSessionsDAO singInOutSessionsDAO;
    private SessionsDAO sessionsDAO;

    public void setSingInOutSessionsDAO(SingInOutSessionsDAO singInOutSessionsDAO) {
        this.singInOutSessionsDAO = singInOutSessionsDAO;
    }

    public void setSessionsDAO(SessionsDAO sessionsDAO) {
        this.sessionsDAO = sessionsDAO;
    }

    @Override
    @Transactional
    public void save(SingInOutSessions singInOutSessions) {
        singInOutSessionsDAO.save(singInOutSessions);
    }

    @Override
    @Transactional
    public List findAll() {
        return singInOutSessionsDAO.findAll();
    }

    @Override
    @Transactional
    public SingInOutSessions save(String guidId, Customers customers, HttpServletRequest request) {
        Sessions sessions = new Sessions();
        sessions.setCreatedAt(new Date());
        sessions.setSessionUid(guidId);

        sessionsDAO.save(sessions);

        SingInOutSessions singInOutSessions = new SingInOutSessions();
        singInOutSessions.setCustomers(customers);
        singInOutSessions.setSessions(sessions);
        singInOutSessions.setSingInDate(new Date());
        singInOutSessions.setIp(request.getRemoteAddr());
        singInOutSessions.setLocation(request.getRemoteUser());

        singInOutSessionsDAO.save(singInOutSessions);
        return singInOutSessions;

    }

    @Override
    @Transactional
    public boolean findSingInOutSessionsByCustomersAndDevices(Customers customers, Devices devices) {
        return singInOutSessionsDAO.findSingInOutSessionsByCustomersAndDevices(customers, devices);
    }

    @Override
    @Transactional
    public SingInOutSessions findById(long id) {
        return singInOutSessionsDAO.findById(id);
    }

    @Override
    @Transactional
    public SingInOutSessions findSingInOutSessionsBySessionsGuid(String guid) {
        return singInOutSessionsDAO.findSingInOutSessionsBySessionsGuid(guid);
    }

}
