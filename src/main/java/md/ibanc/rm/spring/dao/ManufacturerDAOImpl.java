/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package md.ibanc.rm.spring.dao;

import java.util.List;
import md.ibanc.rm.entities.Manufacturer;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Zaițev.Victor
 */
@Repository
public class ManufacturerDAOImpl extends AbstractSpringDao implements ManufacturerDAO {

    @Override
    public void save(Manufacturer manufacturer) {
        super.saveOrUpdate(manufacturer);
    }

    @Override
    public List findAll() {
        return super.findAll(Manufacturer.class);
    }

    @Override
    public Manufacturer findManufacturerByBrandAndProductAndModel(String brand, String product, String model) {

        System.out.println(" Zaitev Manufacturer DAO " + brand + " " + product + " " + model);

        Manufacturer manufacturer = null;

        Session session = this.sessionFactory.getCurrentSession();

        Query query = session.createQuery(" "
                + " SELECT  manufacturer FROM Manufacturer manufacturer "
                + "  WHERE  manufacturer.brand=:Brand "
                + "    AND  manufacturer.product=:Product "
                + "    AND  manufacturer.model=:Model "
        );

        query.setString("Brand", brand);
        query.setString("Product", product);
        query.setString("Model", model);

        List list = query.list();

        if (list != null && list.size() > 0) {
            manufacturer = (Manufacturer) list.get(0);
        }

        return manufacturer;

    }

}
