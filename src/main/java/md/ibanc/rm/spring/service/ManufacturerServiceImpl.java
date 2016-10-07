/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package md.ibanc.rm.spring.service;

import java.util.List;
import md.ibanc.rm.entities.Manufacturer;
import md.ibanc.rm.spring.dao.ManufacturerDAO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Zaițev.Victor
 */
@Service
public class ManufacturerServiceImpl implements ManufacturerService {

    private ManufacturerDAO manufacturerDAO;

    public void setManufacturerDAO(ManufacturerDAO manufacturerDAO) {
        this.manufacturerDAO = manufacturerDAO;
    }

    @Override
    @Transactional
    public void save(Manufacturer manufacturer) {
        manufacturerDAO.save(manufacturer);
    }

    @Override
    @Transactional
    public List findAll() {
        return manufacturerDAO.findAll();
    }

    @Override
    @Transactional
    public Manufacturer findManufacturerByBrandAndProductAndModel(String brand, String product, String model) {

        System.out.println(" Zaitev Manufacturer Service " + brand + " " + product + " " + model);

        return manufacturerDAO.findManufacturerByBrandAndProductAndModel(brand, product, model);
    }

}
