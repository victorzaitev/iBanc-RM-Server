/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package md.ibanc.rm.spring.dao;

import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Zaițev.Victor
 */
public abstract class AbstractSpringDao {

    protected SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    protected void saveOrUpdate(Object obj) {
        Session session = this.sessionFactory.getCurrentSession();
        session.saveOrUpdate(obj);
    }

    protected List findAll(Class clazz) {
        Session session = this.sessionFactory.getCurrentSession();
        List list = session.createQuery(" from " + clazz.getName()).list();
        return list;
    }

    protected Object findClassById(Class clazz, long id) {

        Object object = null;

        Session session = this.sessionFactory.getCurrentSession();

        object = session.get(clazz, id);

        Hibernate.initialize(object);

        return object;

    }

}
