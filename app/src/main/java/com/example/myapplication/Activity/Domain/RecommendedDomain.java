package com.example.myapplication.Activity.Domain;

import java.io.Serializable;

public class RecommendedDomain implements Serializable {
    private String title;
    private String pic;
    private String description;
    private double fee;
    private int addbtn;

    public RecommendedDomain(String title, String pic, String description, double fee) {
        this.title = title;
        this.pic = pic;
        this.description = description;
        this.fee = fee;
    }

    public RecommendedDomain(String title, String pic, String description, double fee, int addbtn) {
        this.title = title;
        this.pic = pic;
        this.description = description;
        this.fee = fee;
        this.addbtn = addbtn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public int getAddbtn() {
        return addbtn;
    }

    public void setAddbtn(int addbtn) {
        this.addbtn = addbtn;
    }
}
