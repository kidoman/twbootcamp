package com.thoughtworks.core;

/* Chance of an event happening */
public class Probability {
    private static final double CERTAIN_PROBABILITY = 1.0;
    private static final double IMPOSSIBLE_PROBABILITY = 0.0;

    public static final Probability Certainty = new Probability(CERTAIN_PROBABILITY);
    public static final Probability Never = new Probability(IMPOSSIBLE_PROBABILITY);

    private final double value;

    public Probability(double value) throws ArithmeticException {
        if (value < 0 || value > 1)
            throw new IllegalArgumentException("Probability value cannot be < 0 or > 1. Got " + value);

        this.value = value;
    }

    public Probability not() {
        return new Probability(CERTAIN_PROBABILITY - value);
    }

    public Probability and(Probability another) {
        return new Probability(value * another.value);
    }

    public Probability or(Probability other) {
        return not().and(other.not()).not();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) return true;
        if (other == null) return false;
        if (other instanceof Probability)
            return value == ((Probability) other).value;
        return false;
    }

}
