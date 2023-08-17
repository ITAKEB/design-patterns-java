package org.example;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;


class HtmlElement {
    public String name, text;
    public ArrayList<HtmlElement> elements = new ArrayList<>();
    private final int idendtSize = 2;
    private final String newLine = System.lineSeparator();

    public HtmlElement() {
    }

    public HtmlElement(String name, String text) {
        this.name = name;
        this.text = text;
    }

    private String toStringImpl(int ident) {
        StringBuilder sb = new StringBuilder();
        String indentation = String.join("", Collections.nCopies(ident * this.idendtSize, " "));
        sb.append(String.format("%s<%s>%s", indentation, name, newLine));
        if (text != null && !text.isEmpty()) {
            sb.append(String.join("", Collections.nCopies(this.idendtSize * (ident + 1), " ")))
                    .append(text)
                    .append(newLine);
        }
        for (HtmlElement e : elements) {
            sb.append(e.toStringImpl(ident + 1));
        }
        sb.append(String.format("%s</%s>%s", indentation, this.name, this.newLine));
        return sb.toString();
    }

    @Override
    public String toString() {
        return toStringImpl(0);
    }
}

class HtmlBuilder {
    private String rootName;
    private HtmlElement root = new HtmlElement();

    public HtmlBuilder(String rootName) {
        this.rootName = rootName;
        root.name = rootName;
    }

    //Fluent Builder
    public HtmlBuilder addChild(String childName, String childText) {
        HtmlElement e = new HtmlElement(childName, childText);
        root.elements.add(e);

        return this;
    }

    public void clear() {
        root = new HtmlElement();
        root.name = rootName;
    }

    @Override
    public String toString() {
        return root.toString();
    }
}

public class Demo {

    public static void main(String[] args) {
        String hello = "Hello";
//        System.out.println("<p>" + hello + "</p>");

        String[] words = {"Hello", "world"};
//        System.out.println(
//                "<ul>\n"+ "<li>" + words[0]
//        );
        StringBuilder sb = new StringBuilder();
        sb.append("<ul>\n");

        for (String word : words) {
            sb.append(String.format("  <li>%s</li>\n", word));
        }
        sb.append("</ul>");
//        System.out.println(sb);

        HtmlBuilder uBuilder = new HtmlBuilder("ul");
        uBuilder.addChild("li", "hello");
        //Fluent Builder
        uBuilder.addChild("li","world")
                .addChild("li", "!!!");

        System.out.println(uBuilder);
    }
}