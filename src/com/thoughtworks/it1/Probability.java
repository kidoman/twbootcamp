package com.thoughtworks.it1;

/* Chance of an event happening */
public class Probability {
    private static final double CERTAIN_PROBABILITY = 1.0;
    private static final double NO_PROBABILITY = 0.0;

    public static final Probability Certainty = new Probability(CERTAIN_PROBABILITY);
    public static final Probability Never = new Probability(NO_PROBABILITY);

    private final double value;

    public Probability(double value) throws ArithmeticException {
        if (value < 0 || value > 1)
            throw new ArithmeticException("Probability value cannot be < 0 or > 1");

        this.value = value;
    }

    public Probability not() {
        return new Probability(CERTAIN_PROBABILITY - value);
    }

    public Probability and(Probability probability) {
        return new Probability(value * probability.value);
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) return true;
        if (object == null) return false;
        if (object instanceof Probability)
            return value == ((Probability) object).value;
        return false;
    }
}
