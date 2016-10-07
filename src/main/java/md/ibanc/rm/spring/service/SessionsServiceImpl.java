/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package md.ibanc.rm.spring.service;

import java.util.List;
import md.ibanc.rm.entities.Sessions;
import md.ibanc.rm.spring.dao.SessionsDAO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Zaițev.Victor
 */
@Service
public class SessionsServiceImpl implements SessionsService {

    SessionsDAO sessionsDAO;

    public void setSessionsDAO(SessionsDAO sessionsDAO) {
        this.sessionsDAO = sessionsDAO;
    }

    @Override
    @Transactional
    public void save(Sessions sessions) {
        sessionsDAO.save(sessions);
    }

    @Override
    @Transactional
    public List findAll() {
        return sessionsDAO.findAll();
    }

}
