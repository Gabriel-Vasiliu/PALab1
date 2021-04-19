package movie.directors;

import movie.movies.Movie;

import java.util.ArrayList;

public class Director {
    private String name;
    private int id;
    private int age;
    private int nrMovies;
    ArrayList<Movie> movieList = new ArrayList<>();
    Director(String name, int id){
        this.id = id;
        this.name = name;
    }

    public void addMovie(Movie movie){
        movieList.add(movie);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setNrMovies(int nrMovies) {
        this.nrMovies = nrMovies;
    }

    public int getNrMovies() {
        return nrMovies;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return name + " " + age + ", nr movies: " + nrMovies;
    }
}
