package com.zagorskij.ozonbookshop.model;

import javax.persistence.*;

/**
 * Created by andrey on 02.08.2015.
 */
@Entity
@Table(name="rating")
public class Rating {
    @Id
    @Column(name="offerId")
    private int offerId;

    @Column(name="count")
    private int count;

    @Column(name="sum")
    private int sum;

    @Column(name="ratValue")
    private int ratValue;


    @OneToOne//(fetch = FetchType.LAZY)
    @JoinColumn(name="offerId")
    private Offer offer;

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

    public int getOfferId() {
        return offerId;
    }

    public void setOfferId(int offerId) {
        this.offerId = offerId;
    }
}