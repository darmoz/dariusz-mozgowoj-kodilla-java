package builderChallenge;

import java.util.ArrayList;
import java.util.List;

public final class BigMac {
    private final String roll;
    private final int burger;
    private final String sauce;
    private final List<String> ingredients;

    public static class BigMacBuilder {
        private String roll;
        private int burger;
        private String sauce;
        private List<String> ingredients = new ArrayList<>();

        public BigMacBuilder roll(String roll) {
            this.roll=roll;
            if(roll.equals("sesame")|| roll.equals("classic")) {
                return this;
            }
            throw new IllegalStateException("rolls options: sesame  or classic\n no other types are available");
        }

        public BigMacBuilder burger(int burger) {
            this.burger=burger;
            return this;
        }

        public BigMacBuilder sauce(String sauce) {
            this.sauce=sauce;
            if(sauce.equals("standard")||sauce.equals("1000 islands") || sauce.equals("barbecue")) {
                return this;
            }
            throw new IllegalStateException("sauce options: standard, 1000 island, barbecue\n no other types are available");
        }

        public BigMacBuilder ingredients(String ingredient) {
            ingredients.add(ingredient);
            if(ingredient.equals("salad")||ingredient.equals("bacon")||ingredient.equals("shrimps")
                    ||ingredient.equals("onion")||ingredient.equals("cucumber")||ingredient.equals("cheese")
                    ||ingredient.equals("chili")||ingredient.equals("mushrooms")) {
                return this;
            }
            throw new IllegalStateException("ingredients options: salad, bacon, shrimps, onion, cucumber," +
                    " cheese, chili, mushrooms");
        }

        public BigMac build() {
            return new BigMac(roll, burger, sauce, ingredients);
        }
    }

    private BigMac(final String roll, final int burger, final String sauce, final List<String> ingredients) {
        this.roll = roll;
        this.burger = burger;
        this.sauce = sauce;
        this.ingredients = ingredients;
    }

    public String getRoll() {
        return roll;
    }

    public int getBurger() {
        return burger;
    }

    public String getSauce() {
        return sauce;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    @Override
    public String toString() {
        return "BigMac{" +
                "roll='" + roll + '\'' +
                ", burger=" + burger +
                ", sauce='" + sauce + '\'' +
                ", ingredients=" + ingredients +
                '}';
    }
}
