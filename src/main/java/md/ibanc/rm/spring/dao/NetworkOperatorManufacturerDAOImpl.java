/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package md.ibanc.rm.spring.dao;

import java.util.List;

import md.ibanc.rm.entities.NetworkOperatorManufacturer;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Zaițev.Victor
 */
@Repository
public class NetworkOperatorManufacturerDAOImpl extends AbstractSpringDao implements NetworkOperatorManufacturerDAO {

    @Override
    public void save(NetworkOperatorManufacturer networkOperatorManufacturer) {
        super.saveOrUpdate(networkOperatorManufacturer);
    }

    @Override
    public List findAll() {
        return super.findAll(NetworkOperatorManufacturer.class);

    }

    @Override
    public NetworkOperatorManufacturer findNetworkOperatorByOperatorAndManufacturer(int networkOperatorId, long manufacturerId) {

        NetworkOperatorManufacturer networkOperatorManufacturer = null;

        Session session = this.sessionFactory.getCurrentSession();

        Query query = session.createQuery(" "
                + " SELECT  networkOperatorManufacturer FROM NetworkOperatorManufacturer networkOperatorManufacturer "
                + "  WHERE  networkOperatorManufacturer.manufacturer.id=:ManufacturerId "
                + "   AND   networkOperatorManufacturer.networkOperator.id=:NetworkOperatorId "
        );

        query.setInteger("NetworkOperatorId", networkOperatorId);
        query.setLong("ManufacturerId", manufacturerId);

        List list = query.list();

        if (list != null && list.size() > 0) {
            networkOperatorManufacturer = (NetworkOperatorManufacturer) list.get(0);
        }

        return networkOperatorManufacturer;

    }

}
