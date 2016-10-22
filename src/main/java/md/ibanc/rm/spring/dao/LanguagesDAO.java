/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package md.ibanc.rm.spring.dao;

import java.util.List;
import md.ibanc.rm.entities.Languages;

/**
 *
 * @author PC01017745
 */
public interface LanguagesDAO {

    public void save(Languages languages);

    public List findAll();

    public Languages findLanguagesByShortName(String shortName);
}
