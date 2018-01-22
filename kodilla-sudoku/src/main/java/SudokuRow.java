import java.util.ArrayList;
import java.util.List;

public class SudokuRow {

    public List<SudokuElement> rowValues;

    public SudokuRow() {

        rowValues = new ArrayList<>(9);
    }
/*
    public void addRow() {
        rowValues.add(new SudokuElement(SudokuElement.EMPTY));
    }

    public List getRowValues() {
        return rowValues;
    }*/
}
