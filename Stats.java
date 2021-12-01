/*
* Calculates the mean and median given sets of numbers
* @author Malcolm Tompkins
* @since 2021-11-29
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

/**
* Class Stats.
*/

final class Stats {

    /**
    * Prevent instantiation.
    * Throw an exception IllegalStateException.
    * if this ever is called
    *
    * @throws IllegalStateException
    *
    */
    private Stats() {
        throw new IllegalStateException("Cannot be instantiated");
    }
    /**
    * Calculates the median of the number set.
    *
    * @param arrayOfNumbers contains the number set
    * @return the median of the number set
    */

    public static double calculateMedian(Integer[] arrayOfNumbers) {
        final int numberOfNumbers = arrayOfNumbers.length;
        double medianFinal = 0;
        Arrays.sort(arrayOfNumbers);
        if (numberOfNumbers % 2 == 0) {
            final int elementNumber1 = (numberOfNumbers / 2) - 1;
            final int median1 = arrayOfNumbers[elementNumber1];
            final int elementNumber2 = numberOfNumbers / 2;
            final int median2 = arrayOfNumbers[elementNumber2];
            medianFinal = ((double) median1 + (double) median2) / 2;
        } else {
            final int elementNumber = (numberOfNumbers / 2) + (1 / 2);
            medianFinal = arrayOfNumbers[elementNumber];
        }
        return medianFinal;
    }
    /**
    * Calculates the mean of the number set.
    *
    * @param arrayOfNumbers contains the number set
    * @return the mean of the number set
    */

    public static double calculateMean(Integer[] arrayOfNumbers) {
        // Process
        final int numberOfNumbers = arrayOfNumbers.length;
        int total = 0;
        for (int tempNumber : arrayOfNumbers) {
            total = total + tempNumber;
        }
        final double mean = (double) total / (double) numberOfNumbers;
        return mean;
    }
    /**
    * The Starting main() function.
    *
    * @param args Not used.
    */

    public static void main(final String[] args) {
        Integer tempNumber;
        final ArrayList<Integer> listOfNumbers = new ArrayList<Integer>();
        final Path filePath = Paths.get("../", args[0]);
        final Charset charset = Charset.forName("UTF-8");

        try (BufferedReader reader = Files.newBufferedReader(
                                     filePath, charset)) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                tempNumber = Integer.parseInt(line);
                listOfNumbers.add(tempNumber);
            }
        } catch (IOException errorCode) {
            System.err.println(errorCode);
        }

        final Integer[] arrayOfNumbers = listOfNumbers.toArray(new Integer[0]);
        System.out.println(Arrays.toString(arrayOfNumbers));

        System.out.println("\nCalculating stats...");
        final double mean = calculateMean(arrayOfNumbers);
        final double median = calculateMedian(arrayOfNumbers);

        System.out.println("The mean is: " + mean);
        System.out.println("The median is: " + median);
        System.out.println("\nDone.");
    }
}
