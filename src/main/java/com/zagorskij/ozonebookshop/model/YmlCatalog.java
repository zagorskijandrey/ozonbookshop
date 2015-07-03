//Created by andrey on 28.06.2015.
package com.zagorskij.ozonebookshop.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

//Annotate properties with javax.xml.bind.annotation XmlRootElement, XmlAttribute and XmlElement
//that will map XML root element, attribute and element with java bean properties
@XmlRootElement(name="yml_catalog")
public class YmlCatalog {

    private Shop shop;

    @XmlElement
    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }
}