package metaheuristics.generators;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class InstanceGATest {

    @Test
    public void instantiate() {
        InstanceGA i = new InstanceGA();
        assertNotNull(i);
    }
}
