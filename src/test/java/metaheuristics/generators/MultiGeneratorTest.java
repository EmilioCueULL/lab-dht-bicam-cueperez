package metaheuristics.generators;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class MultiGeneratorTest {

    @Test
    public void instantiate() {
        MultiGenerator m = new MultiGenerator();
        assertNotNull(m);
    }
}
