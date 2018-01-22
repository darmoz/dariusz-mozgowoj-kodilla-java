import exceptions.IllegalInputValueException;

import java.util.Scanner;

public class User implements  GameObject{

    private Scanner userScanner;

    public User() {
    }

     public GameObjectValue getAvatar() throws IllegalInputValueException {
            System.out.println("\nChoose -> Dog: 1, Skeleton: 2, Knight: 3, Dragon: 4 or Magician: 5");
            System.out.println("New Game: n,  Exit Game: x");
            userScanner = new Scanner(System.in);
            String userInput = userScanner.nextLine();
            for (GameObjectValue i : GameObjectValue.values()) {
                if(userInput.matches(i.name())) {
                    System.out.println("Option " + i.name() + " has been selected");
                    return i;
                } else if(String.valueOf(i.ordinal()+1).equals(userInput)) {
                    System.out.println("You selected " + i.name());
                    return i;
                }
            }
            throw new IllegalInputValueException("You have typed illegal input value! Please try again.");
        }
}
