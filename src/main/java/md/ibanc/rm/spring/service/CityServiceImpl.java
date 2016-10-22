/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package md.ibanc.rm.spring.service;

import java.util.List;
import md.ibanc.rm.entities.City;
import md.ibanc.rm.spring.dao.CityDAO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author PC01017745
 */
@Service
public class CityServiceImpl implements CityService {

    private CityDAO cityDAO;

    public void setCityDAO(CityDAO cityDAO) {
        this.cityDAO = cityDAO;
    }

    @Override
    @Transactional
    public void save(City city) {
        cityDAO.save(city);
    }

    @Override
    @Transactional
    public List findAll() {
        return cityDAO.findAll();
    }

    @Override
    @Transactional
    public City findCityByName(String nameCity) {
        return cityDAO.findCityByName(nameCity);
    }

}
