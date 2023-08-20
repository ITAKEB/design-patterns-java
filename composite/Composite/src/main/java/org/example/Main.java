package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class GraphicObject {
    protected String name = "Group";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GraphicObject() {

    }

    public String color;
    public List<GraphicObject> children = new ArrayList<>();

    private void print(StringBuilder sb, int depth) {
        String indentation = String.join("", Collections.nCopies(depth, "*"));
        sb.append(String.join("", Collections.nCopies(depth, "*")))
                .append(depth > 0 ? " " : "")
                .append((color == null || color.isEmpty()) ? "" : color + " ")
                .append(getName())
                .append(System.lineSeparator());
        for (GraphicObject child : children) {
            child.print(sb, depth + 1);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        print(sb, 0);
        return sb.toString();
    }
}

class Circle extends GraphicObject {
    public Circle(String color) {
        name = "circle";
        this.color = color;
    }
}

class Square extends GraphicObject {
    public Square(String color) {
        name = "square";
        this.color = color;
    }
}


public class Main {
    public static void main(String[] args) {
        GraphicObject drawing = new GraphicObject();
        drawing.setName("My drawing");
        drawing.children.add(new Square("red"));
        drawing.children.add(new Square("yellow"));

        GraphicObject group = new GraphicObject();
        group.children.add(new Circle("blue"));
        group.children.add(new Square("blue"));
        //Composite here
        drawing.children.add(group);

        System.out.println(drawing);
    }
}