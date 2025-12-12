package metaheuristics.generators;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class InstanceDETest {

    @Test
    public void instantiate() {
        InstanceDE i = new InstanceDE();
        assertNotNull(i);
    }
}
