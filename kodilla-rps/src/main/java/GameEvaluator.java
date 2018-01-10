import exceptions.IllegalInputValueException;

import java.io.IOException;
import java.io.InputStream;

public class GameEvaluator {

    /*private*/ int userScore;
    /*private*/ int aiScore;
    /*private*/ int gameCounter;
    private InputStream gameResource;
    private static String[][] matrix;

    public void setGameDefaultValues() {
        userScore = 0;
        aiScore = 0;
        gameCounter = 0;
    }

    public void gameStats() {
        System.out.println("Actual game nr " + (gameCounter + 1) + " of 10");
        System.out.println("Actual User Score: " + userScore);
        System.out.println("Actual AI Score: " + aiScore);
    }

    private boolean gameLogic(User user, AI ai) throws IOException {
        int colNum = 0;
        try {
            colNum = user.getGameObject().getObjectValue();
        } catch (IllegalInputValueException e) {
            e.printStackTrace();
        }
        if (colNum > 4) {
                if (colNum == 5) {
                    gameResource.close();
                    setGameDefaultValues();
                    evaluateGame();
                } else if (colNum == 6) {
                    ai.forUserGameCancellation();
                    gameStats();
                }
            } else if (colNum <= 4) {
                int rowNum = ai.getGameObject().getObjectValue();
                final String resultValue = matrix[rowNum][colNum];
                hasUserWin(resultValue);
                if (matrix[rowNum].equals(matrix[colNum])) {
                    System.out.println("Tie!");
                    gameStats();
                }
                gameCounter++;
            }
            return true;
        }

    private boolean hasUserWin(String resultValue) {
        boolean result = false;
        if (resultValue.equals("U")) {
            userScore = userScore + 1;
            System.out.println("You win!");
            gameStats();
            result = true;
        } else if (resultValue.equals("C")) {
            aiScore = aiScore + 1;
            System.out.println("AI win!");
            gameStats();
            result = false;
        }
        return result;
    }

    public void evaluateGame() throws IOException {
        GameServices rpsGame = new GameServices();
        gameResource = getClass().getResourceAsStream("/inputData.txt");
        matrix = rpsGame.readFromInputStream(gameResource);
        User user = new User();
        AI ai = new AI();
        setGameDefaultValues();
        System.out.println("Get started your adventure!!");
        while (gameCounter < 10) {
            gameLogic(user, ai);
        }
    }
}
