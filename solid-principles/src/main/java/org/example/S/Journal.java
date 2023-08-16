package org.example.S;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Journal {
    private final List<String> entries = new ArrayList<>();
    private static int count = 0;

    public void addEntry(String text) {
        entries.add("" + (++count) + ": " + text);

    }

    public void removeEntry(int index) {
        entries.remove(index);
    }

    @Override
    public String toString() {
        return String.join(System.lineSeparator(), this.entries);
    }

    public void save(String filename) throws FileNotFoundException {
        try (PrintStream out = new PrintStream(filename)) {
            out.println(this.toString());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void load(String filename) {
    }

    public void load(URL url) {
    }
}

class Persistence {
    public void saveToFile(Journal journal, String fileName, boolean overWrite) throws FileNotFoundException {
        if (overWrite || new File(fileName).exists()) {
            try (PrintStream out = new PrintStream((fileName))) {
                out.println(journal.toString());
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }

//    public Journal load(String filename   ) {}
//    public Journal load(URL url) {}

}

class Demo {
    public static void main(String[] args) throws Exception {
        Journal j = new Journal();
        j.addEntry("I cried today");
        j.addEntry("I ate a bug");
        System.out.println(j);

        Persistence p = new Persistence();
        String fileName = "/home/nn/file.txt";
        p.saveToFile(j,fileName,true);

        Runtime.getRuntime().exec("code "+ fileName);
    }
}



