package presenter;

import view.Dashboard;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Presenter implements ActionListener {

    Dashboard dashboard;

    public Presenter() {
        dashboard = new Dashboard(this);
    }

    public static void main(String[] args) {
        try {
            javax.swing.UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }
        new Presenter();

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}