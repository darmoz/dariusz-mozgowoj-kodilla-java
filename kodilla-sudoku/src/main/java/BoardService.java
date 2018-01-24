import java.util.Iterator;
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


    private void rowLoop() {
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
                                        && index == sudokuBoard.boardValues.get(row).rowValues.get(innerColumnIndexer)
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

    private void columnLoop() {
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


    private void sectionLoop() {
        int tempRowValue = 0;
        int tempColumnValue = 0;
        for(int sectionRow=0; sectionRow<1; sectionRow++) {
            for(int sectionColumn=0; sectionColumn<3; sectionColumn++) {
                for(int innerSectionRow=tempRowValue; innerSectionRow<tempRowValue +3; innerSectionRow++) {
                    for(int innerSectionColumn=tempColumnValue; innerSectionColumn<tempColumnValue+3; innerSectionColumn++) {
                        Iterator<Integer> iterator = sudokuBoard.boardValues.get(innerSectionRow).rowValues
                                .get(innerSectionColumn).possibleValues.iterator();
                        if (sudokuBoard.boardValues.get(innerSectionRow).rowValues.get(innerSectionColumn).getValue() == -1) {

                            while (iterator.hasNext()) {
                                Integer index = iterator.next();

                                for (int innerRowIndexer = 0; innerRowIndexer < 3; innerRowIndexer++) {
                                    for(int innerColumnIndexer =0; innerColumnIndexer<3; innerColumnIndexer++) {
                                        System.out.println(index + " " + sudokuBoard.boardValues.get(innerRowIndexer).rowValues.get(innerColumnIndexer).getValue() + " " + innerSectionRow + " " + innerSectionColumn + " " + innerRowIndexer + " " + innerColumnIndexer );

                                        if (index == sudokuBoard.boardValues.get(innerRowIndexer).rowValues.get(innerColumnIndexer).getValue()) {
                                            iterator.remove();

                                        }
                                    }
                                }
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

