package movie;

import javax.persistence.EntityManager;

public abstract class AbstractRepository<T> {
    protected Class<T> tClass;

    protected AbstractRepository(Class<T> tClass){
        this.tClass = tClass;
    }

    public void create(T entity, SingletonEMF singletonEMF){
        EntityManager entityManager = singletonEMF.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
    public void findById(int id, SingletonEMF singletonEMF){
        EntityManager entityManager = singletonEMF.getEntityManager();
        T entity = entityManager.find(tClass, id);
        entityManager.detach(entity);
        System.out.println(entity.toString());
        entityManager.close();
    }
    public abstract void findByName(String name, SingletonEMF singletonEMF);
}
