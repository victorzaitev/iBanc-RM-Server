/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package md.ibanc.rm.entities.utils;

import java.util.Date;

/**
 *
 * @author Zaițev.Victor
 */
public class ExchangeRateList{

    private String valutaShortName;
    private Date dateCurs;
    private double officialCurs;
    private double buyCurs;
    private double sellCurs;
    private boolean imagePath;

    public String getValutaShortName() {
        return valutaShortName;
    }

    public void setValutaShortName(String valutaShortName) {
        this.valutaShortName = valutaShortName;
    }

    public Date getDateCurs() {
        return dateCurs;
    }

    public void setDateCurs(Date dateCurs) {
        this.dateCurs = dateCurs;
    }

    public double getOfficialCurs() {
        return officialCurs;
    }

    public void setOfficialCurs(double officialCurs) {
        this.officialCurs = officialCurs;
    }

    public double getBuyCurs() {
        return buyCurs;
    }

    public void setBuyCurs(double buyCurs) {
        this.buyCurs = buyCurs;
    }

    public double getSellCurs() {
        return sellCurs;
    }

    public void setSellCurs(double sellCurs) {
        this.sellCurs = sellCurs;
    }

    public boolean isImagePath() {
        return imagePath;
    }

    public void setImagePath(boolean imagePath) {
        this.imagePath = imagePath;
    }


}
