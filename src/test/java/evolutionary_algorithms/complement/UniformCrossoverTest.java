package evolutionary_algorithms.complement;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class UniformCrossoverTest {

    @Test
    public void instantiate() {
        UniformCrossover u = new UniformCrossover();
        assertNotNull(u);
    }
}
