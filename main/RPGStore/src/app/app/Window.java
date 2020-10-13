package app;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;
//import java.awt.event.*;

public class Window extends JFrame {
    
    public JPanel panel;
    private static final long serialVersionUID = 1L;
    private final int Width=1400, Height=789;

    public Window() {
        setTitle ("RPG Store");    // Titulo
        setSize (Width, Height);    // Tamano
        setLocationRelativeTo (null);   // Posicion Inicial (Centro)
        setResizable (false);   // Editar Tamano (false)
        setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);     // Cerrar y parar programa
        
        // Fondo de JPanel base
        setLayout (new BorderLayout());
        final JLabel background = new JLabel (new ImageIcon("C:\\Users\\david\\Desktop\\Tareas David\\TEC\\Semestre 2\\Programacion Orientada a Objetos\\Proyectos\\Proyecto 1\\Background.jpg"));
        add (background);

        // Paneles y demas
        components ();
    }

    private void components(){
        createPanel();
        createButton();
    }
    private void createPanel(){
        panel = new JPanel();
        panel.setLayout(null);
        this.getContentPane().add (panel);
    }
    private void createButton(){
        JButton botonItem1 = new JButton();
        botonItem1.setBounds(10, 640, 100, 100);
        panel.add(botonItem1);
    }
}
