package com.example.sharktank.repository;

import com.example.sharktank.models.Pitch;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PitchesRepository extends MongoRepository<Pitch, String> {

    @Query(value = "SELECT f.pid, f.entrepreneur, f.pitchTitle, f.pitchIdea, f.askAmount, f.equity,f.offers FROM Pitch f")
    public List<Pitch> getAllPitches();

    @Query(value = "SELECT f.pid, f.entrepreneur, f.pitchTitle, f.pitchIdea, f.askAmount, f.equity,f.offers FROM Pitch f")
    public Optional<Pitch> findById(String pid);
    //List<Pitch> findAllOrderByiddesc();
//    @Query("{ '_id' : ?0}")
//    List<Pitch> findAllPitches(String _id, Sort sort);

    String deleteByPid(String pid);

}
