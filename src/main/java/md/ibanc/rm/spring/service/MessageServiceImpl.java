/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package md.ibanc.rm.spring.service;

import java.util.List;
import md.ibanc.rm.entities.Message;
import md.ibanc.rm.spring.dao.MessageDAO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author PC01017745
 */
@Service
public class MessageServiceImpl implements MessageService {

    private MessageDAO messageDAO;

    public void setMessageDAO(MessageDAO messageDAO) {
        this.messageDAO = messageDAO;
    }

    @Override
    @Transactional
    public void save(Message message) {
        messageDAO.save(message);
    }

    @Override
    @Transactional
    public List findAll() {
        return messageDAO.findAll();
    }

    @Override
    @Transactional
    public Message findMessageByTypeAndLang(String type, String lang) {
        return messageDAO.findMessageByTypeAndLang(type, lang);
    }

}
