package duke.task;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DeadlineTest {
    @Test
    void print_withDateAndTime_correctFormat() {
        Deadline deadline = new Deadline("homework", "26/01/2024 1430");
        assertTrue(deadline.print().matches("\\[D\\] \\[ \\] homework \\(by:26(th|st|nd|rd) of January 2024, 2:30 PM\\)"));
    }

    @Test
    void print_dateOnly_correctFormat() {
        Deadline deadline = new Deadline("homework", "26/01/2024");
        assertTrue(deadline.print().matches("\\[D\\] \\[ \\] homework \\(by:26(th|st|nd|rd) of January 2024\\)"));
    }
}