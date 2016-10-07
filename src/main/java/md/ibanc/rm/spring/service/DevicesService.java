/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package md.ibanc.rm.spring.service;

import java.util.List;
import java.util.Map;
import md.ibanc.rm.entities.Devices;

/**
 *
 * @author Zaițev.Victor
 */
public interface DevicesService {

    public void save(Devices devices);

    public List findAll();

    public Devices findDevicesByIMIE(String imie);

    public Devices findDevicesByImieAndOperatorName(String imie, String OperatorName);

    public Devices saveDevicesDetail(Map<String, String> devicesDetail);

}
