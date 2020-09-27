package app;

public class Player {
    //Atributes
    private String name;
    private int money;
    private int[] stats;
    private int[] inventory;

    //Constructor
    public Player(){
        name = "Diego";
        money = 2500;
        for (int i = 0; i <= 5; i++){
            stats[i] = 20;
        }
    }

    //Methods
    public String printName(){
        System.out.println(name);
        return name;
    }    
}
