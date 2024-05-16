import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class UniqueInt {

    private boolean[] seen = new boolean[2047]; // Boolean array for integers from -1023 to 1023
    private int minInt = -1023;

    public UniqueInt() {
        Arrays.fill(seen, false);
    }

    public void processFile(String inputFilePath, String outputFilePath) {
        // Reset seen array for each file
        Arrays.fill(seen, false);
        int[] uniqueNumbers = readUniqueIntegers(inputFilePath);
        writeUniqueIntegers(uniqueNumbers, outputFilePath);
    }

    public int[] readUniqueIntegers(String inputFilePath) {
        int[] uniqueNumbers = new int[0];
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (!line.isEmpty() && isValidIntegerLine(line)) {
                    int number = Integer.parseInt(line);
                    if (-1023 <= number && number <= 1023) { // Ensure the number is within range
                        if (!seen[number - minInt]) {
                            seen[number - minInt] = true;
                            uniqueNumbers = Arrays.copyOf(uniqueNumbers, uniqueNumbers.length + 1);
                            uniqueNumbers[uniqueNumbers.length - 1] = number;
                        }
                    } else {
                        System.out.println("Number out of range: " + number);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Arrays.sort(uniqueNumbers);
        return uniqueNumbers;
    }

    public boolean isValidIntegerLine(String line) {
        try {
            Integer.parseInt(line);
            return true;
        } catch (NumberFormatException e) {
            System.out.println("Invalid integer line: " + line);
            return false;
        }
    }

    public void writeUniqueIntegers(int[] uniqueNumbers, String outputFilePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {
            for (int number : uniqueNumbers) {
                writer.write(number + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String inputFolder = "/home/kanyambo/java_app/sample_inputs";
        String outputFolder = "/home/kanyambo/java_app/results";

        UniqueInt uniqueIntProcessor = new UniqueInt();

        for (String filename : new java.io.File(inputFolder).list()) {
            if (filename.endsWith(".txt")) {
                String inputPath = inputFolder + "/" + filename;
                String outputName = filename + "_results.txt";
                String outputPath = outputFolder + "/" + outputName;

                // Timing for each file
                long startTime = System.nanoTime();
                uniqueIntProcessor.processFile(inputPath, outputPath);
                long endTime = System.nanoTime();

                double elapsedTime = (endTime - startTime) / 1e9; // Convert to seconds
                System.out.printf("Processed %s in %.4f seconds%n", filename, elapsedTime);
            }
        }
    }
}

