package MethodReference;

import java.util.Locale;

public class Lemon {
    private Integer weight;
    private Locale.IsoCountryCode Country;

    public Lemon(int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Locale.IsoCountryCode getCountry() {
        return Country;
    }

    public void setCountry(Locale.IsoCountryCode country) {
        Country = country;
    }
}
