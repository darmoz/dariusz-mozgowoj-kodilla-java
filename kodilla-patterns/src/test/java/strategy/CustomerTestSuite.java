package strategy;

import org.junit.Assert;
import org.junit.Test;

public class CustomerTestSuite {
    @Test
    public void testDefaultInvestingStrategy() {
        //given
        Customer john = new IndividualCustomer("John Smith");
        Customer edi = new IndividualYoungCustomer("Edi Moore");
        Customer billy = new CorporateCustomer("Billy String");
        //when
        String johnPredict = john.predict();
        System.out.println(johnPredict);
        String ediPredict = edi.predict();
        System.out.println(ediPredict);
        String billyPredict = billy.predict();
        System.out.println(billyPredict);
        //then
        Assert.assertEquals("[Conservative Predictor] Buy debentures of XYZ",johnPredict);
        Assert.assertEquals("[Aggressive predictor] Buy stock of XYZ",ediPredict);
        Assert.assertEquals("[Balanced predictor] Buy shared units of Fund XYZ",billyPredict);
    }

    @Test
    public void testIndividualInvestingStrategy() {
        //given
        Customer frank = new IndividualCustomer("Frank Ozy");
        System.out.println(frank.predict());
        //when
        frank.setBuyingPredictor(new AggressivePredictor());
        String frankPredict = frank.predict();
        System.out.println(frankPredict);
        //then
        Assert.assertEquals("[Aggressive predictor] Buy stock of XYZ", frankPredict);
    }
}
