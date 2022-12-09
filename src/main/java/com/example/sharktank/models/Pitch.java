package com.example.sharktank.models;

//import lombok.Data;
//import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
//@Data
//@Getter

@Document("Pitches")

public class Pitch{

    @Id
    private String pid;
    private String entrepreneur;
    private String pitchTitle;
    private String pitchIdea;

    private float askAmount;
    private float equity;
    ArrayList<Offer> offers;

    public Pitch(){

    }
    public Pitch(String pid, String entrepreneur, String pitchTitle, String pitchIdea, float askAmount, float equity, ArrayList<Offer> offers) {
        this.pid = pid;
        this.entrepreneur = entrepreneur;
        this.pitchTitle = pitchTitle;
        this.pitchIdea = pitchIdea;
        this.askAmount = askAmount;
        this.equity = equity;
        this.offers = offers;
    }

    public Pitch(String entrepreneur, String pitchTitle, String pitchIdea, float askAmount, float equity) {
        this.entrepreneur = entrepreneur;
        this.pitchTitle = pitchTitle;
        this.pitchIdea = pitchIdea;
        this.askAmount = askAmount;
        this.equity = equity;
        this.offers = new ArrayList<>(0);
        //this.offers.add(new Offer());
    }
//    public String getTest(){
//        return pid;
//    }
    public String getId() {
        return pid;
    }

    public String getEntrepreneur() {
        return entrepreneur;
    }

    public String getPitchTitle() {
        return pitchTitle;
    }

    public String getPitchIdea() {
        return pitchIdea;
    }

    public float getAskAmount() {
        return askAmount;
    }

    public float getEquity() {
        return equity;
    }


    public void setEntrepreneur(String entrepreneur) {
        this.entrepreneur = entrepreneur;
    }

    public void setPitchTitle(String pitchTitle) {
        this.pitchTitle = pitchTitle;
    }

    public void setPitchIdea(String pitchIdea) {
        this.pitchIdea = pitchIdea;
    }

    public void setAskAmount(float askAmount) {
        this.askAmount = askAmount;
    }

    public void setEquity(float equity) {
        this.equity = equity;
    }

    public void setOffers(ArrayList<Offer> offers) {
        this.offers = offers;
    }

    public ArrayList<Offer> getOffers() {
        return offers;
    }
}
