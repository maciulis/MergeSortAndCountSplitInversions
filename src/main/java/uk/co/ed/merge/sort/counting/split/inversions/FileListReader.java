package uk.co.ed.merge.sort.counting.split.inversions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Edvinas Maciulis <edwin.maciul@gmail.com>
 */
public class FileListReader {

    public static final String INTEGER_ARRAY_TXT = "src/main/resources/IntegerArray.txt";

    private FileListReader() {

    }

    public static FileListReader fileListReader() {
        return new FileListReader();
    }

    public List<Integer> listOfNumbersFromFile() {
        List<Integer> numberListFromFile = new LinkedList<Integer>();

        try {
            final BufferedReader bufferedIntegerArrayFromFileReader = new BufferedReader(new FileReader(INTEGER_ARRAY_TXT));
            String line;

            while((line = bufferedIntegerArrayFromFileReader.readLine()) != null) {
                if(line.trim().length() > 0) {
                    numberListFromFile.add(Integer.parseInt(line));
                }
            }

            return numberListFromFile;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public int[] arrayOfNumbersFromFile() {
        int[] numberArrayFromFile = new int[100000];
        int i = 0;

        try {
            final BufferedReader bufferedIntegerArrayFromFileReader = new BufferedReader(new FileReader(INTEGER_ARRAY_TXT));
            String line;

            while((line = bufferedIntegerArrayFromFileReader.readLine()) != null) {
                if(line.trim().length() > 0) {
                    numberArrayFromFile[i++] = Integer.parseInt(line);
                }
            }

            return numberArrayFromFile;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
