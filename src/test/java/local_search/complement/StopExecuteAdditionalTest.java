package local_search.complement;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class StopExecuteAdditionalTest {

    @Test
    public void boundaryChecks() {
        StopExecute s = new StopExecute();
        assertFalse(s.stopIterations(-1, 0));
        assertTrue(s.stopIterations(0, 0));
    }
}
