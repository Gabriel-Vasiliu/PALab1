package com.example.demo.relationship;

import com.example.demo.SingletonEMF;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;

@RestController
@RequestMapping("/relationship")
public class RelationshipController {
    public SingletonEMF singletonEMF = SingletonEMF.create();
    public RelationshipController(){
        EntityManager entityManager = singletonEMF.getEntityManager();
    }
}
