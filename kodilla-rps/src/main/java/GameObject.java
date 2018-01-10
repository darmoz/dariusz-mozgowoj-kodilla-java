import exceptions.IllegalInputValueException;

import java.util.HashMap;
import java.util.Map;

public interface GameObject {

    GameObjectValue  getGameObject() throws IllegalInputValueException;

    enum GameObjectValue {
        DOG(0),
        SKELETON(1),
        KNIGHT(2),
        DRAGON(3),
        MAGICIAN(4),
        NEW_GAME(5),
        EXIT_GAME(6);

        private int value;
        private static Map map = new HashMap<>();

        GameObjectValue (int value) {
            this.value = value;
        }

        public static GameObjectValue valueOf(int gameObjectValue) {
            return (GameObjectValue) map.get(gameObjectValue);
        }

        public int getObjectValue() {
            return value;
        }
    }
}

