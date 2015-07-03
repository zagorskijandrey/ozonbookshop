//Created by andrey on 20.06.2015.
package com.zagorskij.ozonebookshop.controller;

import com.zagorskij.ozonebookshop.model.Offer;
import com.zagorskij.ozonebookshop.service.OfferService;
import com.zagorskij.ozonebookshop.unmarshal.ProcessUnmarshaller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;

import java.io.IOException;
import java.util.List;

//Add the controller which will serve the GET and POST request.
@Controller
public class UploadPage {
    @Autowired
    private ProcessUnmarshaller processUnmarshaller;

    @Autowired
    private OfferService offerService;

    //This method will provide the medium to add URL resource
    @RequestMapping(value = "/fileUploadForm", method = RequestMethod.GET)
    public ModelAndView getUploadForm() {
        return new ModelAndView("uploadForm");
    }

    //Method for handling file download request from client
    @RequestMapping(value = "/fileUpload", method = RequestMethod.POST)
    public String fileUploaded(@RequestParam("path") String path,
                               ModelMap model) throws IOException {
        processUnmarshaller.xmlToObject(path);
        model.addAttribute("parse", path);
        return "showFile";
    }

    //This method will list all existing offers.
    @RequestMapping(value = "/listOffers", method = RequestMethod.GET)
    public String listOffers(ModelMap model) {
        List<Offer> offers = null;
        try{
            offers = offerService.findAllOffers();
            model.addAttribute("offers", offers);
        } catch (Exception e){
            e.printStackTrace();
        }
        return "listResult";
    }

    //This method will find an offer by it's numId value.
    @RequestMapping(value="/book/{numId}", method =RequestMethod.GET)
    public String findBookForId(@PathVariable ("numId") int numId,
                                @ModelAttribute("offer") Offer offer, ModelMap model){
        try{
            offer = offerService.get(numId);
            model.addAttribute("offer", offer);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "book";
    }

    //This method will list all delete offers.
    @RequestMapping (value ="/goodbye", method =RequestMethod.GET)
    public String deleteAll(ModelMap model){
        List<Offer> offers=null;
        try{
            offers=offerService.findAllOffers();
            offerService.deleteAll(offers);
            model.addAttribute("delete", offers);
        } catch (Exception e){
            e.printStackTrace();
        }
        return "clear";
    }
}