/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package md.ibanc.rm.spring.dao;

import java.util.List;
import md.ibanc.rm.entities.Sessions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Zaițev.Victor
 */
@Repository
public class SessionsDAOImpl extends AbstractSpringDao implements SessionsDAO {

    @Override
    public void save(Sessions sessions) {
        super.saveOrUpdate(sessions);

    }

    @Override
    public List findAll() {
        return super.findAll(Sessions.class);
    }

    @Override
    public Sessions findSessionsByGuid(String guid) {
          Sessions sessions = null;

        Session session = this.sessionFactory.getCurrentSession();

        Query query = session.createQuery(" "
                + " SELECT  sessions FROM Sessions sessions "
                + "  WHERE  sessions.sessionUid=:Guid "
        );

        query.setString("Guid", guid);

        List list = query.list();

        if (list != null && list.size() > 0) {
            sessions = (Sessions) list.get(0);
        }

        return sessions;
        



    }

}
