package org.example;


enum EnumBasedSingleton {
    INSTANCE,
    INSTANCE2(12);

    EnumBasedSingleton() {
        this.value = 42;
    }

    EnumBasedSingleton(int value) {
            this.value = value;
    }

    private int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}


public class Main {
    public static void main(String[] args) {
        EnumBasedSingleton en = EnumBasedSingleton.INSTANCE;
        en.setValue(52);
        EnumBasedSingleton en2 = EnumBasedSingleton.INSTANCE2;

        System.out.println(en2.getValue());
    }
}