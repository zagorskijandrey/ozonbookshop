package com.zagorskij.ozonebookshop.unmarshal;

import com.zagorskij.ozonebookshop.model.Offer;
import com.zagorskij.ozonebookshop.model.Offers;
import com.zagorskij.ozonebookshop.model.Shop;
import com.zagorskij.ozonebookshop.model.YmlCatalog;
import com.zagorskij.ozonebookshop.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.Unmarshaller;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;

/**
 * Created by andrey on 14.06.2015.
 */

public class ProcessUnmarshaller {
    @Autowired
    private OfferService offerService;

    private Unmarshaller unmarshaller;

    public void setUnmarshaller(Unmarshaller unmarshaller) {
        this.unmarshaller = unmarshaller;
    }

    public void xmlToObject(String path) throws IOException {
        /*InputStream input = null;
        try {
            input = new URL(url).openStream();
            Offer offer= (Offer) unmarshaller.unmarshal(new StreamSource(input));
            offerService.addOffer(offer);
        } finally {
            input.close();
        }*/


            FileInputStream fis = null;
            try {
                fis = new FileInputStream(path);
                YmlCatalog ymlCatalog= (YmlCatalog)unmarshaller.unmarshal(new StreamSource(fis));
                Shop shop = ymlCatalog.getShop();
                Offers offers= shop.getOffers();

                Offer offer= (Offer) offers.getOffer();
                offerService.addOffer(offer);

            } finally {
                fis.close();
            }
        }

        /*try{
            //path="";
            File f = new File(path);
            Source xml = new StreamSource(f);
        //File xml = new File("C:\\1159776.xml");
        JAXBContext jc = JAXBContext.newInstance(YmlCatalog.class);
        unmarshaller = (Unmarshaller) jc.createUnmarshaller();

        YmlCatalog ymlCatalog= (YmlCatalog)unmarshaller.unmarshal(xml);
        Shop shop = ymlCatalog.getShop();
        Offers offers= shop.getOffers();

        Offer offer= (Offer) offers.getOffer();
            offerService.addOffer(offer);
        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }
    /*public void xmlToObject(File file) throws IOException {
        Offer offer= (Offer) unmarshaller.unmarshal((Source) file);
    }*/
}
