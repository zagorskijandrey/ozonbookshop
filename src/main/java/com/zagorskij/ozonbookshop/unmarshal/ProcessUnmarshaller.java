//Created by andrey on 14.06.2015.
package com.zagorskij.ozonbookshop.unmarshal;

import com.zagorskij.ozonbookshop.model.Offer;
import com.zagorskij.ozonbookshop.model.Offers;
import com.zagorskij.ozonbookshop.model.Shop;
import com.zagorskij.ozonbookshop.model.YmlCatalog;
import com.zagorskij.ozonbookshop.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.Unmarshaller;

import javax.xml.transform.stream.StreamSource;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

//Write the core logic which will convert the xml into the java object.
public class ProcessUnmarshaller {
    @Autowired
    private OfferService offerService;

    private Unmarshaller unmarshaller;

    public void setUnmarshaller(Unmarshaller unmarshaller) {
        this.unmarshaller = unmarshaller;
    }

    //Converts XML to Java Object and save database
    public void xmlToObject(String path) throws IOException {
        //Construct the complete absolute path of the file
        InputStream input = null;
            try {
                input = new URL(path).openStream();
                YmlCatalog ymlCatalog= (YmlCatalog)unmarshaller.unmarshal(new StreamSource(input));
                Shop shop = ymlCatalog.getShop();
                Offers offers= shop.getOffers();

                for(Offer offer:offers.getOffer()){
                    offerService.addOffer(offer);
                }

            } finally {
                input.close();
            }
        }
}
