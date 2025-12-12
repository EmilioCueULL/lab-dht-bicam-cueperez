package metaheuristics.generators;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class TabuSearchTest {

    @Test
    public void instantiate() {
        TabuSearch t = new TabuSearch();
        assertNotNull(t);
    }
}
