import java.util.Scanner;

public class User implements  GameObject{

    private Scanner userScanner;
    private int result = 0;

    public User() {
        userScanner = new Scanner(System.in);
    }

    public int getGameObject() {
        System.out.println("\nChoose -> Dog: 1, Skeleton: 2, Knight: 3, Dragon: 4 or Magician:5");
        System.out.println("New Game: n,  Exit Game: x");
        String userInput = userScanner.nextLine();
            // User has entered a valid input
            switch (userInput) {
                case "1":
                    System.out.println("You play with Dog");
                    return 0;
                case "2":
                    System.out.println("You play with Skeleton");
                    return 1;
                case "3":
                    System.out.println("You play with Knight");
                    return 2;
                case "4":
                    System.out.println("You play with Dragon");
                    return 3;
                case "5":
                    System.out.println("You play with Magician");
                    return 4;
                case "n":
                    System.out.println("You have started new game!");
                    return 5;
                case "x":
                    System.out.println("End of the game!");
                    return 6;
            }

        return getGameObject();
    }

}
