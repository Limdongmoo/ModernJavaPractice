package Practice1;

import static java.awt.Color.GREEN;

public class AppleColorPredicate implements ApplePredicate{

    @Override
    public boolean test(Apple apple) {
        return GREEN.equals(apple.getColor());
    }
}
