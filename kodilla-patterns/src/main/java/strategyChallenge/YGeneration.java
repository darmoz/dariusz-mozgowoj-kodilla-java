package strategyChallenge;

public class YGeneration extends User {

    public YGeneration(String name) {
        super(name);
        this.socialPublisher = new FacebookPublisher();
    }
}
