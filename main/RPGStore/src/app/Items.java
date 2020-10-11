/*package com.gamboa;

import java.io.IOException;

public class Items {

    //Attributes
    String name;
    int id;
    int[] stats; //5 Stats: Health, Armor, Speed/Agility, Damage, Magic/Experience.
    int sellP, buyP, amount;
    Boolean consumable; //If it is, it disappears after use. //funcion afecta el inventario jugador (desaparece y deja stats)

    public Items(int id, String name, int[] stats, boolean consumable){
        this.id = id;
        this.name = name;
        this.stats = stats;
        this.consumable = consumable;
        this.buyP = 200*stats[0] + 350*stats[1] + 150*stats[2] + 300*stats[3] + 500*stats[4];
        this.sellP = (int) (buyP*0.7);
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

    //Identify and buy by using the id.

    public Items[] initializeItems() throws IOException {
        API api = new API();
        int[] ids = api.idArray();

        String[] name = {"Cabbage","Roasted Chicken","Sweet Roll","Potion of Healing","Daedric Helmet",
                "Daedric Armor","Skaal Boots","Nightingale Gloves","Speed Potion","Hermes Boots",
                "Agility Elixir", "Potion of Swiftness", "Iron Dagger","Nordic War Axe","Daedric Sword","Long Bow",
                "Potion of Ultimate Magicka","Diary of a Deadman","Potion of Resist Magic","Wand of a Pillager"};

        //statsPersonaje = {0,0,0,0,0} //statsPreview funcion que agarra las del personaje
        int[][] stats = {{1,0,0,0,0},{2,0,0,0,0},{2,0,0,0,0},{4,0,0,0,0},{0,2,0,0,0},{0,4,0,0,0},{0,2,1,0,0},{0,1,0,0,0},
                {0,0,2,0,0},{0,1,4,0,0},{0,0,3,0,0},{0,0,4,0,0},{0,0,1,1,0},{0,0,0,3,0},{0,0,1,4,0},{0,0,1,2,0},
                {0,0,0,1,3},{0,0,0,0,4},{0,1,0,0,1},{0,0,0,3,3}};

        boolean[] cons = new boolean[20];
        for (int i = 0; i < 20; i++)
            cons[i] = i < 4 || i == 8 || (i > 9 && i < 12) || i == 16 || i == 18;

        Items[] itemsList = new Items[20];
        for (int i = 0; i < 20; i++) {
            itemsList[i] = new Items(ids[i], name[i], stats[i], cons[i]);
            //itemsList[i].Attributes(); //If want to test, transform this into main.
        }
        return itemsList;
    }
}


    /*[Health:200, Armor:350, Speed:150, Damage:300, Experience:500] Cost depending on stats

    //Health
    200003482, Cabbage, {1,0,0,0,0}, C
    200001648, Roasted Chicken, {2,0,0,0,0}, C
    100003141, Sweet Roll, {2,0,0,0,0}, C
    200000783, Potion of Healing, {4,0,0,0,0}, C
    //Armor
    200000775, Daedric Helmet, {0,2,0,0,0}, NC
    200118010, Daedric Armor, {0,4,0,0,0}, NC
    200215341, Skaal Boots, {0,2,1,0,0}, NC
    200000785, Nightingale Gloves, {0,1,0,0,0}, NC
    //Speed
    200001092, Speed Potion, {0,0,2,0,0}, C
    200215336, Hermes Boots, {0,1,4,0,0}, NC
    200000782, Agility Elixir, {0,0,3,0,0}, C
    205871601, Potion of Swiftness, {0,0,4,0,0}, C
    //Damage
    205874801, Iron Dagger, {0,0,1,1,0}, NC
    205876401, Nordic War Axe, {0,0,0,3,0}, NC
    205895301, Daedric Sword, {0,0,1,4,0}, NC
    205900902, Long Bow, {0,0,1,2,0}, NC
    //Experience
    205927403, Potion of Ultimate Magicka, {0,0,0,1,3}, C
    100003084, Diary of a Deadman, {0,0,0,0,4}, NC
    200000707, Potion of Resist Magic, {0,1,0,0,1}, C
    200000662, Wand of a Pillager, {0,0,0,3,3}, NC
     */