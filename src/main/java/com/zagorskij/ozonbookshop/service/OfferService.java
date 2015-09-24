//Created by andrey on 16.06.2015.
package com.zagorskij.ozonbookshop.service;

import com.zagorskij.ozonbookshop.model.Offer;

import java.util.List;

//The Service layer of Offer consist of an interface OfferService and its corresponding
// implementation class OfferServiceImpl.
public interface OfferService {
    void addOffer(Offer offer);
    List<Offer> findAllOffers();
    Offer get(int offerId);
    void deleteAll(List<Offer> offer);
}
