package main.java.spil;

public class FieldConstants {

    //Field number/ID for each field
    public static final int START_ID = 0;
    public static final int TOWER_ID = 2;
    public static final int CRATER_ID = 3;
    public static final int PALACE_GATES_ID = 4;
    public static final int COLD_DESERT_ID = 5;
    public static final int WALLED_CITY_ID = 6;
    public static final int MONASTARY_ID = 7;
    public static final int BLACK_CAVE_ID = 8;
    public static final int HUTS_IN_THE_MOUNTAIN_ID = 9;
    public static final int THE_WEREWALL_ID = 10;
    public static final int THE_PIT_ID = 11;
    public static final int GOLD_MINE_ID = 12;

    //The gold amount of the different fields
    public static final int TOWER_AMOUNT = 250;
    public static final int CRATER_AMOUNT = -100;
    public static final int PALACE_GATES_AMOUNT = 100;
    public static final int COLD_DESERT_AMOUNT = -20;
    public static final int WALLED_CITY_AMOUNT = 180;
    public static final int MONASTARY_AMOUNT = 0;
    public static final int BLACK_CAVE_AMOUNT = -70;
    public static final int HUTS_IN_THE_MOUNTAIN_AMOUNT = 60;
    public static final int THE_WEREWALL_AMOUNT = -80;
    public static final int THE_PIT_AMOUNT = -50;
    public static final int GOLD_MINE_AMOUNT = 650;

    //Names of the different Fields
    public static final String TOWER_NAME = "Tower";
    public static final String CRATER_NAME = "Crater";
    public static final String PALACE_GATES_NAME = "Palace Gates";
    public static final String COLD_DESERT_NAME = "Cold Desert";
    public static final String WALLED_CITY_NAME = "Walled City";
    public static final String MONASTARY_NAME = "Monastary";
    public static final String BLACK_CAVE_NAME = "Black Cave";
    public static final String HUTS_IN_THE_MOUNTAIN_NAME = "Huts In The Mountains";
    public static final String THE_WEREWALL_NAME = "The Were-Wall";
    public static final String THE_PIT_NAME = "The Pit";
    public static final String GOLD_MINE_NAME = "Gold Mine";

    //Flavor text of each field
    public static final String TOWER_TEXT = "You have entered the Tower and found a chest with " + TOWER_AMOUNT + " Coins";
    public static final String CRATER_TEXT = "You have fallen down a Crater! " + CRATER_AMOUNT + " of your Coins have fallen out of your pocket on the way down";
    public static final String PALACE_GATES_TEXT = "You have entered through the Palace Gates. It's crowded and you manage to steal a pouch containing " + PALACE_GATES_AMOUNT + " Coins from a man passing by";
    public static final String COLD_DESERT_TEXT = "You have entered the Cold Desert and we will take " + COLD_DESERT_AMOUNT + " Coins";
    public static final String WALLED_CITY_TEXT = "You have entered the Walled City and for that you get " + WALLED_CITY_AMOUNT + " Coins";
    public static final String MONASTARY_TEXT = "You have now reached a Monastery, you received " + MONASTARY_AMOUNT + " Coins";
    public static final String BLACK_CAVE_TEXT = "Watch out! BlackCave ahead, you will now be punish by " + BLACK_CAVE_AMOUNT + " Coins";
    public static final String HUTS_IN_THE_MOUNTAIN_TEXT = "You found some Huts in the Moutain with " + HUTS_IN_THE_MOUNTAIN_AMOUNT + "leftover Coins";
    public static final String THE_WEREWALL_TEXT = "You have come across the werewall. You lose" + THE_WEREWALL_AMOUNT + "Coins but you get an extra turn";
    public static final String THE_PIT_TEXT = "You suddenly feel your legs dissapear under you. You barely hang into the ledge to prevent yourself falling into the Pit, though " + THE_PIT_AMOUNT + " Coins slip out of your pocket";
    public static final String GOLD_MINE_TEXT = "You stumple upon a mine filled with Gold you sell for " + GOLD_MINE_AMOUNT + " Coins";
}
