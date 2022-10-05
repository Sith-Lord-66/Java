package qub.team33.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * This is used for managing the customer menu of the vending machine.
 *
 * @author Adam Thompson (40333846)
 */
public class FileUtils {

    /**
     * Add a single line to the end of a file.
     *
     * @param file the file you wish to add to
     * @param line this will be appended to the end of the file
     */
    public static void addLine(File file, String line) throws FileNotFoundException {
        addLines(file, Collections.singletonList(line));
    }

    /**
     * Add multiple lines to the end of a file.
     *
     * @param file  the file you wish to edit
     * @param lines these will be appended to the end of the file
     */
    public static void addLines(File file, List<String> lines) throws FileNotFoundException {
        List<String> data = getLines(file);
        PrintWriter writer = new PrintWriter(file);

        for (String line : data) {
            writer.write(line + "\n");
        }

        for (String line : lines) {
            writer.write(line + "\n");
        }

        writer.close();
    }

    /**
     * Get all the lines in a file.
     *
     * @param file the file you wish to edit
     * @return all the lines in the file
     */
    public static List<String> getLines(File file) throws FileNotFoundException {
        List<String> data = new ArrayList<>();
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (!line.isEmpty()) {
                data.add(line);
            }
        }

        scanner.close();
        return data;
    }

    public static void overwrite(File file, List<String> lines) throws FileNotFoundException {
        PrintWriter writer = new PrintWriter(file);

        for (String line : lines) {
            writer.write(line + "\n");
        }

        writer.close();
    }
}


