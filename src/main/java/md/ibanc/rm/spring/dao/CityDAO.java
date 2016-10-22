/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package md.ibanc.rm.spring.dao;

import java.util.List;
import md.ibanc.rm.entities.City;

/**
 *
 * @author PC01017745
 */
public interface CityDAO {
    
    public void save(City city);

    public List findAll();

    public City findCityByName(String nameCity);
    
    
}
