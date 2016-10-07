/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package md.ibanc.rm.spring.service;

import md.ibanc.rm.entities.WrongPassword;
import md.ibanc.rm.spring.dao.WrongPasswordDAO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author PC01017745
 */
@Service
public class WrongPasswordServiceImpl implements WrongPasswordService {

    private WrongPasswordDAO wrongPasswordDAO;

    public void setWrongPasswordDAO(WrongPasswordDAO wrongPasswordDAO) {
        this.wrongPasswordDAO = wrongPasswordDAO;
    }

    @Override
    @Transactional
    public void save(WrongPassword wrongPassword) {
        wrongPasswordDAO.save(wrongPassword);
    }

}
