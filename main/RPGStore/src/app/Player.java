package app;


public class Player {
    //Atributes
    private String name;
    public int money;
    public int[] stats = new int[5];    // Importante para inicializar arreglos
    public int[] inventory = new int[20];

    //Constructor
    public Player(){
        initializePlayer();
    }

    //Methods
    public void printName(){
        System.out.println(name);
    }
    public void printInv(){
        for (int i = 0; i < 20; i++){
            System.out.println(inventory[i]);
        }
    }
    public void printStats(){
        for (int i = 0; i < 5; i++){
            System.out.println(stats[i]);
        }
    }
    public void printMoney(){
        System.out.println(money);
    }  
    public void initializePlayer() {
        name = "Diego";
        money = 2500;
        
        for (int i = 0; i < 5; i++){
            stats[i] = 20;
        }
        for (int i = 0; i < 20; i++){
            inventory[i] = 0;
        }
    } 
}
