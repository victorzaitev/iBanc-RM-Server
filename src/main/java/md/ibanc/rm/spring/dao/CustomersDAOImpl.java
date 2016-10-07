/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package md.ibanc.rm.spring.dao;

import java.util.List;
import md.ibanc.rm.entities.Customers;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Zaițev.Victor
 */
@Repository
public class CustomersDAOImpl extends AbstractSpringDao implements CustomersDAO {

    @Override
    public void save(Customers customers) {
        super.saveOrUpdate(customers);
    }

    @Override
    public List findAll() {
        return super.findAll(Customers.class);
    }

    @Override
    public Customers findCustomersByEmail(String email) {
        Customers customers = null;

        Session session = this.sessionFactory.getCurrentSession();

        Query query = session.createQuery(" SELECT customers FROM Customers customers "
                + " WHERE  customers.email=:Email "
        );

        query.setString("Email", email);

        List list = query.list();

        if (list != null && list.size() > 0) {
            customers = (Customers) list.get(0);
        }

        return customers;

    }

}
