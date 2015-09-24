package com.zagorskij.ozonbookshop.service;

import com.zagorskij.ozonbookshop.model.Rating;

/**
 * Created by andrey on 02.08.2015.
 */
public interface RatingService {
    void addOrUpdateRating(Rating rating);
    Rating getRating(int offerId);
}