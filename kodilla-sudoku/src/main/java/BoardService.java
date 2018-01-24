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
        for (int row = 0; row < 9; row++) {

            for (int column = 0; column < 9; column++) {

                Iterator<Integer> iterator = sudokuBoard.boardValues.get(row).rowValues.get(column).possibleValues.iterator();

                if (sudokuBoard.boardValues.get(row).rowValues.get(column).getValue() == -1) {

                    while (iterator.hasNext()) {
                        Integer index = iterator.next();

                        for (int innerColumnIndexer = 0; innerColumnIndexer < 9; innerColumnIndexer++) {

                                if (index == sudokuBoard.boardValues.get(row).rowValues.get(innerColumnIndexer).getValue()) {
                                    iterator.remove();

                                } else if (sudokuBoard.boardValues.get(row).rowValues.get(column).possibleValues.size() == 1) {
                                    sudokuBoard.boardValues.get(row).rowValues.get(column).setValue(sudokuBoard.boardValues
                                            .get(row).rowValues.get(column).possibleValues.get(0));

                                } else if(!sudokuBoard.boardValues.get(row).rowValues.get(innerColumnIndexer)
                                        .possibleValues.contains(index)
                                        && /*!sudokuBoard.boardValues.get(row).rowValues
                                        .get(innerColumnIndexer).possibleValues.isEmpty()
                                        &&*/ index == sudokuBoard.boardValues.get(row).rowValues.get(innerColumnIndexer)
                                        .getValue()) {
                                    System.out.println(sudokuBoard.boardValues.get(row).rowValues.get(innerColumnIndexer)
                                            .possibleValues + " " + row + " " + column + " " + innerColumnIndexer
                                            + " " + index);
                                }
                        }
                    }
                }
            }
        }
    }

    public void columnLoop() {
        for (int column = 0; column < 9; column++) {

            for (int row = 0; row < 9; row++) {

                Iterator<Integer> iterator = sudokuBoard.boardValues.get(row).rowValues.get(column).possibleValues.iterator();

                if (sudokuBoard.boardValues.get(row).rowValues.get(column).getValue() == -1) {

                    while (iterator.hasNext()) {
                        Integer index = iterator.next();

                        for (int innerRowIndexer = 0; innerRowIndexer < 9; innerRowIndexer++) {

                            if (index == sudokuBoard.boardValues.get(innerRowIndexer).rowValues.get(column).getValue()) {
                                iterator.remove();

                            } else if (sudokuBoard.boardValues.get(row).rowValues.get(column).possibleValues.size() == 1) {
                                sudokuBoard.boardValues.get(row).rowValues.get(column).setValue(sudokuBoard.boardValues
                                        .get(row).rowValues.get(column).possibleValues.get(0));

                            } else if(!sudokuBoard.boardValues.get(row).rowValues.get(innerRowIndexer)
                                    .possibleValues.contains(index)
                                    &&  index == sudokuBoard.boardValues.get(row).rowValues.get(innerRowIndexer)
                                    .getValue()) {
                                System.out.println(sudokuBoard.boardValues.get(row).rowValues.get(innerRowIndexer)
                                        .possibleValues + " " + row + " " + column + " " + innerRowIndexer
                                        + " " + index);
                            }
                        }
                    }
                }
            }
        }
    }


    public void sectionLoop() {
        int section = 0;
        int sectionRow;
        int sectionColumn;

        while (section < 9) {
            if (section < 3) {
                sectionRow = 0;
                sectionColumn = 0;
            } else if (section > 2 && section < 6) {
                sectionRow = 3;
                sectionColumn = 3;
            } else {
                sectionRow = 6;
                sectionColumn = 6;
            }
            for (int row = sectionRow; row < sectionRow + 3; row++) {
                for (int column = sectionColumn; column < sectionColumn + 3; column++) {
                    Iterator<Integer> sectionIterator = sudokuBoard.boardValues.get(row).rowValues.get(column).possibleValues.iterator();

                    while (sectionIterator.hasNext()) {
                        Integer sectionIndex = sectionIterator.next();

                        for (int innerSectionCellIndexer = 0; innerSectionCellIndexer < 9; innerSectionCellIndexer++) {

                            if (sectionIndex == sudokuBoard.boardValues.get(row).rowValues.get(innerSectionCellIndexer).getValue()) {
                                sectionIterator.remove();

                            }
                        }
                    }
                }
                section += 1;
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
                columnLoop();
                sectionLoop();
                stillPrepare = false;
            } else {
                stillPrepare = false;
            }
        }
        return sudokuBoard;
    }

}

