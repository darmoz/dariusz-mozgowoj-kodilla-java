import java.util.Random;

public class AI implements GameObject {

    public int getGameObject() {
        Random random = new Random();
        int AIget = random.nextInt(2);
        if(AIget == 0) {
            System.out.println("AI play with Dog");
        } else if( AIget == 1) {
            System.out.println("AI play with Skeleton");
        } else if( AIget == 2) {
            System.out.println("AI play with Knight");
        } else if( AIget == 3) {
            System.out.println("AI play with Dragon");
        } else {
            System.out.println("AI play with Magician");
        }
        return AIget;
    }

    public void forUserGameCancellation() {
        System.out.println("AI: Thank you for the game!");
    }
}
