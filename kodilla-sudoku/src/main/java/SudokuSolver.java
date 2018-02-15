import javax.jws.soap.SOAPBinding;
import java.util.Iterator;

public class SudokuSolver {

    public static void main(String[] args) {
        SudokuProcess sudokuProcess = new SudokuProcess();
        SudokuBoard workingBoard = sudokuProcess.processSudoku();
        System.out.println();
        System.out.println(workingBoard.boardValues.get(0).rowValues.get(0).possibleValues);
        System.out.println(workingBoard.boardValues.get(0).rowValues.get(7).possibleValues);
    }
}
