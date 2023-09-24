package model;

public class Autor {
    private String name;
    private String lastName;
    private String biography;

    public Autor(String name, String lastName, String biography) {
        this.name = name;
        this.lastName = lastName;
        this.biography = biography;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getBiography() {
        return biography;
    }
}