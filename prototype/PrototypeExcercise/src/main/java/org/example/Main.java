package org.example;

class Point {
    public int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point(Point other) {
        this(other.x, other.y);
    }

    protected Object clone() {
        return new Point(this.x, this.y);
    }
}

class Line {
    public Point start, end;

    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    public Line(Line other) {
        this(new Point(other.start), new Point(other.end));
    }


    public Line deepCopy() {
        return new Line((Point) this.start.clone(), (Point) this.end.clone());
    }

}


public class Main {
    public static void main(String[] args) {
        Point startPoint = new Point(4, 6);
        Point endPoint = new Point(4, 6);
        Line line = new Line(startPoint, endPoint);

        Line lineCopy = line.deepCopy();
        System.out.println(lineCopy);
    }
}