package com.example.demo.repository;

import com.example.demo.entity.Persons;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

@org.springframework.stereotype.Repository
public class Repository {
    @PersistenceContext
    private EntityManager entityManager;

    private static final String query = "\"SELECT Person.personPrimaryKey.name from Person p where p.city_of_living = :city";

   public List<Persons> getPersonsByCity(String city) {
       return entityManager.createQuery(query).setParameter("city", city).getResultList();


    }

}
