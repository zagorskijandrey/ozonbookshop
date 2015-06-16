package com.zagorskij.ozonebookshop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by andrey on 12.06.2015.
 */
@Entity
@Table(name="category")
public class Category {
    @Column(name="id")
    private int id;
    @Column(name="name")
    private String name;
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id=id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
