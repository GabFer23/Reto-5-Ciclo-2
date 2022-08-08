package app;

import view.InformesView;

public class App {
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            new InformesView().setVisible(true);
        });
    }
}
