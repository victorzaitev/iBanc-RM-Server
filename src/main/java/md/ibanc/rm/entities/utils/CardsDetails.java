/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package md.ibanc.rm.entities.utils;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Zaițev.Victor
 */
public class CardsDetails extends BaseEntity {

  //  public List<String> strList = new ArrayList<>();

    public List<CardsList> cardsList = new ArrayList<>();

    public List<CardsList> getCardsList() {
        return cardsList;
    }

    public void setCardsList(List<CardsList> cardsList) {
        this.cardsList = cardsList;
    }
//    public List<String> getStrList() {
//        return strList;
//    }
//
//    public void setStrList(List<String> strList) {
//        this.strList = strList;
//    }
}
