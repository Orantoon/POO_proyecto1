package app;


public class Store {
    //Atributes
    private Player jugador;
    private int [] items;
    private int price;
    private int stats1;

    //Constructor
    public Store (){
        intializeStore ();
    }

    //Methods
    public void buyItem(){
        jugador.money -= price;
        jugador.inventory[0] = items[0];
        jugador.stats[0] += stats1;
        items[0] = 0;
    }    
    public void sellItem(){
        jugador.money += price;
        items[0] = jugador.inventory[0];
        jugador.stats[0] -= stats1;
        jugador.inventory[0] = 0;
    }
    public void intializeStore(){
        price = 1000;
        int[] items = new int[20];
        items[0] = 2020030303;
        items[1] = 2020038304;
        stats1 = 3;
    }
}
