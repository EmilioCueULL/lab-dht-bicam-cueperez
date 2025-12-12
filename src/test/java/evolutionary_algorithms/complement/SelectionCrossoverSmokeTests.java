package evolutionary_algorithms.complement;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class SelectionCrossoverSmokeTests {

    @Test
    public void instantiateSeveral() {
        RouletteSelection rs = new RouletteSelection();
        UniformCrossover uc = new UniformCrossover();
        TruncationSelection ts = new TruncationSelection();
        OnePointCrossover opc = new OnePointCrossover();

        assertNotNull(rs);
        assertNotNull(uc);
        assertNotNull(ts);
        assertNotNull(opc);
    }
}
