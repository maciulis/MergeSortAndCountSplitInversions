package uk.co.ed.merge.sort.counting.split.inversions;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;
import static uk.co.ed.merge.sort.counting.split.inversions.SplitInversionsCounter.splitInversionCounter;

public class WhenCountingInversions {

    private NonSplitInversionsCounter nonSplitInversionCounter;

    @Before
    public void setUp() {
        nonSplitInversionCounter = new NonSplitInversionsCounter();
    }

    @Test public void
    should_count_number_of_inversions() {
        assertThat(nonSplitInversionCounter.countInversionsFor(numbersList()), equalTo(Long.valueOf(3)));
    }

    @Test
    public void
    should_return_0_when_list_is_empty() {
        assertThat(nonSplitInversionCounter.countInversionsFor(new int[]{}), equalTo(Long.valueOf(0)));
    }

    private int[] numbersList() {
        return new int[] { 1,3,4,2,6,5};
    }

    @Test public void
    should_return_left_part_bigger_if_given_array_has_odd_number_of_elements() {
        final int[] leftPart = nonSplitInversionCounter.leftListPartOf(orderedListOfElementsFrom1to7());

        assertThat(leftPart.length, equalTo(4));
        assertThat(leftPart[0], equalTo(1));
        assertThat(leftPart[3], equalTo(4));
    }

    private int[] orderedListOfElementsFrom1to7() {
        return new int[]{ 1,2,3,4,5,6,7 };
    }

    @Test public void
    should_return_right_part_smaller_if_given_array_has_odd_number_of_elements() {
        final int[] rightPart = nonSplitInversionCounter.rightListPartOf(orderedListOfElementsFrom1to7());

        assertThat(rightPart.length, equalTo(3));
        assertThat(rightPart[0], equalTo(5));
        assertThat(rightPart[2], equalTo(7));
    }

    @Test public void
    should_return_merged_and_sorted_array() {
        final SplitInversionsCounter splitInversionsCounter = splitInversionCounter();
        splitInversionsCounter.mergeSortAndCountSplitInversionsUsing(leftPart(), rightPart());

        assertThat(splitInversionsCounter.getMergedAndSortedNumberList(), equalTo(orderedListOfElementsFrom1to7()));
    }

    private int[] leftPart() {
        return new int[]{1,3,5,6};
    }

    private int[] rightPart() {
        return new int[]{2,4,7};
    }

    @Test public void
    should_return_right_split_inversion_count() {
        final Long actualSplitInversionCount = splitInversionCounter().mergeSortAndCountSplitInversionsUsing(leftPart(), rightPart());

        assertThat(actualSplitInversionCount, equalTo(Long.valueOf(5)));
    }

    @Test public void
    should_count_split_inversions() {
        assertThat(nonSplitInversionCounter.countInversionsFor(listOfNumbersToCount()), equalTo(Long.valueOf(5)));
    }

    private int[] listOfNumbersToCount() {
        return new int[]{1,3,5,6,2,4,7};
    }

    @Test public void
    should_count_split_inversions_using_example_number_list_from_video() {
        assertThat(nonSplitInversionCounter.countInversionsFor(listOfNumbersToCountFromExample()), equalTo(Long.valueOf(3)));
    }

    private int[] listOfNumbersToCountFromExample() {
        return new int[]{1,3,5,2,4,6};
    }

    @Test public void
    should_count_split_inversions_in_reversed_list() {
        assertThat(nonSplitInversionCounter.countInversionsFor(listOfNumbersInreverse()), equalTo(Long.valueOf(21)));
    }

    private int[] listOfNumbersInreverse() {
        return new int[]{7,6,5,4,3,2,1};
    }

    @Test public void
    should_count_split_inversions_in_reversed_list_of_100() {
        assertThat(nonSplitInversionCounter.countInversionsFor(listOfNumbersInreverseOf100()), equalTo(Long.valueOf(4950)));
    }

    private int[] listOfNumbersInreverseOf100() {
        final int[] numbers = new int[100];
        int j = 0;

        for(int i = 100; i > 0; i--) {
            numbers[j++] = i;
        }

        return numbers;
    }

    @Test public void
    should_count_inversions_correctly_given_4_integers() {
        final int[] ints = new int[]{54044,14108,79294,2964};

        assertEquals(NaiveSplitInversionFinder.count(ints), nonSplitInversionCounter.countInversionsFor(ints));
    }
}
