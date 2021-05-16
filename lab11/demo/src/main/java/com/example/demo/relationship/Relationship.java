package com.example.demo.relationship;

import javax.persistence.*;

@Entity
@Table(name = "relationship", schema = "demo")
public class Relationship {
    private int id;
    private int idFriend1;
    private int idFriend2;
    public Relationship(){}
    public Relationship(int id, int idFriend1, int idFriend2){
        this.id = id;
        this.idFriend1 = idFriend1;
        this.idFriend2 = idFriend2;
    }
    public Relationship(int idFriend1, int idFriend2){
        this.idFriend1 = idFriend1;
        this.idFriend2 = idFriend2;
    }

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "id_friend1")
    public int getIdFriend1() {
        return idFriend1;
    }

    public void setIdFriend1(int idFriend1) {
        this.idFriend1 = idFriend1;
    }

    @Basic
    @Column(name = "id_friend2")
    public int getIdFriend2() {
        return idFriend2;
    }

    public void setIdFriend2(int idFriend2) {
        this.idFriend2 = idFriend2;
    }

}
