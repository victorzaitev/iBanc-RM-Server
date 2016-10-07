/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package md.ibanc.rm.spring.dao;

import md.ibanc.rm.entities.WrongPassword;
import org.springframework.stereotype.Repository;

/**
 *
 * @author PC01017745
 */
@Repository
public class WrongPasswordDAOImpl extends AbstractSpringDao implements WrongPasswordDAO {

    @Override
    public void save(WrongPassword wrongPassword) {
        super.saveOrUpdate(wrongPassword);
    }

}
