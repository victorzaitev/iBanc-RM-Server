/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package md.ibanc.rm.spring.service;

import java.util.List;
import md.ibanc.rm.entities.NetworkOperatorManufacturer;
import md.ibanc.rm.spring.dao.NetworkOperatorManufacturerDAO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author PC01017745
 */
@Service
public class NetworkOperatorManufacturerServiceImpl implements NetworkOperatorManufacturerService {

    private NetworkOperatorManufacturerDAO networkOperatorManufacturerDAO;

    public void setNetworkOperatorManufacturerDAO(NetworkOperatorManufacturerDAO networkOperatorManufacturerDAO) {
        this.networkOperatorManufacturerDAO = networkOperatorManufacturerDAO;
    }

    @Override
    @Transactional
    public void save(NetworkOperatorManufacturer networkOperatorManufacturer) {
        networkOperatorManufacturerDAO.save(networkOperatorManufacturer);
    }

    @Override
    @Transactional
    public List findAll() {
        return networkOperatorManufacturerDAO.findAll();
    }

    @Override
    @Transactional
    public NetworkOperatorManufacturer findNetworkOperatorByOperatorAndManufacturer(int networkOperatorId, long manufacturerId) {
        return networkOperatorManufacturerDAO.findNetworkOperatorByOperatorAndManufacturer(networkOperatorId, manufacturerId);
    }

}
