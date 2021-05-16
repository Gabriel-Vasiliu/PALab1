package com.example.demo.person;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "person", schema = "demo")
public class Person {
    private int id;
    private String name;
    private List<Person> friends = new ArrayList<>();
    public Person(){}
    public Person(int id, String name){
        this.id = id;
        this.name = name;
    }
    public Person(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person: " + id + ", " + name;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    @Basic
    @Column(name = "nume")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
