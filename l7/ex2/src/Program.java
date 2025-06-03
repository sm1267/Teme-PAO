import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws Exception {
        String filePath = "files/input.txt";
        String classPath = "src/Program.java";

        // a. gaseste cel mai lung cuvant din fisier
        String longest = "";
        Scanner sc = new Scanner(new File(filePath));
        while (sc.hasNext()) {
            String word = sc.next();
            if (word.length() > longest.length()) {
                longest = word;
            }
        }
        sc.close();
        System.out.println("Longest word: " + longest);

        // b. adauga continutul clasei curente in fisier
        StringBuilder classContent = new StringBuilder();
        BufferedReader brClass = new BufferedReader(new FileReader(classPath));
        String lineClass;
        while ((lineClass = brClass.readLine()) != null) {
            classContent.append(lineClass).append(System.lineSeparator());
        }
        brClass.close();

        BufferedWriter bw = new BufferedWriter(new FileWriter(filePath, true));
        bw.write(classContent.toString());
        bw.close();

        // c. salveaza intr-un array, linie cu linie, continutul fisierului
        List<String> list = new ArrayList<>();
        BufferedReader brFile = new BufferedReader(new FileReader(filePath));
        String lineFile;
        while ((lineFile = brFile.readLine()) != null) {
            list.add(lineFile);
        }
        brFile.close();

        String[] lines = list.toArray(new String[0]);
        // la nevoie se poate folosi array-ul 'lines' mai departe
    }
}
