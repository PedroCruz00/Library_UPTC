package presenter;

import view.Dashboard;

public class Presenter {

    Dashboard dashboard;

    public Presenter() {
        dashboard = new Dashboard();
    }

    public static void main(String[] args) {
        try {
            javax.swing.UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }
        new Presenter();

    }
}