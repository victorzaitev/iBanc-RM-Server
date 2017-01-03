/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package md.ibanc.rm.controllers.request;

import java.util.ArrayList;
import java.util.List;
import md.ibanc.rm.fake.NewsCategory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author PC01017745
 */
@RestController
public class RequestNewsController {

    @RequestMapping(value = "/find/newsCategory", method = RequestMethod.GET)
    public ResponseEntity<List<NewsCategory>> getCardsByUser() {
        
        List<NewsCategory> list = new ArrayList<>();
        NewsCategory newsCategory = new NewsCategory();
        newsCategory.setNameCategory("Deposite");
        newsCategory.setNumberOfNews("10 News");
        newsCategory.setImagePath("album11");
        
        list.add(newsCategory);
        newsCategory = new NewsCategory();
        newsCategory.setNameCategory("Service");
        newsCategory.setNumberOfNews("23 News");
        newsCategory.setImagePath("album10");
        
        list.add(newsCategory);
        
        
        
        
        
        return new ResponseEntity<>(list, HttpStatus.OK);

    }

}
