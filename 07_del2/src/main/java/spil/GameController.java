package main.java.spil;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameController {
    private boolean gameHasFinished;
    private Board board;
    private Dice dice;
    private List<Player> players; // List of players

    public GameController() {
    }

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

    public Dice getDice() {
        return dice;
    }

    public void setDice(Dice dice) {
        this.dice = dice;
    }

    public void initDice() {
        this.dice = new Dice();
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
    protected void initGame() {
        this.initBoard();
        this.initDice();

        this.printWelcomeMessage();

        for (Player player : this.players) {
            System.out.println(player.getPlayerName());
            System.out.println(player.getAccount().getBalance());
        }
    }

    protected void startGame() {
        //Do loop to constantly run the game while gameHasFinished is false
        do {
            this.playRound();
        } while (!this.gameHasFinished);
    }

    //A one time welcome message printed at the start of the game
    private void printWelcomeMessage() {
        System.out.println("Welcome to the Dice Game");
        System.out.println("Player 1 Starts rolling the Dice");
        System.out.println("To roll the dice press Enter");
        System.out.println("First player to reach 3000 Coins, wins.");
        System.out.println("\n");
    }

    //After one of the player's reaches the WinScore, the game ends and prints the balance of both players.
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

    //Responsible for running the game
    private void playRound() {
        for (Player player : this.players) {

            //Manual pressing of Enter to roll dice
            do {
                userInput = scan.nextLine();
            } while (!userInput.equals(""));

            // Roll the Dice
            dice.rollTheDice();
            int diceValue = getDice().getSum();

            // Player position
            int currentPlayerPosition = player.getPlayerPosition();
            int newPlayerPosition = this.calculateNewPlayerPosition(currentPlayerPosition, diceValue);
            //int newPlayerPosition = diceValue;

            //player.setPlayerPosition(newPlayerPosition);
            player.setPlayerPosition(Constants.START_POSITION);

            // Get field location
            Field currentFieldOLD = this.getBoard().getFields().get(currentPlayerPosition);
            //Field currentFieldOLD = this.getBoard().getFields().get(currentPlayerPosition);
            Field currentField = this.getBoard().getFields().get(newPlayerPosition);

            // Get field Price
            int currentFieldPrice = currentField.getFieldPrice();
            int currentPlayerBalance = player.getAccount().getBalance();
            int newPlayerBalance = calculateNewPlayerBalance(currentPlayerBalance,currentFieldPrice);

            //int newPlayerBalance = currentPlayerBalance + currentFieldPrice;
            player.getAccount().setBalance(newPlayerBalance);

            // Print info for debugging Test
            /*
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
             */

            //Info that is printed after each round
            System.out.println("Sum: " + diceValue);
            System.out.println("Player: " + player.getPlayerName());
            System.out.println("Old Balance: " + currentPlayerBalance);
            System.out.println("New Balance: " + newPlayerBalance);
            System.out.println("New FieldName: " + currentField.getFieldName());
            System.out.println("New FieldPrice: " + currentField.getFieldPrice());
            System.out.println("New FieldText: " + currentField.getFieldText());
            System.out.println("\n");

            int currentExtraTurn = player.getExtraTurn();

            System.out.println("Current Field ID " + currentField.getFieldID());


            if (currentField.getFieldID() ==
                    10) {
                currentExtraTurn = currentExtraTurn + 1;
                System.out.println("Extra turn count " + currentExtraTurn);
            }

            if (0 < currentExtraTurn) {
                System.out.println("Extra turn GIVEN " + currentExtraTurn);

                currentExtraTurn = currentExtraTurn - 1;
                System.out.println("Extra turn Count after usage " + currentExtraTurn);
            }

            //Checks if any of the players have reached the winscore and then ends the game
            if (Constants.WIN_SCORE <= player.getAccount().getBalance()) {
                this.gameHasFinished = true;
                printWinMessage();
                break;
            }
        }
    }

    //Calculates the new player position after throwing dice
    private int calculateNewPlayerPosition(int currentPlayerPosition, int diceRollSum) {
        int possibleNewPosition = currentPlayerPosition + diceRollSum - 2;
        int numberOfFields = this.getBoard().getFields().size();

        /*
        if (numberOfFields <= possibleNewPosition) {
            return 0;
        }
        */

        return possibleNewPosition;
    }

    public static int calculateNewPlayerBalance(int currentPlayerBalance, int balanceToAdd) {
        int newPlayerBalance = balanceToAdd + currentPlayerBalance;

        if (newPlayerBalance < 0) {
            return 0;
        }

        return newPlayerBalance;
    }

}
