package uk.co.ed.merge.sort.counting.split.inversions;

import static uk.co.ed.merge.sort.counting.split.inversions.FileListReader.fileListReader;

/**
 * @author Edvinas Maciulis <edwin.maciul@gmail.com>
 */
public class InversionCounter {

    public static void main(String ...args) {
        final NonSplitInversionsCounter nonSplitInversionCounter = new NonSplitInversionsCounter();
        final int[] integerList = fileListReader().arrayOfNumbersFromFile();

        final long numberOfSplitInversionsInGivenList = nonSplitInversionCounter.countInversionsFor(integerList);

        System.out.println("Found "+numberOfSplitInversionsInGivenList+" inversions");
    }
}
