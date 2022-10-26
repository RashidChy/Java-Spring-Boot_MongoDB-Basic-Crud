package com.example.demo.controller;

import com.example.demo.model.Tution;
import com.example.demo.repository.TutionRepository;
import com.example.demo.service.TutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tution")

public class TutionController {

    @Autowired
    private TutionService service;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Tution createTution(@RequestBody Tution tution){
        return service.addTution(tution);
    }

    @GetMapping
    public List<Tution> getTutions() {
        return service.findAllTutions();
    }

    @GetMapping("/{tutionId}")
    public Tution getTution(@PathVariable String tutionId){
        return service.getTutionByTutionId(tutionId);
    }

    @DeleteMapping("/delete/{tutionId}")
    public String deleteTution(@PathVariable String tutionId){
        return service.deleteTution(tutionId);
    }

    @DeleteMapping("/deletePermanently/{tutionId}")
    public String deleteTutionParmanently(@PathVariable String tutionId){
        return service.wipeOutData(tutionId);
    }

}
