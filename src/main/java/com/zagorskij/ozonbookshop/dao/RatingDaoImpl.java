package com.zagorskij.ozonbookshop.dao;

import com.zagorskij.ozonbookshop.model.Rating;
import com.zagorskij.ozonbookshop.service.OfferService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import org.hibernate.Query;

/**
 * Created by andrey on 02.08.2015.
 */
@Repository("ratingDao")
public class RatingDaoImpl extends AbstractDao implements RatingDao{
    private static final Logger logger = Logger.getLogger(RatingDaoImpl.class);

    @Autowired
    private OfferService offerService;
    @Override
    public void addOrUpdateRating(Rating rating) {
        add(rating);
    }

    @Override
    public Rating getRating(int offerId) {
        Rating rating = (Rating) getSession().get(Rating.class,offerId);
        logger.info("Rating loaded successfully. Rating details="+rating);
        return rating;
    }
}