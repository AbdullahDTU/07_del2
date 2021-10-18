package spil;

import java.util.ArrayList;
import java.util.Arrays;

public class Dice {
    private ArrayList<Die> rollingDice;
    private int sum;

    public ArrayList<Die> getRollingDice() {
        return rollingDice;
    }

    public void setRollingDice(ArrayList<Die> rollingDice) {
        this.rollingDice = rollingDice;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public int getSum() {
        return sum;
    }

    public void setupRollingDice() {
        this.rollingDice = new ArrayList<Die>();
        Die die1 = new Die();
        Die die2 = new Die();

        this.sum = 0;

        this.rollingDice.addAll(Arrays.asList(die1, die2));
    }

    public Dice() { //Constructor: Sets the initial face value
        this.setupRollingDice();
    }

    public void rollTheDice() {
        int currentSum = 0;

        for (Die die : this.rollingDice) {
            die.roll();
            currentSum += die.getFaceValue();
            System.out.println("Die: " + die.getFaceValue());
        }

        this.setSum(currentSum);
    }
}
