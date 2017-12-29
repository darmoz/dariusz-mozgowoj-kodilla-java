import java.util.Scanner;

public class User implements  GameObject{

    private Scanner userScanner;
    private int result = 0;

    public User() {
        userScanner = new Scanner(System.in);
    }

    public int getGameObject() {
        System.out.println("\nChoose -> Rock: 1, Paper: 2 or Scissors: 3");
        System.out.println("New Game: n,  Exit Game: x");
        String userInput = userScanner.nextLine();
            // User has entered a valid input
            switch (userInput) {
                case "1":
                    System.out.println("You play with Rock");
                    return 0;
                case "2":
                    System.out.println("You play with Paper");
                    return 1;
                case "3":
                    System.out.println("You play with Scissors");
                    return 2;
                case "n":
                    System.out.println("You have started new game!");
                    return 3;
                case "x":
                    System.out.println("End of the game!");
                    return 4;
            }

        return getGameObject();
    }

}
