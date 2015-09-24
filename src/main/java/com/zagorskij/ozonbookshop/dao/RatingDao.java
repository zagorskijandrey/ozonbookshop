package com.zagorskij.ozonbookshop.dao;

import com.zagorskij.ozonbookshop.model.Offer;
import com.zagorskij.ozonbookshop.model.Rating;

/**
 * Created by andrey on 02.08.2015.
 */
public interface RatingDao {
    void addOrUpdateRating(Rating rating);
    Rating getRating(int offerId);
}