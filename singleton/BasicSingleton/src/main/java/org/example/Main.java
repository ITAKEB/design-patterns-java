package org.example;

import java.io.*;

class BasicSingleton implements Serializable {
    private BasicSingleton() {

    }

    private static final BasicSingleton INSTANCE = new BasicSingleton();

    public static BasicSingleton getInstance() {
        return INSTANCE;
    }

    private int value = 0;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    protected Object readResolve(){
        return INSTANCE;
    }
}

public class Main {

    static void saveToFile(BasicSingleton singleton, String fileName) throws Exception {
        try (FileOutputStream fileOutputStream = new FileOutputStream(fileName);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.write(singleton.getValue());
        }
    }

    static BasicSingleton readFromFile(String filename) throws Exception {
        try (FileInputStream fileIn = new FileInputStream(filename);
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
            return (BasicSingleton) in.readObject();
        }
    }

    public static void main(String[] args) throws Exception{
        //Problems
        //1. reflection
        //2. serialization

        BasicSingleton singleton = BasicSingleton.getInstance();
        singleton.setValue(111);

        String fileName = "singleton.bin";
        saveToFile(singleton, fileName);
        singleton.setValue(222);

        BasicSingleton singleton2 = readFromFile(fileName);

        System.out.println(singleton2 == singleton);

        System.out.println(singleton.getValue());
        System.out.println(singleton2.getValue());
    }
}