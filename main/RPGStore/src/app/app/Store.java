package app;


import java.io.IOException;

public class Store {
    //Attributes
    public final Items[] inventario = new Items[20];         // inventario de la tienda
    private final Items[] items = initializeItems();

    //Constructor
    public Store() throws IOException {
        initializeStore ();
    }

    //Methods
    public void buyItem(Player jugador, int index){
        jugador.money -= items[index].buyP;
        jugador.inventory[index] = inventario[index];
        inventario[index] = null;
    }
    public void sellItem(Player jugador, int index){
        jugador.money += items[index].sellP;
        inventario[index] = jugador.inventory[index];
        jugador.inventory[index] = null;
    }
    public void initializeStore(){
        for (int i = 0; i < 20; i++)
            inventario[i] = items[i];
    }

    // Uso de id para transferir entre interfaz y codigo
    public int idConv(int id) {
        int index = 0;
        for (int i = 0; i < 20; i++){
            if (items[i].id == id)
                index = i;
        }
        return index;
    }

    public static Items[] initializeItems() throws IOException {
        //API api = new API();
        //int[] ids = api.idArray();
        int[] ids = {200003482,200001648,100003141,200000783,
                200000775,200118010,200215341,200000785,
                200001092,200215336,200000782,205871601,
                205874801,205876401,205895301,205900902,
                205927403,100003084,200000707,200000662};

        String[] name = {"Antibody","Potion of Health","Cheese","Medkit",
                "Shield","Heavy Boots","Gun Knight Helmet","Armor of Thorns",
                "Bomb","Huntsman", "Glacier", "Laser Rifle",
                "Hermes Boots","Jetpack","Speed Vial","Ruby Bracelet",
                "Rolling Eye","Demon Head","Ring of Fire Resistance","Sense of Direction"};

        //statsPersonaje = {0,0,0,0,0} //statsPreview funcion que agarra las del personaje
        int[][] stats = {{2,0,0,0,0},{3,0,0,0,0},{1,0,0,0,0},{3,0,0,0,0},
                {0,1,0,0,0},{0,1,1,0,0},{0,3,0,0,0},{0,4,0,0,0},
                {0,0,0,2,0},{0,0,0,4,0},{0,0,1,1,0},{0,0,1,3,0},
                {0,1,3,0,0},{0,0,4,0,0},{0,0,1,0,0},{0,0,2,0,0},
                {0,0,0,1,3},{0,0,0,0,4},{0,1,0,0,1},{0,0,0,0,2}};

        boolean[] cons = new boolean[20];
        for (int i = 0; i < 20; i++)
            cons[i] = i < 4 || i == 14;

        Items[] itemsList = new Items[20];
        for (int i = 0; i < 20; i++) {
            itemsList[i] = new Items(ids[i], name[i], stats[i], cons[i]);
            //itemsList[i].Attributes(); //If want to test, transform this into main.
        }
        return itemsList;
    }
}
