package app;

import javax.swing.JFrame;

public class App {
    public static void main(String[] args) {
        Window pantalla = new Window();
        pantalla.setVisible(true);
        pantalla.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
