package org.example;

class Square {
    public  int side;

    public Square(int side) {
        this.side = side;
    }
}

interface Rectangle{
    int getWidth();
    int getHeight();

    default int getArea(){
        return getHeight() * getWidth();
    }
}

class SquareToRectangleAdapter implements Rectangle{
    private Square square;

    public SquareToRectangleAdapter(Square square){
        this.square = square;
    }
    @Override
    public int getWidth() {
        return this.square.side;
    }

    @Override
    public int getHeight() {
        return this.square.side;
    }
}


public class Main {
    public static void main(String[] args) {


    }
}