package com.zagorskij.ozonebookshop.dao;

import com.zagorskij.ozonebookshop.model.Offer;
import org.springframework.stereotype.Repository;

/**
 * Created by andrey on 16.06.2015.
 */
@Repository("offerDao")
public class OfferDaoImpl extends AbstractDao implements OfferDao{

    public void addOffer(Offer offer){
        add(offer);
    }

    public Offer get(int offerId){
        return (Offer) getSession().createSQLQuery("Select from Offer where offerId="+offerId)
                .uniqueResult();
    }
}
