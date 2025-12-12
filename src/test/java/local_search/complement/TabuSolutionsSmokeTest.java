package local_search.complement;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class TabuSolutionsSmokeTest {

    @Test
    public void instantiate() {
        TabuSolutions t = new TabuSolutions();
        assertNotNull(t);
    }
}
