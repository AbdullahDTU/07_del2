package spil;

public class Player {
    private String playerName;
    //private int playerPosition;
    private Account account;

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public Player(String playerName, Account account) {
        this.playerName = playerName;
        this.account = account;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }



}
