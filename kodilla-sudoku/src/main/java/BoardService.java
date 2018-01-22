import java.util.Scanner;

public class BoardService {

    private SudokuRow sudokuRow;
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

    public SudokuBoard insertValues() throws IllegalInputValueException {
        UserService userService = new UserService();
        boolean stillPrepare = true;
        while (stillPrepare) {
            if (userService.getMenu().name().equals("i")) {
                System.out.println("Type 3 digits in a row: row number, column number, value f.ex 123");
                userScanner = new Scanner(System.in);
                initialInput = userScanner.nextInt();
                sudokuBoard.boardValues.get(Integer.parseInt(String.valueOf(initialInput).substring(0, 1)) - 1)
                        .rowValues.get(Integer.parseInt(String.valueOf(initialInput).substring(1, 2)) - 1)
                        .setValue(Integer.parseInt(String.valueOf(initialInput).substring(2, 3)));
                sudokuBoard.boardValues.get(Integer.parseInt(String.valueOf(initialInput).substring(0, 1)) - 1)
                        .rowValues.get(Integer.parseInt(String.valueOf(initialInput).substring(1, 2)) - 1)
                        .possibleValues.clear();
            } else {
                stillPrepare = false;
            }
        }
        return sudokuBoard;
    }

    public void rowLoop() {
        for (int row = 0; row < 1; row++) {
            System.out.println();
            for (int column = 0; column < 9; column++) {
                if (sudokuBoard.boardValues.get(row).rowValues.get(column).getValue() == -1) {
                    for (int possibleValueElement = 0; possibleValueElement < sudokuBoard.boardValues.get(row).rowValues
                            .get(column).possibleValues.size(); possibleValueElement++) {
                        if (sudokuBoard.boardValues.get(row).rowValues.get(column).possibleValues.size() > 1) {
                            for (int innerColumnLoop = 0; innerColumnLoop < 9; innerColumnLoop++) {
                                if(innerColumnLoop == column || sudokuBoard.boardValues.get(row).rowValues.get(innerColumnLoop).getValue()!=-1) {
                                    continue;
                                }
                              /*  System.out.println("Possible Value Element" + sudokuBoard.boardValues.get(row).rowValues.get(column).possibleValues
                                        .get(possibleValueElement));*/
                                for (int innerPossibleElement = 0; innerPossibleElement < sudokuBoard.boardValues
                                        .get(row).rowValues.get(innerColumnLoop).possibleValues.size(); innerPossibleElement++) {

                                    /*System.out.println("Value from column " + innerColumnLoop + " " + sudokuBoard.boardValues.get(row).rowValues
                                            .get(innerColumnLoop).getValue());*/
                                    if (sudokuBoard.boardValues.get(row).rowValues.get(column).possibleValues
                                            .get(possibleValueElement) == sudokuBoard.boardValues.get(row).rowValues
                                            .get(innerColumnLoop).getValue()) {
                                        sudokuBoard.boardValues.get(row).rowValues.get(column).possibleValues
                                                .remove(sudokuBoard.boardValues.get(row).rowValues
                                                        .get(sudokuBoard.boardValues.get(row).rowValues.indexOf(innerColumnLoop)).getValue());
                                    } /*else if (sudokuBoard.boardValues.get(row).rowValues.get(column).possibleValues
                                            .get(possibleValueElement) != sudokuBoard.boardValues.get(row).rowValues
                                            .get(innerColumnLoop).possibleValues.get(innerPossibleElement)) {
                                        sudokuBoard.boardValues.get(row).rowValues.get(column).setValue(sudokuBoard.boardValues.get(row)
                                                .rowValues.get(column).possibleValues.get(possibleValueElement));
                                    }*/
                                }

                            }
                        } else if (sudokuBoard.boardValues.get(row).rowValues.get(column).possibleValues.size() == 1) {
                            sudokuBoard.boardValues.get(row).rowValues.get(column).setValue(sudokuBoard.boardValues
                                    .get(row).rowValues.get(column).possibleValues.get(0));
                        }
                    }
                }
            }
        }
    }
}

