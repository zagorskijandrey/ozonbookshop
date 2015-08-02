package com.zagorskij.ozonebookshop.service;

import com.zagorskij.ozonebookshop.dao.RatingDao;
import com.zagorskij.ozonebookshop.model.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by andrey on 02.08.2015.
 */
@Service("ratingService")
@Transactional
public class RatingServiceImpl implements RatingService {
    @Autowired
    private RatingDao ratingDao;

    @Override
    public void addRating(Rating rating) {
        ratingDao.addRating(rating);
    }
}
