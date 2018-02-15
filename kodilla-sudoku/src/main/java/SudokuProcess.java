public class SudokuProcess {

    private SudokuBoard workingBoard;

    public SudokuBoard processSudoku() {
        BoardService boardService = new BoardService();
        workingBoard = boardService.printInitBoard();
        try {
            boardService.insertValues();
        } catch (IllegalInputValueException e) {
            e.printStackTrace();
        };
        boardService.printBoard();
        return workingBoard;
    }
}
