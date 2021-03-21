package media;

public class Main {
    public static void main(String[] args) {
        Catalog catalog = new Catalog();
        Movie movie = new Movie("Titanic", "C:\\Users\\Gabi\\Desktop\\item\\movie.mp4");
        try {
            movie.setYear(1997);
        } catch (Exception e1) {
            System.out.println("Exception occurred:" + e1);
        }
        try {
            movie.setRating(9.8);
        } catch (Exception e2) {
            System.out.println("Exception occurred:" + e2);
        }
        Book book = new Book("Povesti", "C:\\Users\\Gabi\\Desktop\\item\\book.pdf");
        try {
            book.setYear(2020);
        } catch (Exception e1) {
            System.out.println("Exception occurred:" + e1);
        }
        book.setAuthor("Ion Creanga");
        catalog.add(movie);
        catalog.add(book);
        catalog.list();
        catalog.play(1);
        catalog.save();
        catalog.load();
        System.out.println();
        catalog.list();
    }
}
