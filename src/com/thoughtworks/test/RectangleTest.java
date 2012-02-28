package com.thoughtworks.test;

import com.thoughtworks.it1.Rectangle;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RectangleTest {
    @Test
    public void canProvideArea() {
        assertEquals(6, new Rectangle(3, 2).area());
    }
    
    @Test
    public void canProvideAreaForEqualsSides() {
        assertEquals(4, new Rectangle(2, 2).area());
    }
    
    @Test
    public void canProvidePerimeter() {
        assertEquals(10, new Rectangle(3, 2).perimeter());
    }
    
    @Test
    public void canProviderPerimeterForZeroRectangle() {
        assertEquals(0, new Rectangle(0, 0).perimeter());
    }
}
