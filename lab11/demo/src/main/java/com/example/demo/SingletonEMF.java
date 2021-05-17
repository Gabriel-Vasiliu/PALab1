package com.example.demo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class SingletonEMF {
    private static EntityManagerFactory entityManagerFactory = null;
    private static EntityManager entityManager = null;
    private static SingletonEMF singletonEMF = null;

    private SingletonEMF(){
        entityManagerFactory = Persistence.createEntityManagerFactory("demo");
        entityManager = entityManagerFactory.createEntityManager();
    }
    public EntityManager getEntityManager() {
        if(entityManager != null)
            return entityManager;
        return null;
    }

    public static SingletonEMF create(){
        if (singletonEMF == null)
            singletonEMF = new SingletonEMF();
        return singletonEMF;
    }
}
