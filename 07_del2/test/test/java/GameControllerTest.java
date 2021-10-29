package test.java;

import main.java.spil.Account;
import main.java.spil.Field;
import main.java.spil.GameController;
import main.java.spil.Player;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class GameControllerTest {

    @Test
    void testPlayerBalanceNotExceedingZero() {
        GameController gameController = new GameController();
        Account account = new Account(1000, new ArrayList<Field>());
        Player player = new Player("PlayerTest", account);

        int currentBalance = player.getAccount().getBalance();


        int newBalance = gameController.calculateNewPlayerBalance(1000, -2000);

        boolean isPlayerBalanceNotExceedingZero = newBalance >= 0;

        assertTrue(isPlayerBalanceNotExceedingZero, "");

    }

}