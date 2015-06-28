package com.zagorskij.ozonebookshop.model;

import javax.xml.bind.annotation.XmlElement;
import java.util.List;

/**
 * Created by andrey on 28.06.2015.
 */
public class Offers {

    @XmlElement(name="offer")
    private Offer offer;

    public Offer getOffer(){
        return offer;
    }
}