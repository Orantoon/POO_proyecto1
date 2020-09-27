package app;

import javax.swing.JFrame;

public class Window extends JFrame {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private final int Width=1600, Height=1000;
    public Window() {
        setTitle ("RPG Store");
        setSize (Width, Height);
        setLocationRelativeTo (null);
        setResizable (false);
    }
}
