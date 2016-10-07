/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package md.ibanc.rm.spring.dao;

import java.util.List;
import md.ibanc.rm.entities.Sessions;
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

}
