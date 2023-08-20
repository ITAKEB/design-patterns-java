package org.example;

//A common static data but you can instance whatever classes you want
class ChiefExecutiveOfficer {
    private static String name;
    private static int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        ChiefExecutiveOfficer.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        ChiefExecutiveOfficer.age = age;
    }

    @Override
    public String toString() {
        return "ChiefExecutiveOfficer{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

public class Main {
    public static void main(String[] args) {
        ChiefExecutiveOfficer ceo = new ChiefExecutiveOfficer();
        ceo.setName("Tomas");
        ceo.setAge(42);
        ChiefExecutiveOfficer ceo2 = new ChiefExecutiveOfficer();

        System.out.println(ceo2);

    }
}