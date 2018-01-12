import exceptions.IllegalInputValueException;

import java.util.Scanner;

public class User implements  GameObject{

    GameObjectValue result;
    Scanner userScanner;

    public User() {
    }

     public GameObjectValue getAvatar() throws IllegalInputValueException {
            System.out.println("\nChoose -> Dog: 1, Skeleton: 2, Knight: 3, Dragon: 4 or Magician: 5");
            System.out.println("New Game: 8,  Exit Game: 9");
            userScanner = new Scanner(System.in);
            String userInput = userScanner.nextLine();
            for (GameObjectValue i : GameObjectValue.values()) {
                if (GameObjectValue.valueOf(Integer.parseInt(userInput)).name().equals(i.name())) {
                    System.out.println("You selected " + i.name());
                    result = i;
                }
            }
            return result;
        }
}
