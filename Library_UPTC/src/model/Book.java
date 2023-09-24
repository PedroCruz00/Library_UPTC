package model;

public class Book implements Comparable<Book> {
    private String codeISBN;
    private String title;
    private int volume;
    private String editorial;
    private LocationBook locationBook;
    private Autor infoAutor;
    private int quantity;

    public Book(String codeISBN, String title, int volume, String editorial, LocationBook locationBook, Autor infoAutor, int quantity) {
        this.codeISBN = codeISBN;
        this.title = title;
        this.volume = volume;
        this.editorial = editorial;
        this.locationBook = locationBook;
        this.infoAutor = infoAutor;
        this.quantity = quantity;
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

<<<<<<< HEAD
=======
    public int getQuantity() {
        return quantity;
    }

    public void reduceQuantity() {
        if (quantity > 0) {
            quantity--;
        }
    }

    @Override
    public int compareTo(Book o) {
        return this.codeISBN.compareTo(o.codeISBN);
    }
>>>>>>> model
}