package evolutionary_algorithms.complement;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ReplaceTypeTest {

    @Test
    public void enumValues() {
        ReplaceType[] vals = ReplaceType.values();
        assertTrue(vals.length > 0);
    }
}
