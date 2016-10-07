/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package md.ibanc.rm.spring.dao;

import java.util.List;
import md.ibanc.rm.entities.Message;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

/**
 *
 * @author PC01017745
 */
@Repository
public class MessageDAOImpl extends AbstractSpringDao implements MessageDAO {

    @Override
    public void save(Message message) {
        super.saveOrUpdate(message);
    }

    @Override
    public List findAll() {
        return super.findAll(Message.class);
    }

    @Override
    public Message findMessageByTypeAndLang(String type, String lang) {
        Message message = null;

        Session session = this.sessionFactory.getCurrentSession();

        Query query = session.createQuery(" SELECT message FROM Message message "
                + " WHERE  message.typeMessage.name=:Type "
                + "   AND  message.languages.shortName=:shortName "
        );

        query.setString("Type", type);
        query.setString("shortName", lang);

        List list = query.list();

        if (list != null && list.size() > 0) {
            message = (Message) list.get(0);
        }

        return message;

    }

}
