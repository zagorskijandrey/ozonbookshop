package com.zagorskij.ozonbookshop.controller;

import com.zagorskij.ozonbookshop.model.Offer;
import com.zagorskij.ozonbookshop.model.Rating;
import com.zagorskij.ozonbookshop.service.OfferService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by andrey on 03.08.2015.
 */
@Controller
public class ViewOfferController {
    private static final Logger logger = Logger.getLogger(ViewOfferController.class);
    @Autowired
    private OfferService offerService;

    //This method will find an offer by it's numId value.
    @RequestMapping(value="/book/{offerId}", method ={RequestMethod.GET})
    public String findBookForId(@PathVariable("offerId") int offerId,
                                @ModelAttribute("offer") Offer offer, ModelMap model){
        try{
            offer = offerService.get(offerId);
            model.addAttribute("offer", offer);
            model.addAttribute("rating", new Rating());
        }catch (Exception e){
            logger.error("Error!", e);
        }
        return "book";
    }

    //This method will list all delete offers.
    @RequestMapping(value ="/goodbye", method = RequestMethod.GET)
    public String deleteAll(ModelMap model){
        List<Offer> offers=null;
        try{
            offers=offerService.findAllOffers();
            offerService.deleteAll(offers);
            model.addAttribute("delete", offers);
        } catch (Exception e){
            logger.error("Error!", e);
        }
        return "clear";
    }

    @RequestMapping(value = {"/","/listOffers"}, method = RequestMethod.GET)
    public String listOffers(HttpServletRequest request, HttpServletResponse response, ModelMap model){
        List<Offer> offers = null;
        try {
            offers=offerService.findAllOffers();
            PagedListHolder<Offer> pagedListHolder = new PagedListHolder<Offer>(offers);
            int page = ServletRequestUtils.getIntParameter(request, "p", 0);
            pagedListHolder.setPage(page);
            int pageSize = 5;
            pagedListHolder.setPageSize(pageSize);
            model.addAttribute("pagedListHolder", pagedListHolder);

        } catch (Exception e) {
            logger.error("Error!", e);
        }
        return "listResult";
    }
}
