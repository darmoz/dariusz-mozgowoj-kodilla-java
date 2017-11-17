package builderChallenge;

import org.junit.Assert;
import org.junit.Test;

public class BigMacBuilderTestSuite {
    @Test
    public void testBigMacBuilder() {
        //given
        BigMac bigMac = new BigMac.BigMacBuilder()
                .roll("sesame")
                .burger(2)
                .sauce("standard")
                .ingredients("cheese")
                .ingredients("salad")
                .ingredients("chili")
                .build();
        System.out.println(bigMac);
        //when
        int howManyIngredients = bigMac.getIngredients().size();
        int howManyBurgers = bigMac.getBurger();
        //then
        Assert.assertEquals(3, howManyIngredients);
        Assert.assertEquals(2, howManyBurgers);
    }
}
