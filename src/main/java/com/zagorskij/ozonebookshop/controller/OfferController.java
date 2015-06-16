package com.zagorskij.ozonebookshop.controller;

import com.zagorskij.ozonebookshop.model.Offer;
import com.zagorskij.ozonebookshop.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by andrey on 16.06.2015.
 */
@Controller
public class OfferController {
    @Autowired
    private OfferService offerService;

    @RequestMapping(value="/offer", method= RequestMethod.GET)
    public ModelAndView offer(){
        return new ModelAndView("offer","command",new Offer());
    }

    @RequestMapping(value="/addOffer", method=RequestMethod.POST)

}
