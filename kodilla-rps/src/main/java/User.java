import exceptions.IllegalInputValueException;

import java.util.Scanner;

public class User implements  GameObject{

    private Scanner userScanner;

    public User() {
        userScanner = new Scanner(System.in);
    }

    public GameObjectValue getGameObject() throws IllegalInputValueException {
        System.out.println("\nChoose -> Dog: 1, Skeleton: 2, Knight: 3, Dragon: 4 or Magician: 5");
        System.out.println("New Game: n,  Exit Game: x");
        String userInput = userScanner.nextLine();
            switch (userInput) {
                case "1":
                    System.out.println("You play with Dog");
                    return GameObjectValue.DOG;
                case "2":
                    System.out.println("You play with Skeleton");
                    return GameObjectValue.SKELETON;
                case "3":
                    System.out.println("You play with Knight");
                    return GameObjectValue.KNIGHT;
                case "4":
                    System.out.println("You play with Dragon");
                    return GameObjectValue.DRAGON;
                case "5":
                    System.out.println("You play with Magician");
                    return GameObjectValue.MAGICIAN;
                case "n":
                    System.out.println("You have started new game!");
                    return GameObjectValue.NEW_GAME;
                case "x":
                    System.out.println("End of the game!");
                    return GameObjectValue.EXIT_GAME;
                default:
                    throw new IllegalInputValueException("You can use only values from 1 to 6, n and x");
            }
    }
}
