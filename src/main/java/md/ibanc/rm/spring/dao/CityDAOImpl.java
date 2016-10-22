/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package md.ibanc.rm.spring.dao;

import java.util.List;
import md.ibanc.rm.entities.City;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

/**
 *
 * @author PC01017745
 */
@Repository
public class CityDAOImpl extends AbstractSpringDao implements CityDAO {

    @Override
    public void save(City city) {
        super.saveOrUpdate(city);
    }

    @Override
    public List findAll() {
        return super.findAll(City.class);
    }

    @Override
    public City findCityByName(String nameCity) {

        City city = null;

        Session session = this.sessionFactory.getCurrentSession();

        Query query = session.createQuery(" SELECT city FROM City city "
                + " WHERE  city.name=:Name "
        );

        query.setString("Name", nameCity);

        List list = query.list();

        if (list != null && list.size() > 0) {
            city = (City) list.get(0);
        }

        return city;

    }

}
