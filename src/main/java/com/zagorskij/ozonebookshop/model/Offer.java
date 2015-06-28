package com.zagorskij.ozonebookshop.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by andrey on 12.06.2015.
 */
@Entity
@Table(name="offer")
public class Offer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="offerId")
    private int offerId;
    @Column(name="URL")
    private String URL;
    @Column(name="picture")
    private String picture;
    @Column(name="name")
    private String name;
    @Column(name="year")
    private int year;
    @Column(name="ISBN")
    private String ISBN;
    @Column(name="description")
    private String description;
    @Column(name="author")
    private String author;

    public int getOfferId(){
        return offerId;
    }
    public void setOfferId(int offerId){
        this.offerId=offerId;
    }

    public String getURL() {
        return URL;
    }
    public void setURL(String URL) {
        this.URL = URL;
    }

    public String getPicture() {
        return picture;
    }
    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }

    public String getISBN() {
        return ISBN;
    }
    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor(){
        return author;
    }
    public void setAuthor(String author){
        this.author=author;
    }

}
