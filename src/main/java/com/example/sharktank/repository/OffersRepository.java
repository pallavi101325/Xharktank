package com.example.sharktank.repository;

import com.example.sharktank.models.Offer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OffersRepository extends MongoRepository<Offer, String> {


}
