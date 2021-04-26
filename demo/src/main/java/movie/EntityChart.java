package movie;

import javax.persistence.*;

@Entity
@Table(name = "charts", schema = "demo")
public class EntityChart {
    private int id;
    private String name;
    private String creationDate;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "creation_date")
    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }
    @Override
    public String toString(){
        return id + " " + name + " " + creationDate;
    }
}
