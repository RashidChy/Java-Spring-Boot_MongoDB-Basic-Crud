package com.example.demo.service;

import com.example.demo.model.Tution;
import com.example.demo.repository.TutionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TutionService {
@Autowired
    private TutionRepository repository;

    public Tution addTution(Tution tution) {
        tution.setTutionId(UUID.randomUUID().toString().split("-")[0]);
        tution.setStatus("V");
        return repository.save(tution);
    }

    public List<Tution> findAllTutions() {
        return  repository.findTutionByStatus("V");
    }

    public Tution getTutionByTutionId(String tutionId){
        Optional<Tution> tution =  repository.findTutionByTutionId(tutionId);
        System.out.println(tution);
        return tution.get();
    }
    public String deleteTution(String tutionId){
        try{
            Tution existingTution =   repository.findById(tutionId).get();

            existingTution.setStatus("D");
            repository.save(existingTution);

            return tutionId+" tution deleted from dashboard ";
        } catch(Exception ex) {
            throw ex;
        }

    }
    public String wipeOutData(String id){
        System.out.println(id);
        repository.deleteById(id);
        return "Data wiped out";
    }
}
