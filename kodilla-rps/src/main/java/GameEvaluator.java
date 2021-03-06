import exceptions.IllegalInputValueException;

import java.io.IOException;
import java.io.InputStream;

public class GameEvaluator {
    private int colNum;
    private int rowNum;
    private int userScore;
    private int aiScore;
    private int gameCounter;
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

    private boolean gameLogic(User user, AI ai) throws IOException, IllegalInputValueException {

        try {
            colNum = user.getAvatar().getObjectValue() - 1;
        } catch (IllegalInputValueException e) {
            e.printStackTrace();
            System.out.println("Try again!");
            user.getAvatar();
        }
            if (colNum > 4) {
                if (colNum == 7) {
                    gameResource.close();
                    setGameDefaultValues();
                    evaluateGame();
                } else if (colNum == 8) {
                    gameResource.close();
                    ai.forUserGameCancellation();
                    gameCounter = gameCounter -1;
                    gameStats();
                }
            } else if (colNum <= 4) {
                rowNum = ai.getAvatar().getObjectValue()-1;
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

    public void evaluateGame() throws IOException, IllegalInputValueException {
        boolean isExit = true;
        GameServices rpsGame = new GameServices();
        gameResource = getClass().getResourceAsStream("/inputData.txt");
        matrix = rpsGame.readFromInputStream(gameResource);
        User user = new User();
        AI ai = new AI();
        setGameDefaultValues();
        System.out.println("Get started your adventure!!");
        while (isExit && gameCounter < 10) {
            if(colNum == 8) {
                isExit = false;
            } else {
                gameLogic(user, ai);
            }
        }
    }
}
