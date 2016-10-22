/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package md.ibanc.rm.spring.dao;

import java.util.List;
import md.ibanc.rm.entities.Languages;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

/**
 *
 * @author PC01017745
 */
@Repository
public class LanguagesDAOImpl extends AbstractSpringDao implements LanguagesDAO {

    @Override
    public void save(Languages languages) {
        super.saveOrUpdate(languages);
    }

    @Override
    public List findAll() {
        return super.findAll(Languages.class);
    }

    @Override
    public Languages findLanguagesByShortName(String shortName) {

        Languages languages = null;

        Session session = this.sessionFactory.getCurrentSession();

        Query query = session.createQuery(" SELECT languages FROM Languages languages "
                + " WHERE  languages.shortName=:Name "
        );

        query.setString("Name", shortName);

        List list = query.list();

        if (list != null && list.size() > 0) {
            languages = (Languages) list.get(0);
        }

        return languages;

    }

}
