package org.example;

import java.util.function.Supplier;


class SingletonClass {

    private static SingletonClass instance;

    private SingletonClass() {
        // Constructor privado para evitar instanciación directa
    }

    public static SingletonClass getInstance() {
        if (instance == null) {
            instance = new SingletonClass();
        }
        return instance;
    }

}

public class SingletonTest {
    @Test
    public void testSingletonInstance() {
        SingletonClass instance1 = SingletonClass.getInstance();
        SingletonClass instance2 = SingletonClass.getInstance();

        // Comprobar que ambas instancias sean la misma referencia
        assertSame(instance1, instance2);
    }
}

public class Main {

    public static boolean isSingleton(Supplier<Object> func) {
        System.out.println(func.get());
        return func.get() == func.get();
    }
    public static void main(String[] args) {
        Object obj = new Object();
        isSingleton(() -> obj);
    }
}