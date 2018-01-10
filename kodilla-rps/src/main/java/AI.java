import java.util.Random;

public class AI implements GameObject {

    public GameObjectValue getGameObject() {
        Random random = new Random();
        int AIget = random.nextInt(2);
        if(AIget == 0) {
            System.out.println("AI play with Dog");
            return GameObjectValue.DOG;
        } else if( AIget == 1) {
            System.out.println("AI play with Skeleton");
            return GameObjectValue.SKELETON;
        } else if( AIget == 2) {
            System.out.println("AI play with Knight");
            return GameObjectValue.KNIGHT;
        } else if( AIget == 3) {
            System.out.println("AI play with Dragon");
            return GameObjectValue.DRAGON;
        } else {
            System.out.println("AI play with Magician");
            return GameObjectValue.MAGICIAN;
        }
    }

    public void forUserGameCancellation() {
        System.out.println("AI: Thank you for the game!");
    }
}
