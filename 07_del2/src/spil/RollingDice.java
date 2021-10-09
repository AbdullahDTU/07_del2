package spil;
// Creates two Die objects and rolls them
//
public class RollingDice {
    private Dice die1, die2;
    private int sum;

    public Dice getDie1() {
        return die1;
    }

    public void setDie1(Dice die1) {
        this.die1 = die1;
    }

    public Dice getDie2() {
        return die2;
    }

    public void setDie2(Dice die2) {
        this.die2 = die2;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
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
        System.out.println("Sum: " + sum + " bliver lagt til spillerens point");

    }
}
