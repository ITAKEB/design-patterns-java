package org.example;

import java.util.ArrayList;
import java.util.List;


class Field {
    public String type, name;

    public Field(String name, String type) {
        this.type = type;
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("public %s %s;", type, name);
    }
}

class Class {
    public String name;
    public List<Field> fields = new ArrayList<>();

    public Class() {
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        String newLine = System.lineSeparator();
        sb.append("public class " + name)
                .append(newLine)
                .append("{")
                .append(newLine);

        for (Field f : fields)
            sb.append("  " + f).append(newLine);

        sb.append("}").append(newLine);
        return sb.toString();
    }
}

class CodeBuilderSolution {
    private Class theClass = new Class();

    public CodeBuilderSolution(String rootName) {
        theClass.name = rootName;
    }

    public CodeBuilderSolution addField(String name, String type) {
        theClass.fields.add(new Field(name, type));
        return this;
    }

    @Override
    public String toString() {
        return theClass.toString();
    }
}


public class Solution {
    public static void main(String[] args) {

    }
}

//import org.junit.Test;
//import org.junit.Assert;
//import com.udemy.ucp.*;


