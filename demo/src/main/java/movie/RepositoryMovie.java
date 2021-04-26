package movie;

import javax.persistence.EntityManager;

public class RepositoryMovie extends AbstractRepository<EntityMovie>{

    public RepositoryMovie(){
        super(EntityMovie.class);
    }
   /* public void create(EntityMovie entityMovie, SingletonEMF singletonEMF){
        EntityManager entityManager = singletonEMF.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(entityMovie);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
    public void findById(int id, SingletonEMF singletonEMF){
        EntityManager entityManager = singletonEMF.getEntityManager();
        EntityMovie entityMovie = entityManager.find(EntityMovie.class, id);
        entityManager.detach(entityMovie);
        System.out.println(entityMovie.toString());
        entityManager.close();
    }*/
    public void findByName(String name, SingletonEMF singletonEMF){
        EntityManager entityManager = singletonEMF.getEntityManager();
        entityManager.getTransaction().begin();
        EntityMovie entityMovie = (EntityMovie) entityManager.createNamedQuery("EntityMovie.findByName").
                setParameter("title", name).getSingleResult();
        System.out.println(entityMovie.toString());
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
