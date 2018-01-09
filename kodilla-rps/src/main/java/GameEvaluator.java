import exceptions.EmptyFileException;

import java.io.IOException;
import java.io.InputStream;

public class GameEvaluator {

    private boolean end;
    private int userScore;
    private int aiScore;
    private int gameCounter;
    private InputStream gameResource;
    private static String[][] matrix;

    public void setGameDefaultValues() {
        boolean end = false;
        int userScore = 0;
        int aiScore = 0;
        int gameCounter = 0;
    }

    public void gameStats() {
        System.out.println("Actual User Score: " + userScore);
        System.out.println("Actual AI Score: " + aiScore);
    }

    private void gameLogic(User user, AI ai) throws IOException {
        int colNum = user.getGameObject();
            if (colNum > 4) {
                if (colNum == 5) {
                    gameResource.close();
                    setGameDefaultValues();
                    evaluateGame();
                } else if (colNum == 6) {
                    ai.forUserGameCancellation();
                    gameStats();
                    end = true;
                }
            } else if (colNum <= 4) {
                int rowNum = ai.getGameObject();
                if (matrix[rowNum][colNum].equals("U")) {
                    userScore = userScore + 1;
                    System.out.println("You win!");
                    gameStats();
                } else if (matrix[rowNum][colNum].equals("C")) {
                    aiScore = aiScore + 1;
                    System.out.println("AI win!");
                    gameStats();
                } else if (matrix[rowNum].equals(matrix[colNum])) {
                    System.out.println("Tie!");
                    gameStats();
                }
                gameCounter++;
            }
        }

    public void evaluateGame() throws IOException {
        GameServices rpsGame = new GameServices();
        gameResource = getClass().getResourceAsStream("/inputData.txt");
        //try {
            matrix = rpsGame.readFromInputStream(gameResource);
        //} catch (EmptyFileException e) {
          //  e.printStackTrace();
       // }
        User user = new User();
        AI ai = new AI();
        setGameDefaultValues();
        System.out.println("Get started your adventure!!");
        while (!end && gameCounter < 10) {
            gameLogic(user, ai);

        }
    }
}
