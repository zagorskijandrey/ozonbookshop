package com.zagorskij.ozonebookshop.controller;

import com.zagorskij.ozonebookshop.model.Offer;
import com.zagorskij.ozonebookshop.unmarshal.ProcessUnmarshaller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.net.URL;

/**
 * Created by andrey on 23.06.2015.
 */
@Controller
@RequestMapping(value = "/", method = RequestMethod.HEAD)

public class UploadPage {
    @Autowired
    private ProcessUnmarshaller processUnmarshaller;

    @RequestMapping(value = {"/","/hello"}, method = RequestMethod.GET)
    public String index(ModelMap map) {
        map.put("msg", "Hello! We are welcome you in our shop!");
        return "hello";
    }
    @RequestMapping(value = "/fileUploadForm", method = RequestMethod.GET)
    public ModelAndView getUploadForm() {
        return new ModelAndView("uploadForm");
    }

    @RequestMapping(value = "/fileUpload", method = RequestMethod.POST)
    public String fileUploaded(@RequestParam("path") String path,
                               ModelMap model) throws IOException {
        processUnmarshaller.xmlToObject(path);
        model.addAttribute("parse",path);
        return "showFile";
    }








    /*@RequestMapping(value = "/fileUploadForm", method = RequestMethod.GET)
    public ModelAndView getUploadForm() {
        return new ModelAndView("uploadForm");
    }
    @RequestMapping(value = "/fileUpload", method = RequestMethod.POST)
    public String fileUploaded(@RequestParam("url") String url,
                                ModelMap model) throws IOException {
        processUnmarshaller.xmlToObject(url);
        model.addAttribute("parse",url);
        return "showFile";
    }
    /*@RequestMapping(value = "/shop", method = RequestMethod.GET)
    public ModelAndView shop(@RequestParam(value="url",required=true) String url) throws IOException {
        processUnmarshaller.xmlToObject(url);
        return new ModelAndView("shop", "command", new Offer());
    }

    /*@RequestMapping(value="/shop", params={"submit"},method =RequestMethod.GET)
    public String shop(@RequestParam(value="url",required=true) String url,@ModelAttribute("offer") Offer offer,
                       ModelMap model) throws IOException {
        offer = processUnmarshaller.xmlToObject(url);
        model.addAttribute("shop", offer.getName());
        return "shop";
    }*/

}
