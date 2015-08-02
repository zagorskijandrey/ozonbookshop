package com.zagorskij.ozonebookshop.dao;

import com.zagorskij.ozonebookshop.model.Rating;

/**
 * Created by andrey on 02.08.2015.
 */
public interface RatingDao {
    void addRating(Rating rating);
    Rating getRating(int numId);
}