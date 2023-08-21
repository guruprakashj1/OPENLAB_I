package com;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class filegen {

    public static void main(String[] args) {
        // Path to the text file that contains the list of file names
        String filePath = "com\\filename.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                createJavaFile(line.trim());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void createJavaFile(String fileName) {
        String content = "public class " + fileName + " {\n"
                        + "    public static void main(String[] args) {\n"
                        + "        // Open lab / Guru J\n"
                        + "    }\n"
                        + "}";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName + ".java"))) {
            writer.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
