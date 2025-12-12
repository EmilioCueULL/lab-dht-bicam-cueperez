package evolutionary_algorithms.complement;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class SteadyStateReplaceTest {

    @Test
    public void instantiation() {
        SteadyStateReplace ssr = new SteadyStateReplace();
        assertNotNull(ssr);
    }
}
