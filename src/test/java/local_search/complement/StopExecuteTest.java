package local_search.complement;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class StopExecuteTest {

    @Test
    public void returnsFalseWhenBelowMax() {
        StopExecute s = new StopExecute();
        assertFalse(s.stopIterations(0, 1));
    }

    @Test
    public void returnsTrueWhenAtOrAboveMax() {
        StopExecute s = new StopExecute();
        assertTrue(s.stopIterations(1, 1));
        assertTrue(s.stopIterations(5, 1));
    }
}
