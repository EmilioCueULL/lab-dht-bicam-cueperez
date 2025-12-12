package evolutionary_algorithms.complement;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class TowPointsMutationTest {

    @Test
    public void instantiation() {
        TowPointsMutation tpm = new TowPointsMutation();
        assertNotNull(tpm);
    }
}
