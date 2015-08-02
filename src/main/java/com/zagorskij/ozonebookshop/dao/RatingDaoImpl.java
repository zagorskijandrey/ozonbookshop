package com.zagorskij.ozonebookshop.dao;

import com.zagorskij.ozonebookshop.model.Rating;
import org.springframework.stereotype.Repository;

/**
 * Created by andrey on 02.08.2015.
 */
@Repository("ratingDao")
public class RatingDaoImpl extends AbstractDao implements RatingDao{
    @Override
    public void addRating(Rating rating) {
        add(rating);

    }

    @Override
    public Rating getRating(int numId) {
        return (Rating) getSession().get(Rating.class,numId);
    }
}