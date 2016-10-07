/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package md.ibanc.rm.spring.service;

import java.util.List;
import md.ibanc.rm.entities.NetworkOperator;
import md.ibanc.rm.spring.dao.NetworkOperatorDAO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Zaițev.Victor
 */
@Service
public class NetworkOperatorServiceImpl implements NetworkOperatorService {

    private NetworkOperatorDAO networkOperatorDAO;

    public void setNetworkOperatorDAO(NetworkOperatorDAO networkOperatorDAO) {
        this.networkOperatorDAO = networkOperatorDAO;
    }

    @Override
    @Transactional
    public void save(NetworkOperator networkOperator) {
        networkOperatorDAO.save(networkOperator);
    }

    @Override
    @Transactional
    public List findAll() {
        return networkOperatorDAO.findAll();
    }

    @Override
    @Transactional
    public NetworkOperator findNetworkOperatorByName(String networkOperatorName) {
        return networkOperatorDAO.findNetworkOperatorByName(networkOperatorName);
    }

}
