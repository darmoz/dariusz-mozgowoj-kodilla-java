import java.util.ArrayList;
import java.util.List;

public class SudokuBoard {

    public List<SudokuRow> boardValues;

    public SudokuBoard() {
        boardValues = new ArrayList<>(9);
    }

 /*   public void addRows() {
        boardValues.add(new SudokuRow());
    }

    public List getColumnValues() {
        return boardValues;
    }*/
}
