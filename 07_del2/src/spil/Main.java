package spil;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//The main Class which runs the game
public class Main {
    private boolean gameHasFinished;
    private Board board;
    private RollingDice rollingDice;
    private List<Player> players; // List of players

    //Scanner to check for user keypress input
    Scanner scan = new Scanner(System.in);
    private String userInput;

    public boolean isGameHasFinished() {
        return gameHasFinished;
    }

    public void setGameHasFinished(boolean gameHasFinished) {
        this.gameHasFinished = gameHasFinished;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public void initBoard() {
        this.board = new Board();
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

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    //Method to add players
    public void setupPlayers(Player... players) {
        List<Player> playersToAdd = new ArrayList<Player>();

        for (Player player : players) {
            List<Field> startFields = new ArrayList<Field>();
            Account newPlayerAccount = new Account(
                    Constants.START_BALANCE,
                    startFields
            );

            player.setPlayerPosition(Constants.START_POSITION);
            player.setAccount(newPlayerAccount);

            playersToAdd.add(player);
        }

        this.setPlayers(playersToAdd);
    }

    //Runs the different methods
    public static void main(String[] args) {
        Main main = new Main();

        main.initBoard();
        main.initRollingDice();


        //Creating two players with 0 money
        Player playerOne = new Player("PlayerOne", null);
        Player playerTwo = new Player("PlayerTwo", null);

        //Setting up the players with their Variables
        main.setupPlayers(playerOne, playerTwo);

        for (Player player : main.players) {
            System.out.println(player.getPlayerName());
            System.out.println(player.getAccount().getBalance());
        }

        do {
            main.playRound();
        } while (!main.gameHasFinished);


        //main.printWelcomeMessage();
        //main.performDiceRoll();
    }

    //A one time welcome message printed at the start of the game
    private void printWelcomeMessage() {
        System.out.println("Welcome to the Dice Game");
        System.out.println("Player 1 Starts rolling the Dice");
        System.out.println("To roll the dice press Enter");
        System.out.println("\n");
    }

    private void printWinMessage() {
        System.out.println("Game has finished.");

        for (Player player : this.players) {
            System.out.println("Player " + player.getPlayerName() + " with balance of " + player.getAccount().getBalance());
        }
    }

    //Prints an empty line to make text more readable
    private void printSeperator() {
        System.out.println("\n");
    }

    private void playRound() {
        for (Player player : this.players) {

            //Manual pressing of Enter to roll dice
            /*
            do {
                userInput = scan.nextLine();
            } while (!userInput.equals(""));

             */

            // Roll the Dice
            getRollingDice().rollTheDice();
            int diceValue = getRollingDice().getSum();

            // Player position
            int currentPlayerPosition = player.getPlayerPosition();
            int newPlayerPosition = this.calculateNewPlayerPosition(currentPlayerPosition, diceValue);
            //int newPlayerPosition = diceValue;

            //player.setPlayerPosition(newPlayerPosition);
            player.setPlayerPosition(Constants.START_POSITION);

            // Get field location
            Field currentFieldOLD = this.getBoard().getFields().get(currentPlayerPosition);
            Field currentField = this.getBoard().getFields().get(newPlayerPosition);

            // Get field Price
            int currentFieldPrice = currentField.getFieldPrice();
            int currentPlayerBalance = player.getAccount().getBalance();
            int newPlayerBalance = currentPlayerBalance + currentFieldPrice;
            player.getAccount().setBalance(newPlayerBalance);

            // Print info
            System.out.println("Player: " + player.getPlayerName());
            System.out.println("Old Balance: " + currentPlayerBalance);
            System.out.println("New Balance: " + newPlayerBalance);
            System.out.println("Sum: " + diceValue);
            System.out.println("Old Field: " + currentPlayerPosition);
            System.out.println("Old FieldName: " + currentFieldOLD.getFieldName());
            System.out.println("New Field: " + newPlayerPosition);
            System.out.println("New FieldPrice: " + currentField.getFieldPrice());
            System.out.println("New FieldName: " + currentField.getFieldName());
            System.out.println("\n");

            if (Constants.WIN_SCORE <= player.getAccount().getBalance()) {
                this.gameHasFinished = true;
                printWinMessage();
                break;
            }
        }
    }

    private int calculateNewPlayerPosition(int currentPlayerPosition, int diceRollSum) {
        int possibleNewPosition = currentPlayerPosition + diceRollSum;
        int numberOfFields = this.getBoard().getFields().size();

        if (numberOfFields <= possibleNewPosition) {
            return 0;
        }

        return possibleNewPosition;
    }


/*
    //Method that allows the players to roll the dice, add the value to the players' scores and change turns
    private void performDiceRoll() {

        switch (currentPlayer) {

            //If it Player 1's turn, print out the scores and allow Player 1 to roll the dice
            case PLAYER_ONE:
                System.out.println("Player 1's turn to roll the dice");
                System.out.println("Player 1 Score: " + getPlayerOneBalance() + "\nPlayer 2 Score: " + getPlayerTwoBalance() + "\n");

                do {
                    userInput = scan.nextLine();
                } while (!userInput.equals(""));

                //Roll the dice and add the score to the player's total score, then change turns
                getRollingDice().rollTheDice();

                setPlayerOneBalance(getPlayerOneBalance() + getRollingDice().getSum());

                printSeperator();

                //Checks if Player One has reached 40 points or more and ends the game
                if (getPlayerOneBalance() >= winScore) {
                    System.out.println("Player 1 har vundet med " + getPlayerOneBalance() + " points!");
                    break;
                }

                switchCurrentPlayer();
                this.performDiceRoll();

                break;

            //If it Player 2's turn, print out the scores and allow Player 1 to roll the dice
            case PLAYER_TWO:
                System.out.println("Player 2's turn to roll the dice");
                System.out.println("Player 1 Score: " + getPlayerOneBalance() + "\nPlayer 2 Score: " + getPlayerTwoBalance() + "\n");

                do {
                    userInput = scan.nextLine();
                } while (!userInput.equals(""));

                //Roll the dice and add the score to the player's total score, then change turns
                getRollingDice().rollTheDice();
                setPlayerTwoBalance(getPlayerTwoBalance() + getRollingDice().getSum());
                printSeperator();

                //Checks if Player Two has reached 40 points or more and ends the game
                if (getPlayerTwoBalance() >= winScore) {
                    System.out.println("Player 2 har vundet med " + getPlayerTwoBalance() + " points!");
                    break;
                }

                switchCurrentPlayer();
                this.performDiceRoll();

                break;
        }


    }
    */
}
