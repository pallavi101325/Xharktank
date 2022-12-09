package com.example.sharktank.models;

import java.util.ArrayList;

//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.Setter;
//
//@Getter
//@Setter
//@AllArgsConstructor
public class AddPitchRequest {

    private String entrepreneur;
    private String pitchTitle;
    private String pitchIdea;

    private float askAmount;
    private float equity;

    public AddPitchRequest(String entrepreneur, String pitchTitle, String pitchIdea, float askAmount, float equity) {
        this.entrepreneur = entrepreneur;
        this.pitchTitle = pitchTitle;
        this.pitchIdea = pitchIdea;
        this.askAmount = askAmount;
        this.equity = equity;
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
}
