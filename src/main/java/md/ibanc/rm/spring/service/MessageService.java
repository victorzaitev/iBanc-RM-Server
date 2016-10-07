/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package md.ibanc.rm.spring.service;

import java.util.List;
import md.ibanc.rm.entities.Message;

/**
 *
 * @author PC01017745
 */
public interface MessageService {

    public void save(Message message);

    public List findAll();

    public Message findMessageByTypeAndLang(String type, String lang);
}
