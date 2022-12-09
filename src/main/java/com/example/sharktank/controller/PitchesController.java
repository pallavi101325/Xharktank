package com.example.sharktank.controller;
import com.example.sharktank.models.AddPitchRequest;
import com.example.sharktank.models.Pitch;
import com.example.sharktank.models.PitchResponse;
import com.example.sharktank.service.PitchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Sort;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Sort.Direction;
//import org.springframework.data.domain.Sort;
import com.example.sharktank.models.Offer;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.sharktank.models.AddOfferRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;
import java.util.Optional;
//import javax.management.Query;
//import org.springframework.data.domain.Sort;

//@Service
//@Component
@RestController
@RequestMapping("/pitches")
public class PitchesController {

    private static final Logger logger = LoggerFactory.getLogger(PitchesController.class);
    @Autowired
    MongoTemplate mongoTemplate;
    @Autowired
    private PitchService pitchService;

    @GetMapping
    public ResponseEntity<?> getPitches() throws Exception {
        //System.out.println("hello");
       Query query = new Query();
       query.with(org.springframework.data.domain.Sort.by(org.springframework.data.domain.Sort.Direction.DESC,"pid"));
        List<Pitch> pitches = mongoTemplate.find(query,Pitch.class);
        //List<Pitch> pitches = pitchService.getPitches();
        if (pitches == null) {
            return new ResponseEntity<>( HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return  ResponseEntity.ok(pitches);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getPitch(@PathVariable String id) throws Exception  {
        try {
            Pitch pitch = mongoTemplate.findById(id,Pitch.class);
            //Pitch pitch = pitchService.getPitch(pid);
            if (pitch == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return ResponseEntity.ok(pitch);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return new ResponseEntity<>("Something went wrong!", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @ResponseBody
    @PostMapping
    public ResponseEntity<?> addPitch(@RequestBody AddPitchRequest addPitchRequest) throws Exception {
        try {
            PitchResponse p = pitchService.addPitch(addPitchRequest);
             if(p == null){
                 return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
             }
             return new ResponseEntity(p,HttpStatus.OK);
       }

        catch(Exception e) {
            logger.error(e.getMessage());
            return new ResponseEntity<>(e,HttpStatus.BAD_REQUEST);
       }
    }
    @PostMapping(path = "/{id}/makeOffer")
    public ResponseEntity<?> addoffer(@PathVariable String id,@RequestBody AddOfferRequest addOfferRequest) throws Exception {
        try {
            if(mongoTemplate.findById(id,Pitch.class) == null){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            PitchResponse p = pitchService.addOffer(id,addOfferRequest);
            if(p == null){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity(p, HttpStatus.OK);
        } catch (Exception e) {
             logger.error(e.getMessage());
            return new ResponseEntity<>("Internal server error!", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}