import exceptions.IllegalInputValueException;

import java.util.HashMap;
import java.util.Map;

public interface GameObject {

    GameObjectValue getAvatar() throws IllegalInputValueException;

   enum GameObjectValue {
        DOG(1),
        SKELETON(2),
        KNIGHT(3),
        DRAGON(4),
        MAGICIAN(5),
        N(8),
        X(9);

        private int value;
        private static Map map = new HashMap<>();

        static {
            for (GameObjectValue gameObjectValue : GameObjectValue.values()) {
                map.put(gameObjectValue.value, gameObjectValue);
            }
        }

        GameObjectValue(int value) {
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

