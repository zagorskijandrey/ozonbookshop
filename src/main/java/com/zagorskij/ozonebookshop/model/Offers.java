//Created by andrey on 28.06.2015.
package com.zagorskij.ozonebookshop.model;

import javax.xml.bind.annotation.XmlElement;
import java.util.List;

public class Offers {

    @XmlElement(name="offer")
    private List<Offer> offer;

    public List<Offer> getOffer(){
        return offer;
    }
}