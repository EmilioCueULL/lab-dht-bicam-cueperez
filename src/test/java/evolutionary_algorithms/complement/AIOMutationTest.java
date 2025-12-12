package evolutionary_algorithms.complement;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class AIOMutationTest {

    @Test
    public void instantiate() {
        AIOMutation a = new AIOMutation();
        assertNotNull(a);
    }
}
