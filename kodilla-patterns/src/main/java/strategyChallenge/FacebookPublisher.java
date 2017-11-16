package strategyChallenge;

public class FacebookPublisher implements SocialPublisher {
    @Override
    public String share() {
        return "[Facebook] press *I like it*";
    }
}
