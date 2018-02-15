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
                                break;
                            }
                        }
                    }



                            }  else if (innerColumnIndexer != column &&
                                    !sudokuBoard.boardValues.get(row).rowValues.get(innerColumnIndexer)
                                    .possibleValues.contains(index)
                                    && index != sudokuBoard.boardValues.get(row).rowValues.get(innerColumnIndexer)
                                    .getValue()) {

                                sudokuBoard.boardValues.get(row).rowValues.get(column).setValue(index);
                            }
                        }

                    }
                }
            }
        }
    }

   /* private void columnLoop() {
        for (int column = 0; column < 9; column++) {

            for (int row = 0; row < 9; row++) {

                Iterator<Integer> iterator = sudokuBoard.boardValues.get(row).rowValues.get(column).possibleValues.iterator();

                if (sudokuBoard.boardValues.get(row).rowValues.get(column).getValue() == -1) {

                    while (iterator.hasNext()) {

                        for (int innerRowIndexer = 0; innerRowIndexer < 9; innerRowIndexer++) {
                            Integer index = iterator.next();

                            if (index == sudokuBoard.boardValues.get(innerRowIndexer).rowValues.get(column).getValue()) {
                                iterator.remove();

                            } else if (sudokuBoard.boardValues.get(row).rowValues.get(column).possibleValues.size() == 1) {
                                sudokuBoard.boardValues.get(row).rowValues.get(column).setValue(sudokuBoard.boardValues
                                        .get(row).rowValues.get(column).possibleValues.get(0));

                            } if(innerRowIndexer != row &&
                                    !sudokuBoard.boardValues.get(row).rowValues.get(innerRowIndexer)
                                    .possibleValues.contains(index)
                                    &&  index != sudokuBoard.boardValues.get(row).rowValues.get(innerRowIndexer)
                                    .getValue()) {
                                sudokuBoard.boardValues.get(row).rowValues.get(column).setValue(index);
                            }
                        }
                    }
                }
            }
        }
    }

    private void sectionLoop() {

        for(int sectionRow=0; sectionRow<3; sectionRow++) {

            for(int sectionColumn=0; sectionColumn<3; sectionColumn++) {

                for(int innerSectionRow=sectionRow*3; innerSectionRow<sectionRow*3+3; innerSectionRow++) {

                    for(int innerSectionColumn=sectionColumn*3; innerSectionColumn<sectionColumn*3+3; innerSectionColumn++) {

                        Iterator<Integer> iterator = sudokuBoard.boardValues.get(innerSectionRow).rowValues
                                .get(innerSectionColumn).possibleValues.iterator();

                        if (sudokuBoard.boardValues.get(innerSectionRow).rowValues.get(innerSectionColumn).getValue() == -1) {

                            while (iterator.hasNext()) {


                                for (int innerRowIndexer = sectionRow*3; innerRowIndexer <sectionRow*3+3; innerRowIndexer++) {

                                    for(int innerColumnIndexer =sectionColumn*3; innerColumnIndexer<sectionColumn*3+3; innerColumnIndexer++) {
                                        Integer index = iterator.next();

                                        if (index == sudokuBoard.boardValues.get(innerRowIndexer).rowValues.get(innerColumnIndexer).getValue()) {
                                            iterator.remove();

                                        } else if (sudokuBoard.boardValues.get(innerSectionRow).rowValues.get(innerSectionColumn).possibleValues.size() == 1) {
                                            sudokuBoard.boardValues.get(innerSectionRow).rowValues.get(innerSectionColumn).setValue(sudokuBoard.boardValues
                                                    .get(innerSectionRow).rowValues.get(innerSectionColumn).possibleValues.get(0));

                                        } else if(innerRowIndexer != innerSectionRow && innerColumnIndexer != innerSectionColumn &&
                                                !sudokuBoard.boardValues.get(innerSectionRow).rowValues.get(innerSectionColumn)
                                                        .possibleValues.contains(index)
                                                &&  index != sudokuBoard.boardValues.get(innerSectionRow).rowValues.get(innerSectionColumn)
                                                .getValue()) {
                                            sudokuBoard.boardValues.get(innerSectionRow).rowValues.get(innerSectionColumn).setValue(index);
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
*/
    public SudokuBoard insertValues() throws IllegalInputValueException {
        userService = new UserService();
        boolean stillPrepare = true;
        boolean isSolved = true;
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
                while(isSolved) {
                    int emptyCells = cellCounter();
                            if(emptyCells >0) {
                                rowLoop();
                                //columnLoop();
                                //sectionLoop();
                            } else {
                                isSolved = false;
                    }
                    if(cellCounter()<emptyCells) {
                        isSolved = true;
                    } else {
                        isSolved = false;
                    }
                }
                stillPrepare = false;
            } else {
                stillPrepare = false;
            }
        }
        return sudokuBoard;
    }

    public int cellCounter() {
        int emptyCellCounter = 0;
        for (int row = 0; row < 9; row++) {
            for (int column = 0; column < 9; column++) {
                if(sudokuBoard.boardValues.get(row).rowValues.get(column).getValue() == -1) {
                    emptyCellCounter++;
                }
            }
        }
        return emptyCellCounter;
    }

}

