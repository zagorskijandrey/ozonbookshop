//Created by andrey on 16.06.2015.
package com.zagorskij.ozonbookshop.dao;

import com.zagorskij.ozonbookshop.model.Offer;

import java.util.List;
//The DAO layer of Offer application consist of an interface OfferDAO and its corresponding
// implementation class ContactDAOImpl.
public interface OfferDao {
    void addOffer(Offer offer);
    Offer get(int offerId);
    List<Offer> findAllOffers();
    void deleteAll(List<Offer> offer);
}
