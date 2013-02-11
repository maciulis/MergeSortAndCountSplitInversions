package uk.co.ed.merge.sort.counting.split.inversions;

import java.util.Arrays;

import static uk.co.ed.merge.sort.counting.split.inversions.SplitInversionsCounter.splitInversionCounter;

public class NonSplitInversionsCounter {

    public long countInversionsFor(final int[] numbersList) {
        if(numbersList.length < 2) {
            return 0;
        }

        final int[] leftPart = leftListPartOf(numbersList);
        final int[] rightPart = rightListPartOf(numbersList);

        final long leftPartInversionCount = countInversionsFor(leftPart);
        final long rightPartInversionCount = countInversionsFor(rightPart);

        final SplitInversionsCounter splitInversionCounter = splitInversionCounter();
        final long splitInversionCount = splitInversionCounter.mergeSortAndCountSplitInversionsUsing(leftPart, rightPart);
        updateTheOrderOfNumbersListUsing(numbersList, splitInversionCounter.getMergedAndSortedNumberList());

        return leftPartInversionCount + rightPartInversionCount + splitInversionCount;
    }

    private void updateTheOrderOfNumbersListUsing(final int[] numbersList, final int[] mergedAndSortedNumberList) {
        int k = 0;
        for(int i : mergedAndSortedNumberList) {
            numbersList[k++] = i;
        }
    }

    int[] leftListPartOf(final int[] numbersList) {
        if(numbersList.length % 2 != 0) {
            return Arrays.copyOfRange(numbersList, 0, (numbersList.length+1)/2);
        }

        return Arrays.copyOfRange(numbersList, 0, numbersList.length/2);
    }

    int[] rightListPartOf(final int[] numbersList) {
        if(numbersList.length % 2 != 0) {
            return Arrays.copyOfRange(numbersList, (numbersList.length+1)/2, numbersList.length);
        }

        return Arrays.copyOfRange(numbersList, numbersList.length/2, numbersList.length);
    }
}
