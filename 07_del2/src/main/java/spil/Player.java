package main.java.spil;

public class Player {
    private String playerName;
    private int playerPosition;
    private Account account;
    private int extraTurn = 0;

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getPlayerPosition() {
        return playerPosition;
    }

    public void setPlayerPosition(int playerPosition) {
        this.playerPosition = playerPosition;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Player(String playerName, int playerPosition, Account account) {
        this.playerName = playerName;
        this.playerPosition = playerPosition;
        this.account = account;
    }

    public Player(String playerName, Account account) {
        this.playerName = playerName;
        this.account = account;
    }

    public int getExtraTurn() {
        return extraTurn;
    }

    public void setExtraTurn(int extraTurn) {
        this.extraTurn = extraTurn;
    }

}
