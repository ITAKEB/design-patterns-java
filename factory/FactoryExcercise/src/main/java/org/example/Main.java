package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.

class Person{
    public int id;
    public String name;

    public Person(int id, String name){
        this.id = id;
        this.name = name;
    }
}

class PersonFactory{
    private int personCount;
    public Person createPerson(String name){
        return new Person(personCount++, name);
    }
}


public class Main {
    public static void main(String[] args) {
        PersonFactory personFactory = new PersonFactory();

        Person person1 = personFactory.createPerson("Tomas");
        System.out.println(person1.id);

        Person person2 = personFactory.createPerson("Tomas");
        System.out.println(person2.id);

        Person person3 = personFactory.createPerson("Tomas");
        System.out.println(person3.id);
    }
}