package strategyChallenge;

public class TwitterPublisher implements SocialPublisher {
    @Override
    public String share() {
        return "[Twitter] tweet about something new";
    }
}
