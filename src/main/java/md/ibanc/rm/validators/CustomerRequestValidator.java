/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package md.ibanc.rm.validators;

import md.ibanc.rm.entities.Customers;
import md.ibanc.rm.entities.utils.CardsDetails;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author PC01017745
 */
public class CustomerRequestValidator {

    private final Customers customers;
    private final String GUID;
    private boolean isCustomersValid = true;
    private ResponseEntity<CardsDetails> responseEntity;

    public CustomerRequestValidator(Customers customers, String GUID) {
        this.customers = customers;
        this.GUID = GUID;
    }

    public boolean isIsCustomersValid() {
        return isCustomersValid;
    }

    public ResponseEntity<CardsDetails> getResponseEntity() {
        return responseEntity;
    }

    public void validate() {

    }

}
