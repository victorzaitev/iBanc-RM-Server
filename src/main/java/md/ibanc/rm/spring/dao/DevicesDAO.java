/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package md.ibanc.rm.spring.dao;

import java.util.List;
import md.ibanc.rm.entities.Devices;

/**
 *
 * @author Zaițev.Victor
 */
public interface DevicesDAO {

    public void save(Devices devices);

    public List findAll();

    public Devices findDevicesByIMIE(String imie);

    public Devices findDevicesByImieAndOperatorName(String imie, String name);
}
