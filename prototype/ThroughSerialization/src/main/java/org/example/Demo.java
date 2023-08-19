package org.example;

//import com.sun.xml.internal.ws.developer.Serialization;
//import org.apache.commons.lang3.SerializationUtils;

import org.apache.commons.lang3.SerializationUtils;

import java.io.Serializable;

class Foo implements Serializable {
    public int Stuff;
    public String whatever;

    public Foo(int stuff, String whatever) {
        Stuff = stuff;
        this.whatever = whatever;
    }

    @Override
    public String toString() {
        return "Foo{" +
                "Stuff=" + Stuff +
                ", whatever='" + whatever + '\'' +
                '}';
    }
}

public class Demo {
    public static void main(String[] args) {
        Foo foo = new Foo(42, "Life");
        Foo foo2 = SerializationUtils.roundtrip(foo);

        foo2.whatever = "xyz";
        System.out.println(foo);
        System.out.println(foo2);
    }
}
