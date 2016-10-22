/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package md.ibanc.rm.spring.service;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import md.ibanc.rm.entities.Customers;
import md.ibanc.rm.entities.Devices;
import md.ibanc.rm.entities.SingInOutSessions;

/**
 *
 * @author Zaițev.Victor
 */
public interface SingInOutSessionsService {

    public void save(SingInOutSessions singInOutSessions);

    public List findAll();

    public SingInOutSessions save(String guidId, Customers customers, HttpServletRequest request);

    public boolean findSingInOutSessionsByCustomersAndDevices(Customers customers, Devices devices);

    public SingInOutSessions findById(long id);
    
    public SingInOutSessions findSingInOutSessionsBySessionsGuid(String guid);

}
