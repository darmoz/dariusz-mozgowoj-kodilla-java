package strategyChallenge;

import org.junit.Assert;
import org.junit.Test;

public class UserTestSuite {

    @Test
    public void testDefaultUserPreferences() {
        //given
        User john = new Millenials("John Smith");
        User edi = new YGeneration("Edi Moore");
        User billy = new ZGeneration("Billy Ozy");
        //when
        String johnPublisher = john.sharePost();
        System.out.println(johnPublisher);
        String ediPublisher = edi.sharePost();
        System.out.println(ediPublisher);
        String billyPublisher = billy.sharePost();
        System.out.println(billyPublisher);
        //then
        Assert.assertEquals("[Twitter] tweet about something new", johnPublisher);
        Assert.assertEquals("[Facebook] press *I like it*", ediPublisher);
        Assert.assertEquals("[SnapChat] showing an event", billyPublisher);
    }

    @Test
    public void testIndividualUserPublisher() {
        //given
        User molly = new Millenials("Molly Olly");
        System.out.println("Molly: before changing publisher - ");
        System.out.println(molly.sharePost());
        //when
        molly.setIndividualPublisher(new FacebookPublisher());
        String mollyPublisher = molly.sharePost();
        System.out.println("Molly: after changing publisher - ");
        System.out.println(mollyPublisher);
        //then
        Assert.assertEquals("[Facebook] press *I like it*", mollyPublisher);
    }
}
