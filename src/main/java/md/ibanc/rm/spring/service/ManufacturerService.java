/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package md.ibanc.rm.spring.service;

import java.util.List;
import md.ibanc.rm.entities.Manufacturer;

/**
 *
 * @author Zaițev.Victor
 */
public interface ManufacturerService {

    public void save(Manufacturer manufacturer);

    public List findAll();

    public Manufacturer findManufacturerByBrandAndProductAndModel(String brand, String product, String model);
}
