//Created by andrey on 20.06.2015.
package com.zagorskij.ozonbookshop.controller;

import com.zagorskij.ozonbookshop.service.OfferService;
import com.zagorskij.ozonbookshop.unmarshal.ProcessUnmarshaller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

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
}