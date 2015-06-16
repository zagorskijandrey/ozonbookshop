package com.zagorskij.ozonebookshop.service;

import com.zagorskij.ozonebookshop.model.Offer;

/**
 * Created by andrey on 16.06.2015.
 */
public interface OfferService {
    void addOffer(Offer offer);
    Offer get(int offerId);
}
