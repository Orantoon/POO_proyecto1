package app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

public class GUI2 {

    private final JFrame frame = new JFrame();
    private final JPanel panel = new JPanel();
    private final JPanel text = new JPanel();
    private final JPanel seeStats = new JPanel();
    private final JPanel buttons = new JPanel();
    private final JLabel bg = new JLabel(new ImageIcon("main\\RPGStore\\Images\\Background.png"));

    private JLabel[] images = new JLabel[20];

    private final ImageIcon yes = new ImageIcon("main\\RPGStore\\Images\\yes.png");
    private final ImageIcon no = new ImageIcon("main\\RPGStore\\Images\\no.png");

    private Player player = new Player();
    private Store store = new Store();

    private JLabel money = new JLabel(Integer.toString(player.money));
    private JLabel name = new JLabel("Name: ");
    private JLabel stats = new JLabel("Stats: ");
    private JLabel buyP = new JLabel("Buy Price: ");
    private JLabel sellP = new JLabel("Sell Price: ");
    private JLabel amount = new JLabel("Amount: ");
    private JLabel[] textL = {name,stats,buyP,sellP,amount};

    private final Font font = Font.createFont(Font.TRUETYPE_FONT, new File("main\\RPGStore\\Font\\pixelmix.ttf"));


    public GUI2() throws IOException, FontFormatException {
        //Basic Stuff
        int Width=1100, Height=700;

        frame.setTitle("RPG Store");
        frame.setSize(Width,Height);
        frame.setLocationRelativeTo(null);
        frame.setResizable (false);
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

        //Initialize Panels
        panel.setBounds(80,60,121,164);
        panel.setLayout(null);
        text.setBounds(70,243,150,350);//height 170
        text.setLayout(null);
        text.setBackground(new Color(0.0f, 0.0f, 0.0f, 0.0f)); //Transparent
        seeStats.setBounds(346,20,720,160);
        seeStats.setLayout(null);
        seeStats.setBackground(new Color(0.0f, 0.0f, 0.0f, 0.0f)); //Transparent
        buttons.setBounds(42,450,200,220);
        buttons.setLayout(null);
        buttons.setBackground(new Color(0.0f, 0.0f, 0.0f, 0.0f)); //Transparent

        moneyUpdate();
        frame.add(bg);
        loadImagesText();

        frame.addMouseListener(mouse);

        frame.setVisible(true);
    }

    private void loadImagesText(){
        for (int i = 0; i < 20; i++){
            images[i] = new JLabel(new ImageIcon("main\\RPGStore\\Images\\View Items\\"+(i/4)+(i%4)+".png"));

            if (i<5){
                textL[i].setFont(font.deriveFont(14f));
                textL[i].setForeground(Color.WHITE);
                textL[i].setBounds(0,30*i,150,20);
            }
        }
    }

    private void moneyUpdate(){
        money.setText(Integer.toString(player.money));
        money.setFont(font.deriveFont(14f));
        money.setForeground(Color.WHITE);
        money.setBounds(0,0,50,20);
        seeStats.add(money);
        frame.add(seeStats);
    }

    private void BuySellButtons(){
        //Text
        JLabel buy = new JLabel("Buy?");
        JLabel sell = new JLabel("Sell? ");//("Sell? "+amount of item in inventory+" in Inventory");

        buy.setFont(font.deriveFont(14f));
        sell.setFont(font.deriveFont(14f));
        buy.setForeground(Color.WHITE);
        sell.setForeground(Color.WHITE);

        buy.setBounds(0,30*6,150,20);
        sell.setBounds(0,30*9,150,20);

        text.add(buy);
        text.add(sell);

        JButton yes1 = new JButton(yes);
        JButton no1 = new JButton(no);
        yes1.setBounds(0,0,97,53);
        no1.setBounds(97,0,97,53);
        buttons.add(yes1);
        buttons.add(no1);

        yes1.addActionListener(BUY);

        JButton yes2 = new JButton(yes);
        JButton no2 = new JButton(no);
        yes2.setBounds(0,90,97,53);
        no2.setBounds(97,90,97,53);
        buttons.add(yes2);
        buttons.add(no2);

        yes2.addActionListener(SELL);

        frame.add(buttons);
    }

    MouseListener mouse = new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {
            double x,y;
            x = e.getX();
            y = e.getY();
            int r=-1, c=-1;

            System.out.println("x = " + x + ", y = " + y);

            if ((x > 329 && x < 777) && (y > 264 && y < 651)){
                x -= 329;
                y -= 264;
                if ((x/128)%1<=0.5)
                    c = (int) x/128;
                if ((y/86)%1<=0.5)
                    r = (int) y/86;

                if (r!=-1 && c!= -1){
                    changePanel(r,c); //System.out.println(r+""+c);
                }
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {}

        @Override
        public void mouseReleased(MouseEvent e) {}

        @Override
        public void mouseEntered(MouseEvent e) {}

        @Override
        public void mouseExited(MouseEvent e) {}
    };


    ActionListener BUY = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("BUY!");
        }
    };

    ActionListener SELL = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("SELL!");
        }
    };


    private void changePanel(int r, int c){
        frame.getContentPane().removeAll();
        panel.removeAll();
        text.removeAll();

        JLabel v = images[r * 4 + c];

        v.setBounds(0,0,121,164);
        panel.add(v);

        //Labels of text
        //name.setText(itemList[r*4+c][indexName]);

        name.setHorizontalAlignment(name.CENTER);
        text.add(name);
        text.add(stats);
        text.add(buyP);
        text.add(sellP);
        text.add(amount);

        BuySellButtons();
        moneyUpdate();

        frame.add(text);
        frame.add(panel);
        frame.add(bg);

        frame.revalidate();
        frame.repaint();
    }

    public static void main(String[] args) throws IOException, FontFormatException {
        new GUI2();
    }
}
