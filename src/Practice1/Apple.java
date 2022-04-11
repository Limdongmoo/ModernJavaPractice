package Practice1;

import java.awt.*;

public class Apple {
    private Color color;
    private Integer weight;

    public Apple(int weight, Color color) {
        this.color = color;
        this.weight = weight;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
