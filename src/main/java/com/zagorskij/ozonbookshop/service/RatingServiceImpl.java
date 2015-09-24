package com.zagorskij.ozonbookshop.service;

import com.zagorskij.ozonbookshop.dao.RatingDao;
import com.zagorskij.ozonbookshop.model.Rating;
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
    public void addOrUpdateRating(Rating rating) {
        ratingDao.addOrUpdateRating(rating);
    }

    @Override
    public Rating getRating(int offerId) {
        return ratingDao.getRating(offerId);
    }
}
