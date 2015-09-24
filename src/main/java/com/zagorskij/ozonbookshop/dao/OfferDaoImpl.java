//Created by andrey on 16.06.2015.
package com.zagorskij.ozonbookshop.dao;

import com.zagorskij.ozonbookshop.model.Offer;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;


import java.util.List;

//The DAO class OfferDAOImpl implements the data access interface ContactDAO
// which defines methods such as 'findAllOffers()', 'addOffer()' and 'get()' to
// access data from database.
@Repository("offerDao")
public class OfferDaoImpl extends AbstractDao implements OfferDao{
    private static final Logger logger = Logger.getLogger(OfferDaoImpl.class);

    public void addOffer(Offer offer){
        add(offer);
        logger.info("Offer saved or updated successfully. Offer Details"+offer);
    }

    //It's a warning by which the compiler indicates that it cannot ensure type safety.
    @SuppressWarnings("unchecked")
    public List<Offer> findAllOffers(){
        //Criteria criteria= (Criteria) getSession().createCriteria(Offer.class).list();
        List<Offer> offers=getSession().createCriteria(Offer.class).list();
        for(Offer off:offers){
            logger.info("Offer list:"+off);
        }
        return offers;
        }

    public Offer get(int offerId){
        Offer offer= (Offer) getSession().get(Offer.class, offerId);
        logger.info("Offer loaded successfully. Offer details="+offer);
        return offer;
    }

    public void deleteAll(List<Offer> offer) {
        for (Offer of : offer) {
            getSession().delete(of);
        }
    }
}
