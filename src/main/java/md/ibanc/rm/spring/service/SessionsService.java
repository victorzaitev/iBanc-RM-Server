/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package md.ibanc.rm.spring.service;

import java.util.List;
import md.ibanc.rm.entities.Sessions;

/**
 *
 * @author Zaițev.Victor
 */
public interface SessionsService {

    public void save(Sessions sessions);

    public List findAll();
    
    public Sessions findSessionsByGuid(String guid);
}
