//Created by andrey on 12.06.2015.
package com.zagorskij.ozonebookshop.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAttribute;
import java.io.Serializable;

//Create the actual Offer Entity itself whose instances we will be working with in database.
@Entity
@Table(name="offer")
public class Offer implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="numId")
    private int numId;
    @Column(name="bookId")
    private int bookId;
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

    public int getNumId(){
        return numId;
    }
    public void setNumId(int numId){
        this.numId=numId;
    }

    @XmlAttribute(name="id")
    public int getBookId(){
        return bookId;
    }
    public void setBookId(int bookId){
        this.bookId=bookId;
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
