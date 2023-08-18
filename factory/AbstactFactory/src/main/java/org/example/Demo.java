package org.example;


import jdk.internal.util.xml.impl.Pair;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Set;

interface HotDrink {
    void consume();
}

class Tea implements HotDrink {
    @Override
    public void consume() {
        System.out.println("This tea is delicious");
    }
}

class Coffee implements HotDrink {
    @Override
    public void consume() {
        System.out.println("This coffee is delicious");
    }
}

interface HotDrinkFactory {
    HotDrink prepare(int amount);
}

class TeaFactory implements HotDrinkFactory {
    @Override
    public HotDrink prepare(int amount) {
        System.out.println("Process to prepare " + amount + " of tea");

        return new Tea();
    }
}

class CoffeeFactory implements HotDrinkFactory {
    @Override
    public HotDrink prepare(int amount) {
        System.out.println("Process to prepare " + amount + " of coffee");

        return new Coffee();
    }
}

class HotDrinkMachine {
    private List<Pair<String, HotDrinkFactory>> namedFactories = new ArrayList<>();

    public HotDrinkFactory() {
        Set<Class<? extends HotDrinkFactory>> types = new Reflections("").getSubTypesOf(HotDrinkFactory.class);
    }
    for(Class<? extends HotDrinkFactory> type: types){
        namedFactories.add(new Pair<>(
                type.getSimpleName().replace("Factory", ""),
                type.getDeclaredConstructor().newInstance()
        ));
    }

    public HotDrink makeDrink() throws  Exception{
        System.out.println("Available drinks");
        for (int i = 0; i < namedFactories.size(); i++) {
            Pair<String, HotDrinkFactory> item = namedFactories.get(i);
            System.out.println(""+ i + ": "+ item.getKey());
        }

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            String s;
            int i, amount;
            if((s = bufferedReader.readLine())!= null
            && (i = Integer.parseInt(s)) >= 0
            && 1 < namedFactories.size())
            {
                System.out.println("Specify amount:");
                s = bufferedReader.readLine();
                if(s != null && (amount = Integer.parseInt(s)) > 0 ){
                    return namedFactories.get(i).getValue().prepare(amount);
                }
            }
            System.out.println("Incorrect input, try again.");
        }
    }
}

public class Demo {
    public static void main(String[] args) throws Exception{
        HotDrinkMachine machine = new HotDrinkMachine();
        HotDrink drink = machine.makeDrink();
        drink.consume();
    }
}
