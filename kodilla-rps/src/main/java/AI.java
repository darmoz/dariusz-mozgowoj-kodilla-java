import java.util.Random;

public class AI implements GameObject {

    GameObjectValue result;

    public GameObjectValue getAvatar() {
        Random random = new Random();
        int AIget = random.nextInt(5);
        for (GameObjectValue i : GameObjectValue.values()) {
            if (GameObjectValue.valueOf(AIget).name().equals(i.name())) {
                System.out.println("AI selected " + i.name());
                result = i;
            }
        }
        return result;
    }

    public void forUserGameCancellation() {
        System.out.println("AI: Thank you for the game!");
    }
}
