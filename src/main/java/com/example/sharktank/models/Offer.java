package com.example.sharktank.models;

//import lombok.Getter;
//import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

//@Getter
//@Setter
//
@Document("Offers")
public class Offer{
    @Id
    private String oid;
    private String investor;
    private float amount;
    private float equity;
    private String comment;

    public Offer(){

    }
    public Offer(String oid, String investor, float amount, float tequity, String comment) {
        this.oid = oid;
        this.investor = investor;
        this.amount = amount;
        this.equity = equity;
        this.comment = comment;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getId() {
        return oid;
    }

    public Offer(String investor, float amount, float equity, String comment) {
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
