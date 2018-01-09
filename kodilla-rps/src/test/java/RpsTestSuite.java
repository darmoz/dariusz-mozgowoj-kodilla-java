import org.junit.Assert;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class RpsTestSuite {

    public GameEvaluator evaluator;

    @Test
        public void testMatrixSize() throws IOException {
        //Given
        GameServices rpsGame = new GameServices();
        InputStream resource = getClass().getResourceAsStream("/inputData.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(resource));

        //When
        String line = br.readLine();
        String[] readRowValues = line.trim().split("\\s+");
        int size = readRowValues.length;
        //Then
        Assert.assertEquals(5, size);
    }

    @Test
    public void testEvaluator() throws IOException {

        //Given
        GameServices gameServices = new GameServices();
        InputStream resource = getClass().getResourceAsStream("/inputData.txt");

        //When
        String[][] inputMatrix = gameServices.readFromInputStream(resource);
        String tie = inputMatrix[0][0];
        String youWin = inputMatrix[3][1];
        String aiWin = inputMatrix[1][3];
        //Then
        Assert.assertEquals("T", tie);
        Assert.assertEquals("U", youWin);
        Assert.assertEquals("C", aiWin);
    }

    @Test
    public void testNewGame() {

        //Given
        GameEvaluator evaluator = new GameEvaluator();
        evaluator.aiScore = 3;
        evaluator.userScore = 2;
        evaluator.gameCounter = 6;
        //When
        evaluator.setGameDefaultValues();

        //Then
        Assert.assertEquals(0, evaluator.aiScore);
        Assert.assertEquals(0, evaluator.userScore );
        Assert.assertEquals(0, evaluator.gameCounter);
    }
}
