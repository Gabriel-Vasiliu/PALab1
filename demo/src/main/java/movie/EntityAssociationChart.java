package movie;

import javax.persistence.*;

@Entity
@Table(name = "association_charts", schema = "demo")
public class EntityAssociationChart {
    private int id;
    private int movieId;
    private int chartId;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "movie_id")
    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    @Basic
    @Column(name = "chart_id")
    public int getChartId() {
        return chartId;
    }

    public void setChartId(int chartId) {
        this.chartId = chartId;
    }

    @Override
    public String toString(){
        return id + " " + movieId + " " + chartId;
    }
}
