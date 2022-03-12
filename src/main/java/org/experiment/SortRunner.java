package org.experiment;

import org.algorithm.sort.InsertionSort;
import org.algorithm.sort.Sort;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static org.experiment.Constants.FILE_NAME;
import static org.experiment.Constants.RESULTS_DIR;

public class SortRunner {
    Sort<Integer> sorter;
    FileReader<String, Integer> reader = new FileReader<String, Integer>();

    Comparator<Integer> comparator = Integer::compareTo;

    Consumer<String> function = this::runSort;

    public static void main(String[] args) {
        SortRunner tester = new SortRunner();
        tester.runSorts(new InsertionSort<Integer>());
    }


    public void runSort(String array) {
        try {
            List<Integer> arr = Arrays.stream(array.split(" ")).map(Integer::valueOf).collect(Collectors.toList());
            long startTime = System.nanoTime();
            sorter.sort(arr, 1, comparator);
            long endTime = System.nanoTime();

            long runTime = endTime - startTime;

            reader.appendToFile(Paths.get(String.valueOf(RESULTS_DIR.toAbsolutePath()), "out.txt").toAbsolutePath(), Integer.toString(arr.size()) +"\t"+ runTime);
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    private void runSorts(Sort<Integer> sorter) {
        this.sorter = sorter;
        reader.readLineAndCall(FILE_NAME, function);

    }
}
