
import java.util.HashMap;
import java.util.Map;

public interface SudokuMenu {

    SudokuMenuObject getMenu() throws IllegalInputValueException;

    enum SudokuMenuObject {
        i(1),
        f(2),
        n(3),
        x(4);

        private int value;
        private static Map map = new HashMap<>();

        static {
            for (SudokuMenuObject menuObject : SudokuMenuObject.values()) {
                map.put(menuObject.value, menuObject);
            }
        }

        SudokuMenuObject(int value) {
            this.value = value;
        }

        public static SudokuMenuObject valueOf(int menuObject) {
            return (SudokuMenuObject) map.get(menuObject);
        }

        public int getObjectValue() {
            return value;
        }
    }
}

