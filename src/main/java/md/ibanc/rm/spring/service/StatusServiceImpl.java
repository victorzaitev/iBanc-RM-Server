/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package md.ibanc.rm.spring.service;

import java.util.List;
import md.ibanc.rm.entities.Status;
import md.ibanc.rm.spring.dao.StatusDAO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author PC01017745
 */
@Service
public class StatusServiceImpl implements StatusService {

    private StatusDAO statusDAO;

    public void setStatusDAO(StatusDAO statusDAO) {
        this.statusDAO = statusDAO;
    }

    @Override
    @Transactional
    public void save(Status status) {
        statusDAO.save(status);

    }

    @Override
    @Transactional
    public List findAll() {
        return statusDAO.findAll();
    }

    @Override
    @Transactional
    public Status findStatusByName(String name) {
        return statusDAO.findStatusByName(name);
    }

}
