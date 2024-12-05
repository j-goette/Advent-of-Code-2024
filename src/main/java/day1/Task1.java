package day1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Task1 {

    public static void main(String[] args) throws IOException {
        String[]      fileContentArray = readFileContent().split("\n");
        List<Integer> leftList         = convertToIntegerList(fileContentArray, 0);
        List<Integer> rightList        = convertToIntegerList(fileContentArray, 3);

        leftList  = leftList.stream().sorted().toList();
        rightList = rightList.stream().sorted().toList();

        int counter = 0;
        for (int i = 0; i < leftList.size(); i++) {
            int diff = leftList.get(i) - rightList.get(i);
            counter += Math.abs(diff);
        }

        System.out.println(counter);
    }

    private static String readFileContent() throws IOException {
        return Files.readString(Path.of("src/main/resources/day1/input1.txt").toAbsolutePath());
    }

    private static List<Integer> convertToIntegerList(String[] input, int index) {
        List<Integer> list = new ArrayList<>();
        for (String line : input) {
            String[] numbers = line.split(" ");
            list.add(Integer.parseInt(numbers[index]));
        }
        return list;
    }
}