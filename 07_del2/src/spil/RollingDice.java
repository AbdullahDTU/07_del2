package spil;
// Creates two Die objects and rolls them
//
public class RollingDice {
    private Dice die1, die2;
    private int sum;

    public int getSum() {
        return sum;
    }

    public RollingDice() {
        this.die1 = new Dice();
        this.die2 = new Dice();
        this.sum = 0;
    }


    protected void rollTheDice() {
        die1.roll();
        die2.roll();

        System.out.println("First die: " + die1 + ", Second die: " + die2);

        sum = die1.getFaceValue() + die2.getFaceValue();
    }
}
