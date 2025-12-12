package metaheuristics.generators;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class RandomSearchTest {

    @Test
    public void instantiate() {
        RandomSearch r = new RandomSearch();
        assertNotNull(r);
    }
}
