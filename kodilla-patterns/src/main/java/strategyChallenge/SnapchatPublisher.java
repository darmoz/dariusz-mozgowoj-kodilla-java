package strategyChallenge;

public class SnapchatPublisher implements SocialPublisher {
    @Override
    public String share() {
        return "[SnapChat] showing an event";
    }
}
