package main.java.spil;

public class Die {
    private int faceValue; // current value showing on the die

    public Die(int faceValue) {
        this.faceValue = faceValue;
    }

    public Die() {
        this.faceValue = Constants.FACE_VALUE;
    }

    public void roll() // Rolls the die and returns result
    {
        this.setFaceValue((int) (Math.random() * Constants.DIE_MAX_FACEVALUE) + 1);
    }

    public int getFaceValue() //Accessor: face value
    {
        return faceValue;
    }

    public void setFaceValue(int faceValue) {
        this.faceValue = faceValue;
    }

    public String toString() //returns a string representation of the die
    {
        return Integer.toString(faceValue);
    }
} 
