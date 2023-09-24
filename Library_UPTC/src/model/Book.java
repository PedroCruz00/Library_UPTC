package model;

public class Book {
    private String codeISBN;
    private String title;
    private int volume;
    private String editorial;
    private LocationBook locationBook;
    private Autor infoAutor;

    public Book(String codeISBN, String title, int volume, String editorial, LocationBook locationBook, Autor infoAutor) {
        this.codeISBN = codeISBN;
        this.title = title;
        this.volume = volume;
        this.editorial = editorial;
        this.locationBook = locationBook;
        this.infoAutor = infoAutor;
    }

    public String getCodeISBN() {
        return codeISBN;
    }

    public String getTitle() {
        return title;
    }

    public int getVolume() {
        return volume;
    }

    public String getEditorial() {
        return editorial;
    }

    public LocationBook getLocationBook() {
        return locationBook;
    }

    public Autor getInfoAutor() {
        return infoAutor;
    }
}