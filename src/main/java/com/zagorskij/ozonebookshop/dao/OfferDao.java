package com.zagorskij.ozonebookshop.dao;

import com.zagorskij.ozonebookshop.model.Offer;

/**
 * Created by andrey on 16.06.2015.
 */
public interface OfferDao {
    void addOffer(Offer offer);
    Offer get(int offerId);
}
