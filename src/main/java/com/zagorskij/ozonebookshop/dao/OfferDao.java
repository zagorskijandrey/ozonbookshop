//Created by andrey on 16.06.2015.
package com.zagorskij.ozonebookshop.dao;

import com.zagorskij.ozonebookshop.model.Offer;

import java.util.List;
//The DAO layer of Offer application consist of an interface OfferDAO and its corresponding
// implementation class ContactDAOImpl.
public interface OfferDao {
    void addOffer(Offer offer);
    Offer get(int numId);
    List<Offer> findAllOffers();
    void deleteAll(List<Offer> offer);
    List<Offer> findPartOffers();
    Long count();
}
