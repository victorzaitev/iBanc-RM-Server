/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package md.ibanc.rm.spring.service;

import java.util.List;
import md.ibanc.rm.entities.Languages;
import md.ibanc.rm.spring.dao.LanguagesDAO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author PC01017745
 */
@Service
public class LanguagesServiceImpl implements LanguagesService {

    private LanguagesDAO languagesDAO;

    public void setLanguagesDAO(LanguagesDAO languagesDAO) {
        this.languagesDAO = languagesDAO;
    }

    @Override
    @Transactional
    public void save(Languages languages) {
        languagesDAO.save(languages);
    }

    @Override
    @Transactional
    public List findAll() {
        return languagesDAO.findAll();
    }

    @Override
    @Transactional
    public Languages findLanguagesByShortName(String shortName) {
        return languagesDAO.findLanguagesByShortName(shortName);
    }

}
