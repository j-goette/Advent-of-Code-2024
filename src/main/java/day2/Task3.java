package day2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

public class Task3 {

    private final static int MAX = 1000;

    public static void main(String[] args) throws IOException {
        String file = readFile();
        List<String> lines = parseFileContent(file);

        int unsafe = 0;
        for (String line : lines) {
            String[] numbers = line.split(" ");

            System.out.println("Next");

            int level = 0;
            boolean safe = true;
            for (int i = 1; i < numbers.length; i++) {
                System.out.println(numbers[i]);

                int first = Integer.parseInt(numbers[i - 1]);
                int second = Integer.parseInt(numbers[i]);

                if (Math.abs(first - second) > 3) {
                    safe = false;
                    break;
                }

                if (first < second) {
                    level++;
                } else if (first > second) {
                    level--;
                }
            }

            if (Math.abs(level) != numbers.length - 1) {
                unsafe++;
                System.out.println("UNSAFE");
            } else if (!safe) {
                unsafe++;
                System.out.println("UNSAFE");
            }
        }

        int result = MAX - unsafe;
        System.out.println("Result " + result);
    }

    private static String readFile() throws IOException {
        return Files.readString(Path.of("src/main/resources/day2/input2.txt").toAbsolutePath());
    }

    private static List<String> parseFileContent(String fileContent) {
        String[] lines = fileContent.split("\n");
        return Arrays.asList(lines);
    }
}
