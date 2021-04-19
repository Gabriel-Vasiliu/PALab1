package movie.movies;

public class Movie {
    private int id;
    private String title;
    private String releaseDate;
    private double duration;
    private double score;

    public Movie(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public int getId() {
        return id;
    }

    public double getScore() {
        return score;
    }

    public String getTitle() {
        return title;
    }

    public double getDuration() {
        return duration;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    @Override
    public String toString() {
        return "movie.movies.Movie: " + id + " " + title + " " + releaseDate + ", duration: " + duration + ", score: " + score;
    }
}
