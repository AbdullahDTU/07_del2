package main.java.spil;

//The main Class which runs the game
public class Main {

    //Runs the different methods
    public static void main(String[] args) {
        GameController gameController = new GameController();

        //Creating two players with 0 money
        Player playerOne = new Player("PlayerOne", null);
        Player playerTwo = new Player("PlayerTwo", null);

        //Setting up the players with their Variables
        gameController.setupPlayers(playerOne, playerTwo);
        gameController.initGame();
        gameController.startGame();
    }

}
