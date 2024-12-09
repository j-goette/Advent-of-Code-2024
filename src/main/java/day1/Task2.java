package day1;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task2 {

    public static void main(String[] args) throws IOException {
        String        fileContent = readFile();
        List<Integer> leftList    = parseFile(fileContent, 0);
        List<Integer> rightList    = parseFile(fileContent, 1);

        int score = 0;
        int count = 0;
        for (Integer i : leftList) {
            if (rightList.contains(i)) {
                for (Integer j : rightList) {
                    if (i.equals(j)) {
                        count++;
                    }
                }
                score += i * count;
                count = 0;
            }
        }

        System.out.println(score);
    }

    private static String readFile() throws IOException {
        return Files.readString(Path.of("src/main/resources/day1/input1.txt").toAbsolutePath());
    }

    private static List<Integer> parseFile(String fileContent, int list) {
        List<Integer> numbers = new ArrayList<>();
        for (String line : fileContent.split("\n")) {
           String[] parts = line.split("   ");
            numbers.add(Integer.parseInt(parts[list]));
        }
        return numbers;
    }
}
