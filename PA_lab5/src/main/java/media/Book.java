package media;

import exception.InvalidYear;

public class Book implements Item {
    private String name;
    private String path;
    private String author;
    private int year;

    Book() {
    }

    Book(String nameBook, String pathBook) {
        this.name = nameBook;
        this.path = pathBook;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String authorBook) {
        this.author = authorBook;
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
        return "Book: " + name + ", author: " + author + ", " + year + ", path: " + path;
    }
}
