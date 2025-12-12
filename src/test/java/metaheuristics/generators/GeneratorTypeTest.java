package metaheuristics.generators;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class GeneratorTypeTest {

    @Test
    public void enumHasValues() {
        GeneratorType[] vals = GeneratorType.values();
        assertTrue(vals.length > 0);
    }
}
