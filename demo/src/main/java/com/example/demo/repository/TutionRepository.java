package com.example.demo.repository;

import ch.qos.logback.core.status.Status;
import com.example.demo.model.Tution;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface TutionRepository extends MongoRepository<Tution,String> {

    List<Tution> findTutionByStatus(String status);
    Optional<Tution> findTutionByTutionId(String tutionId);

    Optional<Tution> findTutionByTutionIdAndStatus(String tutionId, Status status);

}
