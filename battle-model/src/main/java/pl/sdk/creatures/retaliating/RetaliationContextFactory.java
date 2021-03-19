package pl.sdk.creatures.retaliating;

public class RetaliationContextFactory {

    public static RetaliationContextIf create(int retaliateInRoundCounter) {
        return new DefaultRetaliationContext(1);
    }
}
