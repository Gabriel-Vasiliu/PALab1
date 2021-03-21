package media;

import exception.InvalidYear;

public interface Item {
    String getName();

    void setName(String n);

    String getPath();

    void setPath(String p);

    int getYear();

    void setYear(int y) throws InvalidYear;
}
