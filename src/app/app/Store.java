package app;


import java.io.IOException;

public class Store {
    //Attributes
    public final int[] inventario = new int[20];         // inventario de la tienda
    private final Items[] items = Items.initializeItems();

    //Constructor
    public Store() throws IOException {
        initializeStore ();
    }

    //Methods
    public void buyItem(Player jugador, int index){
        jugador.money -= items[index].buyP;
        jugador.inventory[index] = inventario[index];
        inventario[index] = 0;
    }    
    public void sellItem(Player jugador, int index){
        jugador.money += items[index].sellP;
        inventario[index] = jugador.inventory[index];
        jugador.inventory[index] = 0;
    }
    public void initializeStore(){
        for (int i = 0; i < 20; i++){
            inventario[i] = items[i].id;
        }
    }
}
