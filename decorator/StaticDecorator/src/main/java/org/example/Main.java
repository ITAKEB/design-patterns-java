package org.example;

import java.util.function.Supplier;

interface Shape {
    String info();
}

class Circle implements Shape {
    private float radius;

    public Circle() {

    }

    public Circle(float radius) {
        this.radius = radius;
    }

    void resize(float factor) {
        radius *= factor;
    }

    @Override
    public String info() {
        return "A circle of radius " + radius;
    }
}

class Square implements Shape {
    private float side;

    public Square() {

    }

    public Square(float side) {
        this.side = side;
    }


    @Override
    public String info() {
        return "A square of side " + side;
    }
}

class ColoredShape<T extends Shape> implements Shape {
    private Shape shape;
    private String color;

    public ColoredShape(Supplier<? extends T> constructor, String color) {
        this.color = color;
        shape = constructor.get();
    }

    @Override
    public String info() {
        return shape.info() + " has the color " + color;
    }
}

class TransparetShape<T extends Shape> implements Shape {
    private Shape shape;
    private int transparency;

    public TransparetShape(Supplier<? extends T> constructor, int transparency) {
        shape = constructor.get();
        this.transparency = transparency;
    }

    @Override
    public String info() {
        return shape.info() + " has " + transparency + "% transparency";
    }
}

public class Main {
    public static void main(String[] args) {
        ColoredShape<Square> blueSquare = new ColoredShape<>(
                () -> new Square(20), "blue");
        System.out.println(blueSquare.info());
        TransparetShape<ColoredShape<Circle>> myCircle =
                new TransparetShape<>(() ->
                        new ColoredShape<>(() ->
                                new Circle(5), "green"), 50);
        System.out.println(myCircle.info());
    }
}