/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package md.ibanc.rm.spring.service;

import java.util.List;
import md.ibanc.rm.entities.Users;
import md.ibanc.rm.spring.dao.UsersDAO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Zaițev.Victor
 */
@Service
public class UsersServiceImpl implements UsersService {

    UsersDAO usersServiceDAO;

    public void setUsersServiceDAO(UsersDAO usersServiceDAO) {
        this.usersServiceDAO = usersServiceDAO;
    }

    @Override
    @Transactional
    public void save(Users users) {
        usersServiceDAO.save(users);
    }

    @Override
    @Transactional
    public List findAll() {
        return usersServiceDAO.findAll();
    }

    @Override
    @Transactional
    public Users findUserByEmail(String email) {
        return usersServiceDAO.findUserByEmail(email);
    }

}
