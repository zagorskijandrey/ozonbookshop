package com.zagorskij.ozonbookshop.controller;

import com.mysql.fabric.Response;
import com.zagorskij.ozonbookshop.model.Offer;
import com.zagorskij.ozonbookshop.model.Rating;
import com.zagorskij.ozonbookshop.service.OfferService;
import com.zagorskij.ozonbookshop.service.RatingService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Created by andrey on 05.08.2015.
 */
@Controller
public class RatingController {
    private static final Logger logger = Logger.getLogger(RatingController.class);

    @Autowired
    private OfferService offerService;

    @Autowired
    private RatingService ratingService;


    @RequestMapping(value = "/book/rating/{offerId}", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public /*@ResponseBody String*/ModelAndView setRating(@PathVariable("offerId") int offerId,
                                          @ModelAttribute("rating") Rating rating,
                                          @RequestParam(value="ratValue") int ratValue) {

        String returnText = null;
        try {
            Offer of = offerService.get(offerId);
            int count = 1;
            if (ratingService.getRating(offerId) != null) {
                rating = ratingService.getRating(offerId);
                int newCount = rating.getCount() + 1;
                int newSum = rating.getSum() + ratValue;
                int newRatValue = newSum / newCount;
                rating.setRatValue(newRatValue);
                rating.setSum(newSum);
                rating.setCount(newCount);
                ratingService.addOrUpdateRating(rating);
                returnText = "You are " + rating.getCount() + " user who gave the vote for this offer. Thank you!";
                logger.debug("Rating add!");
            } else {
                rating.setOffer(of);
                rating.setCount(count);
                rating.setSum(ratValue);
                rating.setRatValue(ratValue);
                ratingService.addOrUpdateRating(rating);
                returnText = "You are first user who gave the vote for this offer. Thank you!";
                logger.debug("First rating add!");
            }

        } catch (Exception e) {
            logger.error("Error!", e);
        }

          return /*returnText*/ new ModelAndView("redirect:/book/{offerId}");
    }
}
