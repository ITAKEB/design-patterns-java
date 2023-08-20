package org.example;

abstract class Shape{
    protected Renderer renderer;
    public Shape(Renderer renderer) {
        this.renderer = renderer;
    }
    public abstract String getName();

    @Override
    public String toString() {
        return String.format("Drawing %s as %s", getName(), renderer.whatToRenderAs());
    }
}

class Triangle extends Shape{
    public Triangle(Renderer renderer) {
        super(renderer);
    }

    @Override
    public String getName() {
        return "Triangle";
    }

}

class Square extends Shape{
    public Square(Renderer renderer) {
        super(renderer);
    }

    @Override
    public String getName() {
        return "Square";
    }
}

class VectorRenderer implements Renderer{
    @Override
    public String whatToRenderAs() {
        return "lines";
    }
}

class RasterRenderer implements Renderer{
    @Override
    public String whatToRenderAs() {
        return "pixels";
    }
}

interface Renderer{
    String whatToRenderAs();
}

public class Main {
    public static void main(String[] args) {
        VectorRenderer vector = new VectorRenderer();
        RasterRenderer raster = new RasterRenderer();
        Triangle triangle = new Triangle(raster);
        Square square = new Square(vector);
        System.out.println(triangle);
        System.out.println(square);
    }
}