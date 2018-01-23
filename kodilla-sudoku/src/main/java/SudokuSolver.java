import javax.jws.soap.SOAPBinding;
import java.util.Iterator;

public class SudokuSolver {

    public static void main(String[] args) {
        BoardService boardService = new BoardService();
        SudokuBoard workingBoard = boardService.printInitBoard();
        try {
            boardService.insertValues();
        } catch (IllegalInputValueException e) {
            e.printStackTrace();
        };
        boardService.printBoard();
        System.out.println();
        System.out.println(workingBoard.boardValues.get(0).rowValues.get(0).possibleValues);

    }
}
