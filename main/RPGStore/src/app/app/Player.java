package app;


public class Player {
    //Attributes
    private String name;
    public int money;
    public int[] stats = new int[5];    // Importante para inicializar arreglos
    public Items[] inventory = new Items[20];

    //Constructor
    public Player(){
        initializePlayer();
    }

    public void useItem(int index){
        if (inventory[index].inUse){
            for (int i = 0; i < 5; i++)
                stats[i] += inventory[index].stats[i];
            if (inventory[index].consumable)    // Si es consumible desaparece
                inventory[index] = null;
        }
        else {
            for (int i = 0; i < 5; i++)
                stats[i] -= inventory[index].stats[i];
        }
    }

    //Methods
    public void initializePlayer() {
        name = "Diego";
        money = 2500;

        for (int i = 0; i < 5; i++){
            stats[i] = 1;
        }
        for (int i = 0; i < 20; i++){
            inventory[i] = null;
        }
    }
}
