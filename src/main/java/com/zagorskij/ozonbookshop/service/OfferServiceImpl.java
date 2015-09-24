//Created by andrey on 16.06.2015.
package com.zagorskij.ozonbookshop.service;

import com.zagorskij.ozonbookshop.dao.OfferDao;
import com.zagorskij.ozonbookshop.model.Offer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
// This service layer that the business logic. I am using the DAO to interact with the
// Database and return the results to the caller.
@Service(value="offerService")
@Transactional
public class OfferServiceImpl implements OfferService {
    @Autowired
    private OfferDao offerDao;

    public void addOffer(Offer offer){
        offerDao.addOffer(offer);
    }

    public List<Offer> findAllOffers(){
        return offerDao.findAllOffers();
    }

    public Offer get(int offerId){
        return offerDao.get(offerId);
    }

    public void deleteAll(List<Offer> offer){
        offerDao.deleteAll(offer);
    }
}
