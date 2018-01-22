import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class SudokuElement {

    private  int value;
    public static int EMPTY = -1;
    public List<Integer> possibleValues = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9));

    public SudokuElement(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
