package app;

public class Player {
    //Atributes
    private String name;
    //private int money;
    private int[] stats;
    private int[] inventory;

    //Constructor
    public Player(){
        name = "Diego";
        //money = 2500;
        for (int i = 0; i <= 5; i++){
            stats[i] = 20;
        }
    }

    //Methods
    public void printName(){
        System.out.println(name);
    }

    public void printInv(){
        for (int i = 0; i < inventory.length; i++){
            System.out.println(inventory[i]);
        }
    }

    public void printStats(){
        for (int i = 0; i <=5; i++){
            System.out.println(stats[i]);
        }
    }


}
