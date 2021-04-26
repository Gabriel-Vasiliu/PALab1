package movie;

public class Main {
    public static void main(String[] args) {
        SingletonEMF singletonEMF = SingletonEMF.create();
        RepositoryMovie repositoryMovie = new RepositoryMovie();
        EntityMovie entityMovie = new EntityMovie();
        entityMovie.setId(5);
        entityMovie.setTitle("Mr. Bean's Holiday");
        entityMovie.setReleaseDate("27-04-2007");
        entityMovie.setDuration(1.3);
        entityMovie.setScore(6.4);
        //repositoryMovie.create(entityMovie, singletonEMF);
        //repositoryMovie.findById(1, singletonEMF);
        //repositoryMovie.findByName("Titanic", singletonEMF);
    }
}
