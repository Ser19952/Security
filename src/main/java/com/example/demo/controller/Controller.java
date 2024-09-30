package com.example.demo.controller;

import com.example.demo.entity.Persons;
import com.example.demo.repository.Repository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
public class Controller {

    @Autowired
    private final Repository repository;

    @GetMapping("/persons/by-city")
    public List<Persons> getPersonsByCity (@RequestParam (value = "city") String city) {
        return repository.getPersonsByCity(city);

    }


}
