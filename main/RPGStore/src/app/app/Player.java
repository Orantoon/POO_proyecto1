package app;


public class Player {
    //Attributes
    public int money;
    public int[] stats = new int[5];    // Importante para inicializar arreglos
    public int[] inventory = new int[28];

    //Constructor
    public Player(){
        initializePlayer();
    }

    public void consumeUse(Store store, int index){
        Items item = store.idConv(inventory[index]);
        if (item.consumable){
            inventory[index] = 0;   //Disappears if consumable
            for (int i = 0; i < 5; i++){
                stats[i] += item.stats[i];
            }
        } else {
            for (int i = 0; i < 5; i++){
                if (item.inUse)
                    stats[i] -= item.stats[i];
                else
                    stats[i] += item.stats[i];
            } item.inUse = !item.inUse; //Equipped and unequipped
        }
    }

    public boolean isRep(int id) {
        boolean flag = false;
        for (int i = 0; i < 25; i++) {
            if (id == inventory[i]) {
                if (flag)
                    return true;
                else
                    flag = true;
            }
        }
        return false;
    }


    //Methods
    public void initializePlayer() {
        money = 5500; //55000 to buy all

        for (int i = 0; i < 5; i++){
            stats[i] = 1;
        }
        for (int i = 0; i < 28; i++){
            inventory[i] = 0;
        }
    }
}
