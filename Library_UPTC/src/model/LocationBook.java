package model;

public class LocationBook {
    private Campus campus;
    private SubCampus subCampus;

    public LocationBook(Campus campus, SubCampus subCampus) {
        this.campus = campus;
        this.subCampus = subCampus;
    }

    public Campus getCampus() {
        return campus;
    }

    public SubCampus getSubCampus() {
        return subCampus;
    }
}