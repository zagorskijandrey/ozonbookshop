//Created by andrey on 16.06.2015.
package com.zagorskij.ozonebookshop.service;

import com.zagorskij.ozonebookshop.model.Offer;
import org.springframework.data.domain.PageRequest;

import java.util.List;

//The Service layer of Offer consist of an interface OfferService and its corresponding
// implementation class OfferServiceImpl.
public interface OfferService {
    void addOffer(Offer offer);
    List<Offer> findAllOffers();
    Offer get(int numId);
    void deleteAll(List<Offer> offer);
    List<Offer> findPartOffers();
    Long count();
}
