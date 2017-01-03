/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package md.ibanc.rm.fake;

/**
 *
 * @author PC01017745
 */
public class NewsCategory {

    private String nameCategory;
    private String numberOfNews;
    private String imagePath;

    public NewsCategory(String nameCategory, String numberOfNews, String imagePath) {
        this.nameCategory = nameCategory;
        this.numberOfNews = numberOfNews;
        this.imagePath = imagePath;
    }

    public NewsCategory() {
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public String getNumberOfNews() {
        return numberOfNews;
    }

    public void setNumberOfNews(String numberOfNews) {
        this.numberOfNews = numberOfNews;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

}
