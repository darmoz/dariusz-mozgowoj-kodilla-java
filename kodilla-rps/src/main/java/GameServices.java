import exceptions.EmptyFileException;
import java.io.*;

public class GameServices {

    private int size = 0;
    private int row = 0;
    private String[][] matrix = null;

    public String[][] readFromInputStream(InputStream inputStream)
            throws IOException /*EmptyFileException*/ {
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] readRowValues = line.trim().split("\\s+");
                size = readRowValues.length;
               // if (size != 0) {
                    if (matrix == null) {
                        matrix = new String[size][size];
                    }
                    for (int column = 0; column < size; column++) {
                        matrix[row][column] = readRowValues[column];
                    }
                    row++;
              //  }
               // throw new EmptyFileException("ERROR");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
            return matrix;
    }
}

