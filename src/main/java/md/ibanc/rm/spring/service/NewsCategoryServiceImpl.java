/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package md.ibanc.rm.spring.service;

import java.util.List;
import md.ibanc.rm.entities.NewsCategory;
import md.ibanc.rm.spring.dao.NewsCategoryDAO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Zaițev.Victor
 */
@Service
public class NewsCategoryServiceImpl implements NewsCategoryService {

    private NewsCategoryDAO newsCategoryDAO;

    public void setNewsCategoryDAO(NewsCategoryDAO newsCategoryDAO) {
        this.newsCategoryDAO = newsCategoryDAO;
    }

    @Override
    @Transactional
    public void save(NewsCategory newsCategory) {
        newsCategoryDAO.save(newsCategory);
    }

    @Override
    @Transactional
    public List findAll() {
        return newsCategoryDAO.findAll();
    }

}
