package com.example.sharktank.service;

import com.example.sharktank.models.AddPitchRequest;
import com.example.sharktank.models.Pitch;
import com.example.sharktank.models.PitchResponse;
import com.example.sharktank.repository.OffersRepository;
import com.example.sharktank.repository.PitchesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;
import com.example.sharktank.models.AddOfferRequest;
import com.example.sharktank.models.Offer;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;



@Component
public class PitchService{
    @Autowired
    MongoTemplate mongoTemplate;
    @Autowired
    OffersRepository offersRepository;

    @Autowired
    private PitchesRepository pitchesRepository;
    public List<Pitch> getPitches() {
        //Sort sort = new Sort(Sort.Direction.ASC, "pid");
        List<Pitch> pitches = pitchesRepository.getAllPitches();
        if(pitches == null){
            return null;
        }
        return pitches;
    }
    public Pitch getPitch(String pid) {
        Pitch pitch = pitchesRepository.findById(pid).get();
        return pitch;
    }
    public PitchResponse addPitch(AddPitchRequest addPitchRequest){
        if(ObjectUtils.isEmpty(addPitchRequest) || addPitchRequest == null){
            return null;
        }
        if(addPitchRequest.getEntrepreneur().isEmpty() || addPitchRequest.getEntrepreneur().isBlank()){
            return null;
        }
        if(addPitchRequest.getPitchIdea().isEmpty() || addPitchRequest.getPitchIdea().isBlank()){
            return null;
        }
        if(addPitchRequest.getPitchTitle().isEmpty() || addPitchRequest.getPitchTitle().isBlank()){
            return null;
        }
        if(addPitchRequest.getAskAmount() == 0.0){
            return null;
        }
        if(addPitchRequest.getEquity() < 0.0 || addPitchRequest.getEquity()>100.0 || addPitchRequest.getEquity() == 0.0){
            return null;
        }
        Pitch pitch = new Pitch(addPitchRequest.getEntrepreneur(),addPitchRequest.getPitchTitle(),addPitchRequest.getPitchIdea(),addPitchRequest.getAskAmount(),addPitchRequest.getEquity());
        pitch = this.pitchesRepository.save(pitch);
        return new PitchResponse(pitch.getId());
    }
    public PitchResponse addOffer(String pid, AddOfferRequest addOfferRequest){
        if(ObjectUtils.isEmpty(addOfferRequest) || addOfferRequest == null){
            return null;
        }
        if(addOfferRequest.getAmount() == 0.0){
            return null;
        }
        if(addOfferRequest.getInvestor().isBlank() || addOfferRequest.getInvestor().isEmpty()){
            return null;
        }
        if(addOfferRequest.getComment().isBlank() ||  addOfferRequest.getComment().isEmpty()){
            return null;
        }
        if(addOfferRequest.getEquity() < 0.0 || addOfferRequest.getEquity() > 100.0 || addOfferRequest.getEquity() == 0.0 ){
            return null;
        }


            Pitch pitch =  mongoTemplate.findById(pid,Pitch.class);
            ArrayList<Offer> o = pitch.getOffers();
            int oid = o.size();
            Offer offer = new Offer(addOfferRequest.getInvestor(),addOfferRequest.getAmount(),addOfferRequest.getEquity(),addOfferRequest.getComment());
            offersRepository.save(offer);
            o.add(offer);
            pitch.setOffers(o);
            pitchesRepository.save(pitch);
            return new PitchResponse(pitch.getId());

    }
}