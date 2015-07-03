//Created by andrey on 16.06.2015.
package com.zagorskij.ozonebookshop.dao;

import com.zagorskij.ozonebookshop.model.Offer;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;


import java.util.List;

//The DAO class OfferDAOImpl implements the data access interface ContactDAO
// which defines methods such as 'findAllOffers()', 'addOffer()' and 'get()' to
// access data from database.
@Repository("offerDao")
public class OfferDaoImpl extends AbstractDao implements OfferDao{

    public void addOffer(Offer offer){
        add(offer);
    }

    //It's a warning by which the compiler indicates that it cannot ensure type safety.
    @SuppressWarnings("unchecked")
    public List<Offer> findAllOffers(){
        Criteria criteria= (Criteria) getSession().createCriteria(Offer.class);
        return (List<Offer>) criteria.list();
    }

    public Offer get(int numId){
        return (Offer) getSession().get(Offer.class, numId);
    }

    public void deleteAll(List<Offer> offer) {
        for (Offer of : offer) {
            getSession().delete(of);
        }
    }
}
