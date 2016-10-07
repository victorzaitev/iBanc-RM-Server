/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package md.ibanc.rm.spring.service;

import java.util.List;
import md.ibanc.rm.entities.NetworkOperatorManufacturer;

/**
 *
 * @author PC01017745
 */
public interface NetworkOperatorManufacturerService {

    public void save(NetworkOperatorManufacturer networkOperatorManufacturer);

    public List findAll();

    public NetworkOperatorManufacturer findNetworkOperatorByOperatorAndManufacturer(int networkOperatorId, long manufacturerId);
}
