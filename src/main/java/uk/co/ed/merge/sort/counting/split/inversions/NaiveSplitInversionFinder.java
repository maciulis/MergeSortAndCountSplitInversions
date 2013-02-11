package uk.co.ed.merge.sort.counting.split.inversions;

/**
 * @author Edvinas Maciulis <edwin.maciul@gmail.com>
 */
public class NaiveSplitInversionFinder {

    static int count(final int[] list) {
        int counter = 0;
        for(int i = 0; i < list.length; i++)
            for(int j = 0; j < list.length; j++)
                if(j >= i && list[i] > list[j])
                    counter++;
        return counter;
    }
}
