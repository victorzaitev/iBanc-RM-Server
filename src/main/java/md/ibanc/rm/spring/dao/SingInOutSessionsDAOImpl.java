/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package md.ibanc.rm.spring.dao;

import java.util.List;
import md.ibanc.rm.entities.Customers;
import md.ibanc.rm.entities.Devices;
import md.ibanc.rm.entities.NetworkOperatorManufacturer;
import md.ibanc.rm.entities.SingInOutSessions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Zaițev.Victor
 */
@Repository
public class SingInOutSessionsDAOImpl extends AbstractSpringDao implements SingInOutSessionsDAO {

    @Override
    public void save(SingInOutSessions singInOutSessions) {
        super.saveOrUpdate(singInOutSessions);
    }

    @Override
    public List findAll() {
        return super.findAll(SingInOutSessions.class);
    }

    @Override
    public boolean findSingInOutSessionsByCustomersAndDevices(Customers customers, Devices devices) {

        Session session = this.sessionFactory.getCurrentSession();
        Query query = session.createQuery(" "
                + " SELECT  singInOutSessions FROM SingInOutSessions singInOutSessions "
                + "  WHERE  singInOutSessions.customers.id=:CustomersId "
                + "   AND   singInOutSessions.devices.id=:DevicesId "
        );

        query.setLong("CustomersId", customers.getId());
        query.setLong("DevicesId", devices.getId());

        List list = query.list();

        return list != null && list.size() > 0;

    }

    @Override
    public SingInOutSessions findById(long id) {

        SingInOutSessions singInOutSessions = null;

        Session session = this.sessionFactory.getCurrentSession();

        Query query = session.createQuery(" "
                + " SELECT  singInOutSessions FROM SingInOutSessions singInOutSessions "
                + "  WHERE  singInOutSessions.id=:Id "
        );

        query.setLong("Id", id);

        List list = query.list();

        if (list != null && list.size() > 0) {
            singInOutSessions = (SingInOutSessions) list.get(0);
        }

        return singInOutSessions;

    }

}
