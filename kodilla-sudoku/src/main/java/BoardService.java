import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class BoardService {

    private SudokuRow sudokuRow;
    private UserService userService;
    private SudokuBoard sudokuBoard;
    private int initialInput;
    private Scanner userScanner;


    public SudokuBoard printInitBoard() {
        sudokuBoard = new SudokuBoard();
        for (int row = 0; row < 9; row++) {
            sudokuRow = new SudokuRow();
            sudokuBoard.boardValues.add(sudokuRow);
            System.out.println();
            for (int element = 0; element < 9; element++) {
                sudokuRow.rowValues.add(new SudokuElement(SudokuElement.EMPTY));
                System.out.print("| " + " |");
            }
        }
        return sudokuBoard;
    }

    public void printBoard() {
        for (int row = 0; row < 9; row++) {
            System.out.println();
            for (int column = 0; column < 9; column++) {
                if (sudokuBoard.boardValues.get(row).rowValues.get(column).getValue() == -1) {
                    System.out.print("| " + " |");
                } else {
                    System.out.print("|" + sudokuBoard.boardValues.get(row).rowValues.get(column).getValue() + " |");
                }
            }
        }
    }


    public void rowLoop() {
        for (int row = 0; row < 1; row++) {

            for (int column = 0; column < 9; column++) {

                for (int possibleValueElement = 0; possibleValueElement < sudokuBoard.boardValues.get(row)
                        .rowValues.get(column).possibleValues.size(); possibleValueElement++) {

                    if (sudokuBoard.boardValues.get(row).rowValues.get(column).getValue() == -1) {

                        for (int innerColumnIndexer = 0; innerColumnIndexer < 9; innerColumnIndexer++) {

                            if (sudokuBoard.boardValues.get(row).rowValues.get(column).possibleValues
                                    .get(possibleValueElement).equals(sudokuBoard.boardValues.get(row).rowValues
                                            .get(innerColumnIndexer).getValue())) {

                                removeListElementByValue(row, column, innerColumnIndexer);

                            } else if(sudokuBoard.boardValues.get(row).rowValues.get(column).possibleValues
                                    .contains(sudokuBoard.boardValues.get(row).rowValues.get(innerColumnIndexer)
                                            .possibleValues))

                            /*else if (sudokuBoard.boardValues.get(row).rowValues.get(column).possibleValues.size() == 1) {
                                sudokuBoard.boardValues.get(row).rowValues.get(column).setValue(sudokuBoard.boardValues
                                        .get(row).rowValues.get(column).possibleValues.get(0));*/

                            }

                        }
                    }
                }
            }
        }
    }


    public SudokuBoard insertValues() throws IllegalInputValueException {
        userService = new UserService();
        boolean stillPrepare = true;
        while (stillPrepare) {
            String input = userService.getMenu().name();
            if (input.equals("i")) {
                System.out.println("Type 3 digits in a row: row number, column number, value f.ex 123");
                userScanner = new Scanner(System.in);
                initialInput = userScanner.nextInt();
                sudokuBoard.boardValues.get(Integer.parseInt(String.valueOf(initialInput).substring(0, 1)) - 1)
                        .rowValues.get(Integer.parseInt(String.valueOf(initialInput).substring(1, 2)) - 1)
                        .setValue(Integer.parseInt(String.valueOf(initialInput).substring(2, 3)));
                sudokuBoard.boardValues.get(Integer.parseInt(String.valueOf(initialInput).substring(0, 1)) - 1)
                        .rowValues.get(Integer.parseInt(String.valueOf(initialInput).substring(1, 2)) - 1)
                        .possibleValues.clear();
            } else if (input.equals("f")) {
                rowLoop();
                stillPrepare = false;
            } else {
                stillPrepare = false;
            }
        }
        return sudokuBoard;
    }



    private void removeListElementByValue(int row, int column, int innerColumnIndexer) {
        Iterator<Integer> iterator = sudokuBoard.boardValues.get(row).rowValues.get(column).possibleValues.iterator();
        while(iterator.hasNext()) {
            Integer index = iterator.next();
            if(index == sudokuBoard.boardValues.get(row).rowValues.get(innerColumnIndexer).getValue()) {
                iterator.remove();
            }
         }
    }
}

