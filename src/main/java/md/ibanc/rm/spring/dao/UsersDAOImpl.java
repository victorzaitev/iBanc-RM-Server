/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package md.ibanc.rm.spring.dao;

import java.util.List;
import md.ibanc.rm.entities.Users;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Zaițev.Victor
 */
@Repository
public class UsersDAOImpl extends AbstractSpringDao implements UsersDAO {

    @Override
    public void save(Users users) {
        super.saveOrUpdate(users);
    }

    @Override
    public List findAll() {
        return super.findAll(Users.class);
    }

    @Override
    public Users findUserByEmail(String email) {
        Users user = null;

        Session session = this.sessionFactory.getCurrentSession();

        Query query = session.createQuery(" FROM Users users "
                + " WHERE users.email=:UserEmail   ");

        query.setString("UserEmail", email);

        List list = query.list();

        if (list != null && list.size() > 0) {
            user = (Users) list.get(0);
        }
        return user;

    }

}
