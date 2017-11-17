package builder;

import org.junit.Assert;
import org.junit.Test;

public class PizzaBuilderTestSuite {
    @Test
    public void testPizzaBuild() {
        //given
        Pizza pizza = new Pizza.PizzaBuilder()
                .bottom("classic")
                .sauce("hot")
                .ingredients("cheese")
                .ingredients("ham")
                .ingredients("tomato")
                .build();
        System.out.println(pizza);
        //when
        int howManyIngredients = pizza.getIngredients().size();
        //then
        Assert.assertEquals(3, howManyIngredients);
    }
}
