package com.zagorskij.ozonebookshop.model;




import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;


/**
 * Created by andrey on 12.06.2015.
 */

@Entity
@Table(name="shop")
public class Shop {
    @Id
    @GeneratedValue
    @Column(name="shopId")
    private int shopId;
    private String name;
    private String company;
    private String URL;
    private List<Category> category;
    private List<Offer> offer;


    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }

    public String getCompany(){
        return company;
    }
    public void setCompany(String company){
        this.company=company;
    }
    //@XmlElement
    public String getURL(){
        return URL;
    }
    public void setURL(String URL){
        this.URL=URL;
    }
    //@XmlElement
    public List<Category> getCategory(){
        return category;
    }
    public void setCategory(List<Category> category){
        this.category=category;
    }
    //@XmlElement
    public List<Offer> getOffer(){
        return offer;
    }
    public void setOffer(List<Offer> offer){
        this.offer=offer;
    }
}
