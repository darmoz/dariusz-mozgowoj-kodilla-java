package strategy;

public class ConservativePredictor implements BuyPredictor{
    @Override
    public String predictWhatToBuy() {
        return "[Conservative Predictor] Buy debentures of XYZ";
    }
}
