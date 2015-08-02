package com.zagorskij.ozonebookshop.model;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import javax.persistence.*;

/**
 * Created by andrey on 02.08.2015.
 */
@Entity
@Table(name="rating")
public class Rating {
    @GenericGenerator(name = "generator", strategy = "foreign",
            parameters = @Parameter (name = "property", value = "offer"))
    @Id
    @GeneratedValue(generator = "generator")
    @Column(name = "numId", unique = true, nullable = false)
    private int numId;

    @Column(name="count")
    private int count;

    @Column(name="sum")
    private int sum;

    @Column(name="ratValue")
    private int ratValue;

    @OneToOne(fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    private Offer offer;

    public int getNumId() {
        return numId;
    }

    public void setNumId(int numId) {
        this.numId = numId;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public int getRatValue() {
        return ratValue;
    }

    public void setRatValue(int ratValue) {
        this.ratValue = ratValue;
    }

    public Offer getOffer() {
        return offer;
    }

    public void setOffer(Offer offer) {
        this.offer = offer;
    }
}