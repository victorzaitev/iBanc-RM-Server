/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package md.ibanc.rm.spring.dao;

import java.util.List;
import md.ibanc.rm.entities.NewsCategory;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Zaițev.Victor
 */

@Repository
public class NewsCategoryDAOImpl extends AbstractSpringDao implements NewsCategoryDAO {

    @Override
    public void save(NewsCategory newsCategory) {
        super.saveOrUpdate(newsCategory);
    }

    @Override
    public List findAll() {
        return super.findAll(NewsCategory.class);
    }

    
    public void qwer(){
        
        
        String sql =  " SELECT name, COUNT(*) As 'Number' " 
                    + "  FROM NewsCategory nc " 
                    + "  inner join News n " 
                    + "          on nc.id = n.newsCategoryId " 
                    + "       where nc.statusId = 1 " 
                    + "         and nc.langId=1 " 
                    + "         and n.langId = 1 " 
                    + "         and n.statusId = 1 " 
                    + "    group by nc.name ";
    }
    
}
