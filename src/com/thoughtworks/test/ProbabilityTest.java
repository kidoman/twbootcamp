package com.thoughtworks.test;

import com.thoughtworks.core.Probability;
import org.junit.Test;

import static org.junit.Assert.*;

public class ProbabilityTest {
    @Test(expected = IllegalArgumentException.class)
    public void probabilityCannotBeNegative() {
        p(-0.1);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void probabilityCannotExceedUnity() {
        p(1.1);
    }
    
    @Test
    public void canProvideInverseProbability() {
        assertEquals(new Probability(0.4), p(0.6).not());
    }
    
    @Test
    public void canProviderInverseOfACertainCondition() {
        assertEquals(Probability.Never, Probability.Certainty.not());
    }
    
    @Test
    public void canProvideProbabilityOfTwoMutuallyExclusiveEventsOccuringTogether() {
        assertEquals(p(0.06), p(0.2).and(p(0.3)));
    }

    @Test
    public void canProvideProbabilityOfACertainEventAndANeverEventOccuringTogether() {
        assertEquals(Probability.Never, Probability.Certainty.and(Probability.Never));
    }
    
    @Test
    public void probabilityIsNotNull() {
        assertFalse(p(0.1).equals(null));
    }
    
    @Test
    public void probabilityIsNotAnObject() {
        assertFalse(p(0.1).equals(new Object()));
    }
    
    @Test
    public void probabilityEqualsSelf() {
        Probability p = p(0.1);
        
        assertEquals(p, p);
    }

    @Test
    public void twoEventsWithEqualChancesOfOccuranceAreEqual() {
        assertEquals(p(0.1), p(0.1));
    }
    
    @Test
    public void twoEventsWithDifferentChancesOfOccuranceAreNotEquallyProbable() {
        assertFalse(p(0.1).equals(p(0.2)));
    }

    @Test
    public void canProvideProbabilityOfEitherEventOccurring(){
        assertEquals(p(0.52), p(0.4).or(p(0.2)));
    }

    private Probability p(double value) {
        return new Probability(value);
    }
}
