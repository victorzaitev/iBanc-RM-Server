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
public class CustomersDetails extends BaseEntity {

    private String firstName;
    private String lastName;
    private String personalId;
    private String email;
    private Date lasstAcces;
    private String adress;
    private String phone;
    private Date registeDate;
    private String guid;
    private String token;

    public CustomersDetails() {
    }

    public CustomersDetails(String firstName, String lastName, String personalId, String email, Date lasstAcces, String adress, String phone, Date registeDate, String guid) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.personalId = personalId;
        this.email = email;
        this.lasstAcces = lasstAcces;
        this.adress = adress;
        this.phone = phone;
        this.registeDate = registeDate;
        this.guid = guid;

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPersonalId() {
        return personalId;
    }

    public void setPersonalId(String personalId) {
        this.personalId = personalId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getLasstAcces() {
        return lasstAcces;
    }

    public void setLasstAcces(Date lasstAcces) {
        this.lasstAcces = lasstAcces;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getRegisteDate() {
        return registeDate;
    }

    public void setRegisteDate(Date registeDate) {
        this.registeDate = registeDate;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
    
    

}
