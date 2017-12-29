public class GameEvaluator {

    boolean end = false;
    int userScore = 0;
    int aiScore = 0;
    int gameCounter = 0;

    public void evaluateGame() {
        GameServices rpsGame = new GameServices();
        String[][] matrix = rpsGame.readGameArray("kodilla-rps\\src\\main\\resources\\inputData.txt");
        User user= new User();
        AI ai = new AI();
        System.out.println("Get started!!");
        while (!end && gameCounter<10) {
                int colNum = user.getGameObject();
                int rowNum = ai.getGameObject();
                if(colNum == 3) {
                    gameCounter = 0;
                    userScore = 0;
                    aiScore = 0;
                    evaluateGame();
                } else if( colNum == 4) {
                    gameStats();
                    end = true;
                } else if (matrix[rowNum][colNum].equals("U")) {
                    userScore = userScore + 1;
                    System.out.println("You win!");
                    gameStats();
                } else if (matrix[rowNum][colNum].equals("C")) {
                    aiScore = aiScore + 1;
                    System.out.println("AI win!");
                    gameStats();
                } else {
                    System.out.println("Tie!");
                    gameStats();
                }
            gameCounter++;
            }

        }

    public void gameStats() {
        System.out.println("Actual User Score: " + userScore);
        System.out.println("Actual AI Score: " + aiScore);
    }
}
