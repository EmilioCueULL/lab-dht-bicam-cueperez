package metaheuristics.generators;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class GeneticAlgorithmTest {

    @Test
    public void instantiate() {
        GeneticAlgorithm g = new GeneticAlgorithm();
        assertNotNull(g);
    }
}
