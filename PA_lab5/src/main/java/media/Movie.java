package media;

import exception.InvalidRating;
import exception.InvalidYear;

public class Movie implements Item {
    private String name;
    private String path;
    private double rating;
    private int year;

    Movie() {
    }

    Movie(String nameMovie, String pathMovie) {
        this.name = nameMovie;
        this.path = pathMovie;
    }

    @Override
    public void setPath(String p) {
        this.path = p;
    }

    @Override
    public void setName(String n) {
        this.name = n;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getPath() {
        return path;
    }

    @Override
    public int getYear() {
        return year;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double ratingMovie) throws InvalidRating {
        if (ratingMovie <= 0) {
            throw new InvalidRating("invalid rating");
        } else {
            this.rating = ratingMovie;
        }
    }

    @Override
    public void setYear(int y) throws InvalidYear {
        if (y < 0) {
            throw new InvalidYear("Invalid year");
        } else {
            this.year = y;
        }
    }

    @Override
    public String toString() {
        return "Movie: " + name + ", " + year + ", rating: " + rating + ", path: " + path;
    }
}
