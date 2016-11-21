/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package md.ibanc.rm.spring.dao;

import java.util.List;
import md.ibanc.rm.entities.Cards;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author PC01017745
 */
public class CardsDAOImpl extends AbstractSpringDao implements CardsDAO {

    @Override
    public void save(Cards cards) {
        super.saveOrUpdate(cards);
    }

    @Override
    public List findAll() {
        return super.findAll(Cards.class);
    }

    @Override
    public List<Cards> findCardsByCustomer(String customerPersonalId) {

        Cards cards = null;

        Session session = this.sessionFactory.getCurrentSession();

        Query query = session.createQuery(" SELECT cards FROM Cards cards, "
                + " Accounts accounts, CustomerAccount customerAccount, Customers customers  "
                + " WHERE  cards.accounts.id=accounts.id "
                + "   AND  accounts.id = customerAccount.accounts.id "
                + "   AND  customers.id = customerAccount.customers.id "
                + "   AND  customers.personalId=:PersonalId "
        );

        query.setString("PersonalId", customerPersonalId);

        List<Cards> list = query.list();

        return list;

    }

}
