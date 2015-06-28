package com.zagorskij.ozonebookshop.model;

import javax.xml.bind.annotation.XmlElement;

/**
 * Created by andrey on 28.06.2015.
 */
public class Shop {
    @XmlElement(name="name")
    private String name;
    @XmlElement(name="company")
    private String company;
    @XmlElement(name="url")
    private String url;
    @XmlElement(name="offers")
    private Offers offers;


    public String getName() {
        return name;
    }

    public String getCompany(){
        return company;
    }

    public String getUrl(){
        return url;
    }

    public Offers getOffers(){
        return offers;
    }
}
