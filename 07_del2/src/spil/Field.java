package spil;

public class Field {

    public static void main(String[] args) {
        //The gold amount of the different fields
        int Tower = 250;
        int Crater = 100;
        int PalaceGates = 100;
        int ColdDesert = 20;
        int WalledCity = 180;
        int Monastary = 0;
        int BlackCave = 70;
        int HutsInTheMountain = 60;
        int TheWerewall = 80;
        int ThePit = 50;
        int GoldMine = 650;

        //Flavor text of each field
        String TowerText = "You have entered the Tower and found a chest with " + Tower + " Gold pieces";
        String CraterText = "You have fallen down a Crater! " + Crater + " of your gold pieces have fallen out of your pocket on the way down";
        String PalaceGatesText = "You have entered through the Palace Gates. It's crowded and you manage to steal a gold pouch containing " + PalaceGates + " gold pieces from a man passing by";
        String ColdDesertText = "You have entered the Cold Desert and we will take " + ColdDesert + " Gold pieces";
        String WalledCityText = "You have entered the Walled City and for that you get " + WalledCity + " Gold pieces";
        String MonastaryText = "You have now reached a Monastery, you received" + Monastary + "coins";
        String BlackCaveText = "Watch out! BlackCave ahead, you will now be punish by" + BlackCave + "coins";
        String HutsInTheMountainText = "You found some Huts in the Moutain with " + HutsInTheMountain + "leftover coins";
        String TheWerewallText = "You have come across the werewall. You lose" + TheWerewall + "coins but you get an extra turn";
        String ThePitText = "You barely hang into the edge to prevent yourself falling into the Pit " + ThePit + " Gold pieces slip out of your pocket";
        String GoldMineText = "You stumple upon a mine filled with Gold you " + GoldMine + " Gold pieces";

        //Printing out flavor text
        System.out.println(TowerText);
        System.out.println(CraterText);
        System.out.println(PalaceGatesText);
        System.out.println(ColdDesertText);
        System.out.println(WalledCityText);
        System.out.println(MonastaryText);
        System.out.println(BlackCaveText);
        System.out.println(HutsInTheMountainText);
        System.out.println(TheWerewallText);
        System.out.println(ThePitText);
        System.out.println(GoldMineText);


    }
}
