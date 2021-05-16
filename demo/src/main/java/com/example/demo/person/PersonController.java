package com.example.demo.person;

import com.example.demo.SingletonEMF;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {
    public SingletonEMF singletonEMF = SingletonEMF.create();
    private List<Person> personList;
    public PersonController(){
        EntityManager entityManager = singletonEMF.getEntityManager();
        personList = entityManager.createQuery("SELECT p FROM Person p").getResultList();
    }
    @GetMapping
    public List<?> getPersonList(){
        return personList;
    }
    @PostMapping
    public ResponseEntity<String> createPerson(@RequestParam String name){
        int id = personList.size() + 1;
        Person person = new Person(id, name);
        personList.add(person);
        EntityManager entityManager = singletonEMF.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(person);
        entityManager.getTransaction().commit();
        return new ResponseEntity<>("Person was introduced successfully", HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable int id, @RequestParam String name) {
        Person person = findById(id);
        if (person == null) {
            return new ResponseEntity<>("Person not found", HttpStatus.NOT_FOUND);
        }
        EntityManager entityManager = singletonEMF.getEntityManager();
        entityManager.getTransaction().begin();
        person.setName(name);
        entityManager.getTransaction().commit();
        return new ResponseEntity<>("Person updated successfully", HttpStatus.OK);
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable int id) {
        Person person = findById(id);
        if (person == null) {
            return new ResponseEntity<>("Person not found", HttpStatus.GONE);
        }
        personList.remove(person);
        EntityManager entityManager = singletonEMF.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.remove(person);
        entityManager.getTransaction().commit();
        return new ResponseEntity<>("Person removed", HttpStatus.OK);
    }

    public Person findById(int id){
        EntityManager entityManager = singletonEMF.getEntityManager();
        entityManager.getTransaction().begin();
        Person person = entityManager.find(Person.class, id);
        entityManager.getTransaction().commit();
        return person;
    }
}
