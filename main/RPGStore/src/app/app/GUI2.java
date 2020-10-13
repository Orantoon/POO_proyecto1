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

    private final Player player = new Player();
    private final Store store = new Store();

    //Frame and Panels
    private final JFrame frame = new JFrame();
    private final JPanel panel = new JPanel();
    private final JPanel text = new JPanel();
    private final JPanel rightPanel = new JPanel();
    private final JPanel inventoryP = new JPanel();
    private final JPanel buttons = new JPanel();

    //Arrays of Labels used for loading various images
    private final JLabel[] images = new JLabel[20];
    private final JLabel[] imagesInv = new JLabel[20];
    private final JLabel[] imagesRep = new JLabel[5];

    //Images needed once or twice
    private final JLabel bg = new JLabel(new ImageIcon("main\\RPGStore\\Images\\Background.png"));
    private final ImageIcon yes = new ImageIcon("main\\RPGStore\\Images\\yes.png");
    private final ImageIcon no = new ImageIcon("main\\RPGStore\\Images\\no.png");

    //Labels used for the text panel (Info of Item)
    private final JLabel money = new JLabel(Integer.toString(player.money));
    private final JLabel name = new JLabel("Name: ");
    private final JLabel stats = new JLabel("Stats: ");
    private final JLabel buyP = new JLabel("Buy Price: ");
    private final JLabel sellP = new JLabel("Sell Price: ");
    private final JLabel amount = new JLabel("Amount: ");
    private final JLabel[] textL = {name,stats,buyP,sellP,amount};

    //Labels used for the Stats of the Player and preview of them
    private final JLabel[] seeStats = new JLabel[5];
    private final JLabel[] previewS = new JLabel[5];

    //Used to identify current item
    private int selectedInd,lastR,lastC;

    //Font
    private final Font font = Font.createFont(Font.TRUETYPE_FONT, new File("main\\RPGStore\\Font\\pixelmix.ttf"));


    //Constructor
    public GUI2() throws IOException, FontFormatException {
        //Basic Stuff
        int Width=1100, Height=700;

        frame.setTitle("RPG Store");
        frame.setSize(Width,Height);
        frame.setLocationRelativeTo(null);
        frame.setResizable (false);
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

        initializePanels();

        //Starting Screen
        moneyUpdate();
        setSeeStats();
        frame.add(bg);
        loadImagesText();

        //Activates if the mouse is clicked
        frame.addMouseListener(mouse);

        frame.setVisible(true);
    }


    private void initializePanels(){
        panel.setBounds(80,60,121,164);
        panel.setLayout(null); //So I can set my own layout

        text.setBounds(70,243,150,350);
        text.setLayout(null);
        text.setBackground(new Color(0.0f, 0.0f, 0.0f, 0.0f)); //Transparent

        rightPanel.setBounds(346,20,720,160);
        rightPanel.setLayout(null);
        rightPanel.setBackground(new Color(0.0f, 0.0f, 0.0f, 0.0f)); //Transparent

        inventoryP.setBounds(810,190,255,445);
        inventoryP.setLayout(null);
        inventoryP.setBackground(new Color(0.0f, 0.0f, 0.0f, 0.0f)); //Transparent

        buttons.setBounds(42,450,200,220);
        buttons.setLayout(null);
        buttons.setBackground(new Color(0.0f, 0.0f, 0.0f, 0.0f)); //Transparent
    }


    //Loads the images into their array labels and configures the text labels
    private void loadImagesText(){
        for (int i = 0; i < 20; i++){
            images[i] = new JLabel(new ImageIcon("main\\RPGStore\\Images\\View Items\\"+(i/4)+(i%4)+".png"));
            imagesInv[i] = new JLabel(new ImageIcon("main\\RPGStore\\Images\\Inventory\\"+(i/4)+(i%4)+".png"));

            if (i<5){
                textL[i].setFont(font.deriveFont(14f));
                textL[i].setForeground(Color.WHITE);
                textL[i].setBounds(0,30*i,150,20);
                imagesRep[i] = new JLabel(new ImageIcon("main\\RPGStore\\Images\\Inventory\\0"+(i%4)+".png"));

                if (i == 4){
                    imagesRep[i] = new JLabel(new ImageIcon("main\\RPGStore\\Images\\Inventory\\32.png"));
                }
            }
        }
    }


    private void moneyUpdate(){
        money.setText(Integer.toString(player.money));
        money.setFont(font.deriveFont(14f));
        money.setForeground(Color.WHITE);
        money.setBounds(0,0,70,20);
        rightPanel.add(money);
        frame.add(rightPanel);
    }


    private void setSeeStats(){ //Current Stats of the player
        String[] names = {"Health","Armor","Speed","Damage","Magic"};

        for (int i = 0; i < 5; i++){
            seeStats[i] = new JLabel();
            seeStats[i].setFont(font.deriveFont(18f));
            seeStats[i].setForeground(Color.WHITE);
            seeStats[i].setBounds(490,5+30*i,350,20);
            seeStats[i].setText(names[i]+": "+player.stats[i]+"/20");
            rightPanel.add(seeStats[i]);
        }
        frame.add(rightPanel);
    }


    private void setPreviewS(Items item){ //Preview of stats of an item if bought
        for (int i = 0; i < 5; i++){
            previewS[i] = new JLabel();
            previewS[i].setFont(font.deriveFont(18f));
            previewS[i].setForeground(Color.ORANGE);
            previewS[i].setBounds(670,5+30*i,350,20);
            if (item.stats[i] != 0)
                previewS[i].setText("+"+item.stats[i]);
            rightPanel.add(previewS[i]);
        } frame.add(rightPanel);
    }


    private void BuySellButtons(){
        //Text
        JLabel buy = new JLabel("Buy?");
        JLabel sell = new JLabel("Sell? ");

        buy.setFont(font.deriveFont(14f));
        sell.setFont(font.deriveFont(14f));
        buy.setForeground(Color.WHITE);
        sell.setForeground(Color.WHITE);

        buy.setBounds(0,30*6,150,20);
        sell.setBounds(0,30*9,150,20);

        text.add(buy);
        text.add(sell);

        //Buttons
        JButton yes1 = new JButton(yes);
        JButton no1 = new JButton(no);
        JButton yes2 = new JButton(yes);
        JButton no2 = new JButton(no);


        JButton[] botones = {yes1,no1,yes2,no2};
        for (int i = 0; i < 4; i++){
            int x, y;

            x = 97;
            if (i%2==0)
                x = 0;

            y = 90;
            if (i < 2){
                y = 0;
            }
            botones[i].setBounds(x,y,97,53);
            buttons.add(botones[i]);
        }

        //Action
        yes1.addActionListener(BUY);
        yes2.addActionListener(SELL);

        frame.add(buttons);
    }

    private void ELetter(JLabel[] E, int i, int r, int c){ //E for Equipped
        E[i] = new JLabel();
        E[i].setText("E");
        E[i].setFont(font.deriveFont(14f));
        E[i].setForeground(Color.WHITE);
        E[i].setBounds(45+64*c,40+64*r,12,25);
        inventoryP.add(E[i]);
    }


    private void setInvImages(){ //Images of the Inventory

        JLabel[] E = new JLabel[25];

        int r, c,ind;
        boolean first = true;

        for (int i = 0; i < 25; i++){

            int id = player.inventory[i];
            if (id != 0){
                r= i/4;
                c= i%4;
                ind = store.indexID(id);

                JLabel itemInv;

                if (player.isRep(id)){
                    if (first){
                        itemInv = imagesInv[ind];
                        first = false;
                    } else {
                        if (ind > 4)
                            ind = 4;

                        itemInv = imagesRep[ind];
                        first = true;
                    }

                } else {
                    itemInv = imagesInv[ind];
                }

                itemInv.setBounds(64*c,5+64*r,64,64);
                itemInv.setHorizontalAlignment(itemInv.CENTER);
                itemInv.setVerticalAlignment(itemInv.CENTER);

                if (store.idConv(id).inUse)
                    ELetter(E,i,r,c);

                inventoryP.add(itemInv);
            }
        }
    }



    MouseListener mouse = new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {
            double x,y;
            x = e.getX();
            y = e.getY();
            int r=-1, c=-1;

            //System.out.println("x = " + x + ", y = " + y);

            //Click on Items in the Middle
            if ((x > 329 && x < 777) && (y > 264 && y < 651)){
                x -= 329;
                y -= 264;
                if ((x/128)%1<=0.5)
                    c = (int) x/128;
                if ((y/86)%1<=0.5)
                    r = (int) y/86;

                if (r!=-1 && c!= -1){
                    changePanel(r,c);
                    lastR = r;
                    lastC = c;
                    selectedInd = 4*r+c;
                }
            }

            //Click on Inventory
            if ((x > 820 && x < 1075) && (y > 225 && y < 670)){
                x -= 820;
                y -= 225;

                c = (int) x/65;
                r = (int) y/65;
                //System.out.println(r+" "+c);
                int indexInv = 4*r + c;

                if (player.inventory[indexInv] != 0)
                    player.consumeUse(store,indexInv);
                changePanel(lastR,lastC);
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
            store.buyItem(player,selectedInd);
            changePanel(lastR,lastC);
        }
    };

    ActionListener SELL = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            store.sellItem(player,selectedInd);
            changePanel(lastR,lastC);
        }
    };


    private void changePanel(int r, int c){
        //Removes everything to update
        frame.getContentPane().removeAll();
        panel.removeAll();
        text.removeAll();
        rightPanel.removeAll();
        inventoryP.removeAll();

        //Image used on the Left Panel
        JLabel v = images[4*r+c];

        v.setBounds(0,0,121,164);
        panel.add(v);

        //Items item = store.inventario[4*r+c];
        Items item = store.idConv(store.inventario[4*r+c]);

        //Info of the Item
        name.setText(item.name);
        name.setHorizontalAlignment(name.CENTER);
        stats.setText("Stats: "+item.stats[0]+"/"+item.stats[1]+"/"+item.stats[2]+"/"+item.stats[3]+"/"+item.stats[4]);
        buyP.setText("Buy Price: " + item.buyP);
        sellP.setText("Sell Price: "+item.sellP);
        amount.setText("Amount: "+item.amount);

        text.add(name);
        text.add(stats);
        text.add(buyP);
        text.add(sellP);
        text.add(amount);

        //Update Every Panel
        BuySellButtons();
        setSeeStats();
        setPreviewS(item);
        moneyUpdate();
        setInvImages();

        frame.add(text);
        frame.add(panel);
        frame.add(inventoryP);
        frame.add(bg);

        frame.revalidate();
        frame.repaint();
    }

    public static void main(String[] args) throws IOException, FontFormatException {
        new GUI2();
    }
}
