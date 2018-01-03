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

    public void evaluateGame() throws IOException {
        GameServices rpsGame = new GameServices();
        gameResource = getClass().getResourceAsStream("/inputData.txt");
        matrix = rpsGame.readFromInputStream(gameResource);
        User user = new User();
        AI ai = new AI();
        setGameDefaultValues();
        System.out.println("Get started!!");
        while (!end && gameCounter < 10) {
            int colNum = user.getGameObject();
            if (colNum > 2) {
                if (colNum == 3) {
                    gameResource.close();
                    setGameDefaultValues();
                    evaluateGame();
                } else if (colNum == 4) {
                    ai.forUserGameCancelation();
                    gameStats();
                    end = true;
                }
            } else if(colNum<=2) {
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
    }
}
