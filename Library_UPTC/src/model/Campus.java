package model;

import java.util.LinkedList;

public class Campus {

    LinkedList<SubCampus> subCampuses;

    public Campus() {
        this.subCampuses = new LinkedList<>();
    }

    public LinkedList<SubCampus> getSubCampuses() {
        return subCampuses;
    }
}