package com.zagorskij.ozonebookshop.service;

import com.zagorskij.ozonebookshop.dao.OfferDao;
import com.zagorskij.ozonebookshop.model.Offer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by andrey on 16.06.2015.
 */
@Service(value="offerService")
@Transactional
public class OfferServiceImpl implements OfferService {
    @Autowired
    private OfferDao offerDao;

    public void addOffer(Offer offer){
        offerDao.addOffer(offer);
    }

    public Offer get(int offerId){
        return offerDao.get(offerId);
    }
}
