/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package md.ibanc.rm.spring.service;

import java.util.List;
import md.ibanc.rm.entities.Cards;
import md.ibanc.rm.spring.dao.CardsDAO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author PC01017745
 */
@Service
public class CardsServiceImpl implements CardsService {

    private CardsDAO cardsDAO;

    public void setCardsDAO(CardsDAO cardsDAO) {
        this.cardsDAO = cardsDAO;
    }

    @Override
    @Transactional
    public void save(Cards cards) {
        cardsDAO.save(cards);
    }

    @Override
    @Transactional
    public List findAll() {
        return cardsDAO.findAll();
    }

    @Override
    @Transactional
    public List<Cards> findCardsByCustomer(String customerPersonalId) {
        return cardsDAO.findCardsByCustomer(customerPersonalId);
    }

}
