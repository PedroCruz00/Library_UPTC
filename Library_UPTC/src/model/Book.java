package model;

public class Book implements Comparable<Book> {
    private String codeISBN;
    private String title;
    private int volume;
    private String editorial;
    private Campus campus;
    private SubCampus subCampus;
    private Autor infoAutor;
    private int quantity;

    public Book(String codeISBN, String title, int volume, String editorial, Campus campus, SubCampus subCampus, Autor infoAutor, int quantity) {
        this.codeISBN = codeISBN;
        this.title = title;
        this.volume = volume;
        this.editorial = editorial;
        this.campus = campus;
        this.subCampus = subCampus;
        this.infoAutor = infoAutor;
        this.quantity = quantity;
    }

    public Book() {

    }

    public void setCodeISBN(String codeISBN) {
        this.codeISBN = codeISBN;
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

    public Campus getCampus() {
        return campus;
    }

    public SubCampus getSubCampus() {
        return subCampus;
    }

    public Autor getInfoAutor() {
        return infoAutor;
    }

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
}
