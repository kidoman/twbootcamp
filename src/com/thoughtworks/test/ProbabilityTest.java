package com.thoughtworks.test;

import com.thoughtworks.it1.Probability;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ProbabilityTest {
    @Test
    public void canProvideInverseProbability() {
        assertEquals(new Probability(0.4), p(0.6).not());
    }
    
    @Test
    public void canProviderInverseOfACertainCondition() {
        assertEquals(Probability.Never, Probability.Certainty.not());
    }
    
    @Test
    public void canProvideAndProbability() {
        assertEquals(p(0.06), p(0.2).and(p(0.3)));
    }

    @Test
    public void canProviderProbabilityOfACertainConditionAndAConditionWhichWouldNeverOccur() {
        assertEquals(Probability.Never, Probability.Certainty.and(Probability.Never));
    }

    private Probability p(double value) {
        return new Probability(value);
    }
}
