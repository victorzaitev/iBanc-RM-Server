/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package md.ibanc.rm.spring.dao;

import java.util.List;
import md.ibanc.rm.entities.NetworkOperator;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Zaițev.Victor
 */
@Repository
public class NetworkOperatorDAOImpl extends AbstractSpringDao implements NetworkOperatorDAO {

    @Override
    public void save(NetworkOperator networkOperator) {
        super.saveOrUpdate(networkOperator);
    }

    @Override
    public List findAll() {
        return super.findAll(NetworkOperator.class);
    }

    @Override
    public NetworkOperator findNetworkOperatorByName(String networkOperatorName) {

        NetworkOperator networkOperator = null;

        Session session = this.sessionFactory.getCurrentSession();

        Query query = session.createQuery(" "
                + " SELECT  networkOperator FROM NetworkOperator networkOperator "
                + "  WHERE  networkOperator.networkOperatorName=:Name "
        );

        query.setString("Name", networkOperatorName);

        List list = query.list();

        if (list != null && list.size() > 0) {
            networkOperator = (NetworkOperator) list.get(0);
        }

        return networkOperator;
    }

}
