package app;


import java.io.IOException;

public class Store {
    //Attributes
    public int[] inventario = new int[20];         // inventario de la tienda
    private final Items[] items = initializeItems();

    //Constructor
    public Store() throws IOException {
        initializeStore ();
    }

    //Methods
    public void buyItem(Player jugador, int index){
        if (idConv(inventario[index]).amount > 0){
            if (jugador.money >= items[index].buyP){
                jugador.money -= items[index].buyP;
                for (int i = 0; i < 20; i++){
                    if (jugador.inventory[i] == 0){
                        jugador.inventory[i] = inventario[index];
                        idConv(inventario[index]).amount -= 1;
                        return;
                    }
                }
            }
        }
    }

    public void sellItem(Player jugador, int index){
        for (int i = 0; i < 20; i++){
            if (jugador.inventory[i] == inventario[index]){    // Vende el primer item de tal tipo que encuentre
                jugador.money += items[index].sellP;
                idConv(inventario[index]).amount += 1;
                jugador.inventory[i] = 0;
                return;
            }
        }
    }
    public void initializeStore(){
        for (int i = 0; i < 20; i++){
            inventario[i] = items[i].id;
        }
    }

    // Uso de id para encontrar informacion
    public Items idConv(int id) {
        for (int i = 0; i < 20; i++){
            if (items[i].id == id)
                return items[i];
        }
        return null;
    }

    public int indexID(int id){
        for (int i = 0; i < 20; i++) {
            if (id == inventario[i]){
                return i;
            }
        } return -1;
    }

    public boolean isRep(int id){
        boolean flag = false;
        for (int i = 0; i < 20; i++){
            if (id == inventario[i]){
                if (flag)
                    return true;
                else
                    flag = true;
            }
        }
        return false;
    }

    public static Items[] initializeItems() throws IOException {
        //API api = new API();
        //int[] ids = api.idArray();
        int[] ids = {200003482,200001648,100003141,200000783,
                200000775,200118010,200215341,200000785,
                200001092,200215336,200000782,205871601,
                205874801,205876401,205895301,205900902,
                205927403,100003084,200000707,200000662};

        String[] name = {"Antibody","Healing Potion","Cheese","Medkit",
                "Shield","Heavy Boots","Gun Helmet","Thorn Armor",
                "Bomb","Huntsman", "Glacier", "Laser Rifle",
                "Hermes Boots","Jetpack","Speed Vial","Ruby Bracelet",
                "Rolling Eye","Demon Head","Ring of Fire","One Direction"};

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
