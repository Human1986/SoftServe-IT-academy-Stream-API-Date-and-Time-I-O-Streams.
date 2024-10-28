package jom.com.softserve.s6.task3;

import java.io.FileWriter;
import java.io.IOException;

public class MyUtils {
    public static void writeFile(String filename, String text) {
        StringBuilder line = new StringBuilder();

        for (char c : text.toCharArray()) {
            StringBuilder binaryString = new StringBuilder(Integer.toBinaryString(c));
            while (binaryString.length() < 7) {
                binaryString.insert(0, "0");
            }
            line.append(binaryString);
        }

        try (FileWriter writer = new FileWriter((filename))) {
            writer.write(line.toString());
        } catch (IOException e) {
            e.getCause();
        }
    }
}



