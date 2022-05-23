package Bai2;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * Ex17ReverseNameOrder
 */
public class Ex17ReverseNameOrder {

    public static void main(String[] args) throws IOException {
        Scanner inputFromFile = new Scanner(Paths.get("input.txt"), " ");
        PrintWriter printWriter = new PrintWriter("KETQUA.OUT", "UFT-8");

        while (inputFromFile.hasNextLine()) {
            String name = inputFromFile.nextLine();
            name = name.trim();
            String[] names = name.split(" ");
            StringBuilder builder = new StringBuilder();
            builder.append(names[names.length - 1] + " ");
            builder.append(" ");
            builder.append(names[0] + " ");
            for (int i = 1; i < names.length - 1; i++) {
                if (names[i].length() != 0) {
                    builder.append(names[i] + " ");
                }

            }
            name = builder.toString();
            printWriter.println(name);
        }


        printWriter.close();
        inputFromFile.close();
    }
}