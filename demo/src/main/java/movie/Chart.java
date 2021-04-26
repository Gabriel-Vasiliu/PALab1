package movie;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

public class Chart {
   // private ArrayList<EntityMovie> movieList = new ArrayList<>();
    private int id;
    private String name;
    private String creationDate;

    public Chart(int id, SingletonEMF singletonEMF){
        this.id = id;
        EntityManager entityManager = singletonEMF.getEntityManager();
        EntityChart entityChart = entityManager.find(EntityChart.class, id);
        entityManager.detach(entityChart);
        this.name = entityChart.getName();
        this.creationDate = entityChart.getCreationDate();

        List<?> movieList = entityManager.createQuery("SELECT m FROM " +
                "EntityMovie m, EntityAssociationChart a WHERE a.movieId= m.id AND a.chartId= ?1 " +
                "ORDER BY m.score DESC").setParameter(1, this.id).getResultList();
        System.out.println(this.name);
        for (Object movieL : movieList) {
            System.out.println(movieL.toString());
        }
        entityManager.close();
    }

    @Override
    public String toString(){
        return id + " " + name + " " + creationDate;
    }
}
