package org.example;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;

class CodeBuilder {
    public ClassElement classElement;

    public CodeBuilder(String className) {
        // todo
        this.classElement = new ClassElement(className);
    }

    public CodeBuilder addField(String name, String type) {
        // todo
        classElement.elements.add(new FieldElement(name, type));
        return this;
    }

    @Override
    public String toString() {
        return classElement.toString();
    }

}

class FieldElement {
    public String name;
    public String type;

    public FieldElement(String name, String type) {
        this.name = name;
        this.type = type;
    }

    @Override
    public String toString() {
        // todo
        return String.format("public %s %s%s", this.type, this.name, ";");
    }
}

class ClassElement {
    public String name;

    public ClassElement(String name) {
        this.name = name;
    }

    private final int identSize = 2;
    private final String newLine = System.lineSeparator();
    public ArrayList<FieldElement> elements = new ArrayList<>();

    private String toStringImpl(int ident) {
        StringBuilder sb = new StringBuilder();
//        String indentation = String.join("", Collections.nCopies(ident * this.identSize, " "));
        sb.append(String.format("public class %s%s%s%s", this.name, this.newLine, "{", this.newLine));
        for (FieldElement element : this.elements)
            sb.append(String.format("  %s%s", element, this.newLine));
        sb.append("}");
        return sb.toString();
    }

    @Override
    public String toString() {
        // todo
        return toStringImpl(1);
    }
}

public class Main {
    public static void main(String[] args) {
        CodeBuilder cb = new CodeBuilder("Person")
                .addField("name", "String")
                .addField("age", "int");
        System.out.println(cb);
//        System.out.println("Hello world!");

    }
}