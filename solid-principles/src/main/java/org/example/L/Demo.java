package org.example.L;

class Rectangle {
    protected int width, height;

    public Rectangle() {

    }

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }


    public void setHeight(int height) {
        this.height = height;
    }

    public int getArea() {
        return width*height;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "width=" + width +
                ", height=" + height +
                '}';
    }

    public boolean isSquare(){
        return width == height;
    }
}

class Square extends Rectangle{
    public Square (){

    }

    public Square (int size){
        width = height = size;
    }

    //This violates the principle
    @Override
    public void setWidth(int width) {
        super.setWidth(width);
        super.setHeight(width);
    }

    //This violates the principle
    @Override
    public void setHeight(int height) {
        super.setHeight(height);
        super.setWidth(height);
    }

}

class RectangleFactory{
    public static Rectangle newRectangle(int width, int height){
        return new Rectangle(width, height);
    }

    public static Rectangle newSquare(int side){
        return new Rectangle(side, side);
    }
}

public class Demo {
    static void userIt(Rectangle r){
        int width = r.getWidth();
        r.setHeight(10);
        //area = width * 10;
        System.out.println("Expected an area of " + (width * 10) + ", got "+ r.getArea());
    }

    public static void main(String[] args) {
        Rectangle rc = new Rectangle(2, 3);
        userIt(rc);

        Rectangle sq = new Square();
        sq.setWidth(5);
        userIt(sq);
    }
}
