package com.example.sharktank.models;

public class AddOfferRequest {
    private String investor;
    private float amount;
    private float equity;
    private String comment;

    public AddOfferRequest(String investor, float amount, float equity, String comment) {
        this.investor = investor;
        this.amount = amount;
        this.equity = equity;
        this.comment = comment;
    }

    public String getInvestor() {
        return investor;
    }

    public float getAmount() {
        return amount;
    }

    public float getEquity() {
        return equity;
    }

    public String getComment() {
        return comment;
    }

    public void setInvestor(String investor) {
        this.investor = investor;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public void setEquity(float equity) {
        this.equity = equity;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
