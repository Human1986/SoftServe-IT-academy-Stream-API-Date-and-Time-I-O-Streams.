package jom.com.softserve.s6.task4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MyUtils {

    public static String readFile(String filename) {
        StringBuilder binaryString = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            binaryString.append(reader.readLine());
        } catch (IOException e) {
            e.getCause();
        }


        StringBuilder result = new StringBuilder();
        int i = 0;

        while (i < binaryString.length()) {
            String byteSegment = binaryString.substring(i, i + 7);

            int charCode = Integer.parseInt(byteSegment, 2);

            result.append((char) charCode);

            i += byteSegment.length() + (byteSegment.length() < 7 ? 1 : 0);
        }
        return result.toString();
    }
}
