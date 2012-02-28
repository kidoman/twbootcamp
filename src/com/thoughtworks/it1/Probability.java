package com.thoughtworks.it1;

/* Chance of an event happening */
public class Probability {
    public static final Probability Certainty = new Probability(1.0);
    public static final Probability Never = new Probability(0.0);
    
    private final double value;

    public Probability(double value) {
        this.value = value;
    }

    public Probability not() {
        return new Probability(1.0 - value);
    }

    public Probability and(Probability probability) {
        return new Probability(value * probability.value);
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) return true;
        if (object == null) return false;
        if (object instanceof Probability)
            return value == ((Probability)object).value;
        return false;
    }
}
