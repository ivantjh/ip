package duke.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DateTimeTest {
    @Test
    void dateTime_acceptedInputs_noExceptionThrown() {
        assertDoesNotThrow(() -> {
            new DateTime("05/06/2021");
            new DateTime("05/06/2021 1250");
        });
    }

    @Test
    void toString_acceptedInputs_printsCorrectly() {
        assertEquals(new DateTime("12/12/2020").toString(), "12 Dec 2020");
        assertEquals(new DateTime("06/08/2021 2359").toString(), "2359 06 Aug 2021");
    }
}
