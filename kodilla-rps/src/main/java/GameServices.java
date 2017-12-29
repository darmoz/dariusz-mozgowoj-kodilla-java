import java.io.*;

public class GameServices {

    String fileName;

    public static String[][] readGameArray(String fileName) {
        String line = null;
        int size = 0;
        int row = 0;
        String[][] matrix = null;

        try {
            FileReader reader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(reader);

            while((line = bufferedReader.readLine()) != null) {

                String[] vals = line.trim().split("\\s+");
                size = vals.length;

                if(matrix == null) {
                    matrix = new String[size][size];
                }

                for(int col = 0; col<size; col++) {
                   matrix[row][col] = vals[col];
                }
                row++;
                }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return matrix;
    }


}
