package spil;

public class Dice {

    private final int MAX = 6; // maximum face value

    private int faceValue; // current value showing on the die


    public Dice() //Constructor: Sets the initial face value
    {
        faceValue = 1;

    }

    public int roll() // Rolls the die and returns result
    {
        faceValue = (int) (Math.random() * MAX) + 1;


        return faceValue;

    }

    public void setFaceValue(int value) //Mutator: face value
    {
        faceValue = value;

    }

    public int getFaceValue() //Accessor: face value
    {
        return faceValue;
    }

    public String toString() //returns a string representation of the die
    {
        String result = Integer.toString(faceValue);

        return result;
    }

} 
