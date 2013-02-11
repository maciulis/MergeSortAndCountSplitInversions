package uk.co.ed.merge.sort.counting.split.inversions;

/**
 * @author Edvinas Maciulis <edwin.maciul@gmail.com>
 */
public class SplitInversionsCounter {

    private int [] mergedAndSortedNumberList;

    private SplitInversionsCounter() {

    }

    public static SplitInversionsCounter splitInversionCounter() {
        return new SplitInversionsCounter();
    }

    public long mergeSortAndCountSplitInversionsUsing(final int[] leftPart, final int[] rightPart) {
        final int listSize = leftPart.length + rightPart.length;
        mergedAndSortedNumberList = new int[listSize];
        int finalIndex = 0;

        int leftIndex = 0;
        int rightIndex = 0;
        long splitInversionCounter = 0;

        for(int k = 0; k < listSize; k++) {
            if(leftPart[leftIndex] > rightPart[rightIndex]) {
                mergedAndSortedNumberList[finalIndex++] = rightPart[rightIndex];
                rightIndex++;
                splitInversionCounter = splitInversionCounter + leftPart.length - leftIndex;
            }
            else {
                mergedAndSortedNumberList[finalIndex++] = leftPart[leftIndex];
                leftIndex++;
            }

            if(rightPart.length == rightIndex) {
                for(; leftIndex < leftPart.length; leftIndex++) {
                    mergedAndSortedNumberList[finalIndex++] = leftPart[leftIndex];
                }

                break;
            }

            if(leftPart.length == leftIndex) {
                for(; rightIndex < rightPart.length; rightIndex++) {
                    mergedAndSortedNumberList[finalIndex++] = rightPart[rightIndex];
                }

                break;
            }
        }
        return splitInversionCounter;
    }

    public int[] getMergedAndSortedNumberList() {
        return mergedAndSortedNumberList;
    }
}
