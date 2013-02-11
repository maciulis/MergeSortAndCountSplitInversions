package uk.co.ed.merge.sort.counting.split.inversions;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;

/**
 * @author Edvinas Maciulis <edwin.maciul@gmail.com>
 */
public class WhenReadingNumberListFromFile {

    @Test public void
    should_return_list_size_of_100000() {
        List<Integer> numbersList = fileListReader().listOfNumbersFromFile();

        assertThat(numbersList.size(), equalTo(100000));
    }

    private FileListReader fileListReader() {
        return FileListReader.fileListReader();
    }
}
