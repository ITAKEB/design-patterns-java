package org.example;

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

class Square implements Shape{
    private float side;

    public Square(){

    }

    public Square(float side){
        this.side = side;
    }


    @Override
    public String info() {
        return "A square of side " + side;
    }
}

class ColorShape implements Shape{
    private Shape shape;
    private String color;

    public ColorShape(Shape shape, String color){
        this.shape = shape;
        this.color = color;
    }

    @Override
    public String info() {
        return shape.info() + " has "
                + color + " color";
    }
}

class TransparentShape implements Shape{
    private Shape shape;
    private int transparency;

    public TransparentShape(Shape shape, int transparency){
        this.shape = shape;
        this.transparency = transparency;
    }


    @Override
    public String info() {
        return shape.info() + " has "
                + transparency + "% transparency";
    }
}

public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle(10);
        System.out.println(circle.info());
        ColorShape blueSquare = new ColorShape(new Square(20), "blue");
        System.out.println(blueSquare.info());
        TransparentShape myCircle = new TransparentShape(
                new ColorShape(new Circle(50), "green"),
                5);;
        System.out.println(myCircle.info());
    }
}