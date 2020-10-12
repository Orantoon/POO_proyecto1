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

    //Methods
    public void initializePlayer() {
        name = "Diego";
        money = 2500;
        
        for (int i = 0; i < 5; i++){
            stats[i] = 20;
        }
        for (int i = 0; i < 28; i++){
            inventory[i] = 0;
        }
    } 
}
