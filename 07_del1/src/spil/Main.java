package spil;

import java.util.Scanner;

//Variable used to change between which player is rolling the dice
enum PLAYER {
    PLAYER_ONE,
    PLAYER_TWO
}

//The main Class which runs the game
public class Main {
    //Variables for player score and score required to win
    private int playerOneScore = 0;
    private int playerTwoScore = 0;
    private int winScore = 40;
    //Variable that alters which player's turn to roll the dice
    private PLAYER currentPlayer = PLAYER.PLAYER_ONE;

    //Scanner to check for user keypress input
    Scanner scan = new Scanner(System.in);
    private String userInput;

    public int getPlayerOneScore() {
        return playerOneScore;
    }

    public void setPlayerOneScore(int playerOneScore) {
        this.playerOneScore = playerOneScore;
    }

    public int getPlayerTwoScore() {
        return playerTwoScore;
    }

    public void setPlayerTwoScore(int playerTwoScore) {
        this.playerTwoScore = playerTwoScore;
    }

    public RollingDice getRollingDice() {
        return rollingDice;
    }

    public void setRollingDice(RollingDice rollingDice) {
        this.rollingDice = rollingDice;
    }

    public void initRollingDice() {
        this.rollingDice = new RollingDice();
    }

    private RollingDice rollingDice;

    //Runs the different methods
    public static void main(String[] args) {
        Main main = new Main();

        main.initRollingDice();
        main.printWelcomeMessage();
        main.performDiceRoll();
    }

    //A one time welcome message printed at the start of the game
    private void printWelcomeMessage() {
        System.out.println("Welcome to the Dice Game");
        System.out.println("Player 1 Starts rolling the Dice");
        System.out.println("To roll the dice press Enter");
        System.out.println("\n");
    }

    //Method to change the players turn
    private void switchCurrentPlayer() {
        switch (currentPlayer) {
            case PLAYER_ONE:
                this.currentPlayer = PLAYER.PLAYER_TWO;
                break;

            case PLAYER_TWO:
                this.currentPlayer = PLAYER.PLAYER_ONE;
                break;
        }
    }

    //Prints an empty line to make text more readable
    private void printSeperator() {
        System.out.println("\n");
    }

    //Method that allows the players to roll the dice, add the value to the players' scores and change turns
    private void performDiceRoll() {

        switch (currentPlayer) {

            //If it Player 1's turn, print out the scores and allow Player 1 to roll the dice
            case PLAYER_ONE:
                System.out.println("Player 1's turn to roll the dice");
                System.out.println("Player 1 Score: " + getPlayerOneScore() + "\nPlayer 2 Score: " + getPlayerTwoScore() + "\n");

                do {
                    userInput = scan.nextLine();
                } while (!userInput.equals(""));

                //Roll the dice and add the score to the player's total score, then change turns
                getRollingDice().rollTheDice();
                setPlayerOneScore(getPlayerOneScore() + getRollingDice().getSum());
                printSeperator();

                //Checks if Player One has reached 40 points or more and ends the game
                if (getPlayerOneScore() >= winScore) {
                    System.out.println("Player 1 har vundet med " + getPlayerOneScore() + " points!");
                    break;
                }

                switchCurrentPlayer();
                this.performDiceRoll();

                break;

            //If it Player 2's turn, print out the scores and allow Player 1 to roll the dice
            case PLAYER_TWO:
                System.out.println("Player 2's turn to roll the dice");
                System.out.println("Player 1 Score: " + getPlayerOneScore() + "\nPlayer 2 Score: " + getPlayerTwoScore() + "\n");

                do {
                    userInput = scan.nextLine();
                } while (!userInput.equals(""));

                //Roll the dice and add the score to the player's total score, then change turns
                getRollingDice().rollTheDice();
                setPlayerTwoScore(getPlayerTwoScore() + getRollingDice().getSum());
                printSeperator();

                //Checks if Player Two has reached 40 points or more and ends the game
                if (getPlayerTwoScore() >= winScore) {
                    System.out.println("Player 2 har vundet med " + getPlayerTwoScore() + " points!");
                    break;
                }

                switchCurrentPlayer();
                this.performDiceRoll();

                break;
        }

    }
}
