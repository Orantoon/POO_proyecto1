package app;


public class Items {

    //Attributes
    String name;
    int id;
    int[] stats; //5 Stats: Health, Armor, Speed/Agility, Damage, Magic/Experience.
    int sellP, buyP, amount;
    boolean consumable, inUse; //If true, it disappears after use. //funcion afecta el inventario jugador (desaparece y deja stats)

    public Items(int id, String name, int[] stats, boolean consumable){
        this.id = id;
        this.name = name;
        this.stats = stats;
        this.consumable = consumable;
        this.buyP = 200*stats[0] + 350*stats[1] + 150*stats[2] + 300*stats[3] + 500*stats[4];
        this.sellP = (int) (buyP*0.7);
        this.inUse = false;
        if (consumable)
            amount = 2;
        else
            amount = 1;
    }

    public void Attributes(){
        System.out.println("ID: "+id);
        System.out.println("Name: "+name);
        System.out.println("Stats: "+stats[0]+", "+stats[1]+", "+stats[2]+", "+stats[3]+", "+stats[4]);
        System.out.println("Buy Price: "+buyP+", Sell Price: "+ sellP);
        System.out.println("Amount: "+amount);
        System.out.println("Consumable? "+consumable+"\n");
    }
}

    /*[Health:200, Armor:350, Speed:150, Damage:300, Experience:500] Cost depending on stats*/