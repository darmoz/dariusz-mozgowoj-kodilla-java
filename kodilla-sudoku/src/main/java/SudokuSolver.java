public class SudokuSolver {

    public static void main(String[] args) {
        /*boolean gameFinished = false;
        SudokuGame game = new SudokuGame();
        gameFinished = game.resolveSudoku();*/

        BoardService boardService = new BoardService();
        SudokuBoard workingBoard = boardService.printInitBoard();
        try {
            boardService.insertValues();
        } catch (IllegalInputValueException e) {
            e.printStackTrace();
        }
        boardService.rowLoop();
        boardService.printBoard();
        System.out.println("\n" + workingBoard.boardValues.get(0).rowValues.get(0).getValue());
        System.out.println("\n" + workingBoard.boardValues.get(0).rowValues.get(0).possibleValues);
        System.out.println("\n" + workingBoard.boardValues.get(0).rowValues.get(2).possibleValues);
        workingBoard.boardValues.get(0).rowValues.get(2).possibleValues.remove(workingBoard.boardValues.get(0).rowValues.get(0).getValue());
        System.out.println("\n" + workingBoard.boardValues.get(0).rowValues.get(2).possibleValues);
        /*SudokuElement element = new SudokuElement(SudokuElement.EMPTY);
        System.out.println("\n\n" + element.possibleValues);
        System.out.println(workingBoard.boardValues.get(1).rowValues.get(1).possibleValues);*/

    }
}
