package com.example.demo.relationship;

import com.example.demo.SingletonEMF;
import com.example.demo.person.Person;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
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
    public String cre(@PathVariable int id){
        EntityManager entityManager = singletonEMF.getEntityManager();
        entityManager.getTransaction().begin();
        Person person = entityManager.find(Person.class, id);
        entityManager.getTransaction().commit();
        return person.allFriends();
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
