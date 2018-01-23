import java.util.List;
import java.util.Scanner;

public class UserService implements SudokuMenu {

    private Scanner userScanner;


    @Override
    public SudokuMenuObject getMenu() throws IllegalInputValueException {
        System.out.println("\nInput initial values: i, Find solution: f, New Game: n,  Exit Game: x");
        userScanner = new Scanner(System.in);
        String userMenu = userScanner.nextLine();
        for (SudokuMenuObject i : SudokuMenuObject.values()) {
            if (userMenu.matches(i.name())) {
                System.out.println("Option " + i.name() + " has been selected");
                return i;
            }
        }
        throw new IllegalInputValueException("You have typed illegal input value! Please try again.");
    }


}
