package app;


public class Player {
    //Attributes
    private String name;
    public int money;
    public int[] stats = new int[5];    // Importante para inicializar arreglos
    public int[] inventory = new int[28];

    //Constructor
    public Player(){
        initializePlayer();
    }

    public void useItem(Store store, int index){
        if (store.idConv(inventory[index]).inUse){
            for (int i = 0; i < 5; i++)
                stats[i] += store.idConv(inventory[index]).stats[i];
            if (store.idConv(inventory[index]).consumable)    // Si es consumible desaparece
                inventory[index] = 0;
        }
        else {
            for (int i = 0; i < 5; i++)
                stats[i] -= store.idConv(inventory[index]).stats[i];
        }
    }

    //Methods
    public void initializePlayer() {
        name = "Diego";
        money = 2500;

        for (int i = 0; i < 5; i++){
            stats[i] = 1;
        }
        for (int i = 0; i < 28; i++){
            inventory[i] = 0;
        }
    }
}
