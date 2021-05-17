package com.example.demo.relationship;

import com.example.demo.SingletonEMF;
import com.example.demo.person.Person;
import org.springframework.data.querydsl.QSort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/relationship")
public class RelationshipController {
    public SingletonEMF singletonEMF = SingletonEMF.create();
    private List<Relationship> relationshipList;
    public RelationshipController(){
        EntityManager entityManager = singletonEMF.getEntityManager();
        relationshipList = entityManager.createQuery("SELECT r FROM Relationship r").getResultList();
        entityManager.getTransaction().begin();
        for (Relationship relationship: relationshipList){
            Person person1 = entityManager.find(Person.class, relationship.getIdFriend1());
            Person person2 = entityManager.find(Person.class, relationship.getIdFriend2());
            if (person1 != null && person2 != null){
                person1.friends.add(person2);
                person2.friends.add(person1);
            }
            person1 = null;
            person2 = null;
        }
        entityManager.getTransaction().commit();
    }

    @GetMapping
    public List<?> getRelationshipList(){
        return relationshipList;
    }

    @GetMapping("/{id}")
    public String getAllFriends(@PathVariable int id){
        EntityManager entityManager = singletonEMF.getEntityManager();
        entityManager.getTransaction().begin();
        Person person = entityManager.find(Person.class, id);
        entityManager.getTransaction().commit();
        return person.allFriends();
    }
    @GetMapping("/most")
    public String getMostPopularPersons(@RequestParam int k){
        EntityManager entityManager = singletonEMF.getEntityManager();
        List<Person> persons = entityManager.createQuery("SELECT p FROM Person p").getResultList();
        if (k > persons.size()){
            return "k is too big";
        }
        if (k < 1){
            return "k is negative or zero!";
        }
        for (int i = 0; i<persons.size()-1; i++){
            for (int j = i+1; j<persons.size(); j++){
                if (persons.get(i).friends.size() < persons.get(j).friends.size()){
                    Person person = persons.get(i);
                    persons.set(i, persons.get(j));
                    persons.set(j, person);
                }
            }
        }
        String popularPersons = persons.get(0).getName()
                + ", number of friends: " + persons.get(0).friends.size();
        for (int i=1; i < k; i++){
            popularPersons = popularPersons + "\n" + persons.get(i).getName()
                    + ", number of friends: " + persons.get(i).friends.size();
        }
        return popularPersons;
    }

    @GetMapping("/least")
    public String getLeastPopularPersons(@RequestParam int k){
        EntityManager entityManager = singletonEMF.getEntityManager();
        List<Person> persons = entityManager.createQuery("SELECT p FROM Person p").getResultList();
        if (k > persons.size()){
            return "k is too big";
        }
        if (k < 1){
            return "k is negative or zero!";
        }
        for (int i = 0; i<persons.size()-1; i++){
            for (int j = i+1; j<persons.size(); j++){
                if (persons.get(i).friends.size() > persons.get(j).friends.size()){
                    Person person = persons.get(i);
                    persons.set(i, persons.get(j));
                    persons.set(j, person);
                }
            }
        }
        String popularPersons = persons.get(0).getName()
                + ", number of friends: " + persons.get(0).friends.size();
        for (int i=1; i < k; i++){
            popularPersons = popularPersons + "\n" + persons.get(i).getName()
                    + ", number of friends: " + persons.get(i).friends.size();
        }
        return popularPersons;
    }

    @PostMapping
    public ResponseEntity<String> createRelationship(@RequestParam int id1, @RequestParam int id2){
        int id = relationshipList.size() + 1;
        if (id1 == id2){
            return new ResponseEntity<>("Id1 and id2 are equal", HttpStatus.BAD_REQUEST);
        }
        if (insert(id1, id2)){
            return new ResponseEntity<>("This relationship is already inserted", HttpStatus.BAD_REQUEST);
        }
        Relationship relationship = new Relationship(id, id1, id2);
        relationshipList.add(relationship);
        EntityManager entityManager = singletonEMF.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(relationship);
        entityManager.getTransaction().commit();
        return new ResponseEntity<>("Relationship was introduced successfully", HttpStatus.CREATED);
    }
    boolean insert(int id1, int id2){
        for (Relationship relationship: relationshipList){
            if ((relationship.getIdFriend1() == id1 && relationship.getIdFriend2() == id2) ||
                    (relationship.getIdFriend1() == id2 && relationship.getIdFriend2() == id1)){
                return true;
            }
        }
        return false;
    }
}
