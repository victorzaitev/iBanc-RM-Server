/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package md.ibanc.rm.spring.dao;

import java.util.List;
import md.ibanc.rm.entities.Devices;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Zaițev.Victor
 */
@Repository
public class DevicesDAOImpl extends AbstractSpringDao implements DevicesDAO {

    @Override
    public void save(Devices devices) {
        super.saveOrUpdate(devices);
    }

    @Override
    public List findAll() {
        return super.findAll(Devices.class);
    }

    @Override
    public Devices findDevicesByIMIE(String imie) {
        Devices devices = null;

        Session session = this.sessionFactory.getCurrentSession();

        Query query = session.createQuery(" SELECT devices FROM Devices devices "
                + " WHERE  devices.imie=:IMIE "
        );

        query.setString("IMIE", imie);

        List list = query.list();

        if (list != null && list.size() > 0) {
            devices = (Devices) list.get(0);
        }

        return devices;
    }

    @Override
    public Devices findDevicesByImieAndOperatorName(String imie, String name) {

        Devices devices = null;

        Session session = this.sessionFactory.getCurrentSession();

        Query query = session.createQuery(" SELECT devices FROM Devices devices "
                + " WHERE  devices.imie=:IMIE "
                + "   AND  devices.networkOperatorManufacturer.networkOperator.networkOperatorName=:Name "
        );

        query.setString("IMIE", imie);
        query.setString("Name", name);

        List list = query.list();

        if (list != null && list.size() > 0) {
            devices = (Devices) list.get(0);
        }

        return devices;

    }

}
