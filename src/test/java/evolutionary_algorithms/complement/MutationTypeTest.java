package evolutionary_algorithms.complement;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class MutationTypeTest {

    @Test
    public void enumValues() {
        MutationType[] vals = MutationType.values();
        assertTrue(vals.length > 0);
    }
}
