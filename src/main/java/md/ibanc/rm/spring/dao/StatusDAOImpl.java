/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package md.ibanc.rm.spring.dao;

import java.util.List;

import md.ibanc.rm.entities.Status;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

/**
 *
 * @author PC01017745
 */
@Repository
public class StatusDAOImpl extends AbstractSpringDao implements StatusDAO {

    @Override
    public void save(Status status) {
        super.saveOrUpdate(status);
    }

    @Override
    public List findAll() {
        return super.findAll(Status.class);
    }

    @Override
    public Status findStatusByName(String name) {
        Status status = null;

        Session session = this.sessionFactory.getCurrentSession();

        Query query = session.createQuery(" "
                + " SELECT  status FROM Status status "
                + "  WHERE  status.name=:Name "
        );

        query.setString("Name", name);

        List list = query.list();

        if (list != null && list.size() > 0) {
            status = (Status) list.get(0);
        }

        return status;
    }

}
