package metaheuristics.generators;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class MultiobjectiveTabuSearchTest {

    @Test
    public void instantiate() {
        MultiobjectiveTabuSearch m = new MultiobjectiveTabuSearch();
        assertNotNull(m);
    }
}
