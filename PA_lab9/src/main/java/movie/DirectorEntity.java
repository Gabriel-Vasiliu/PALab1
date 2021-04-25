package movie;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "directors", schema = "demo")
public class DirectorEntity {
    private int id;
    private String name;
    private int age;
    private int nrMovies;

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
    @Column(name = "age")
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Basic
    @Column(name = "nr_movies")
    public int getNrMovies() {
        return nrMovies;
    }

    public void setNrMovies(int nrMovies) {
        this.nrMovies = nrMovies;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DirectorEntity that = (DirectorEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(age, that.age) && Objects.equals(nrMovies, that.nrMovies);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, nrMovies);
    }
}
