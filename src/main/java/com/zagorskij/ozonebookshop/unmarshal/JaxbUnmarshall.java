package com.zagorskij.ozonebookshop.unmarshal;


import com.zagorskij.ozonebookshop.model.Offer;
import com.zagorskij.ozonebookshop.model.Shop;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;

/**
 * Created by andrey on 12.06.2015.
 */
public class JaxbUnmarshall {
    public static void main(String[] args) {
        try {
            InputStream input = new URL("http://static.ozone.ru/multimedia/yml/facet/family_catalog/1159776.xml").openStream();
            JAXBContext jaxbContext= JAXBContext.newInstance(Shop.class);
            Unmarshaller jaxbUnmarshaller= jaxbContext.createUnmarshaller();
            Shop shop=(Shop) jaxbUnmarshaller.unmarshal(input);

            System.out.println("Shop name: " + shop.getName() + ", company: " + shop.getCompany());
            System.out.println("Offer: ");
            List<Offer> list= shop.getOffer();
            for(Offer offer:list){
                System.out.println(offer.getAuthor()+", "+offer.getISBN()+", "+offer.getName());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
