import java.util.Random;

public class AI implements GameObject {

    public int getGameObject() {
        Random random = new Random();
        int AIget = random.nextInt(2);
        if(AIget == 0) {
            System.out.println("AI play with Rock");
        } else if( AIget == 1) {
            System.out.println("AI play with Paper");
        } else {
            System.out.println("AI play with Scissors");
        }
        return AIget;
    }

    public void forUserGameCancelation() {
        System.out.println("AI: Thank you for the game!");
    }
}
