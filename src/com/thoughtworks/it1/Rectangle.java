package com.thoughtworks.it1;

/* Understands a 4 sided polygon with adjacent sides perpendicular to each other */
public class Rectangle {

    private int length;
    private int breadth;

    public Rectangle(int length, int breadth) {

        this.length = length;
        this.breadth = breadth;
    }

    public int area() {
        return length * breadth;
    }

    public int perimeter() {
        return (length + breadth) * 2;
    }
}
