package evolutionary_algorithms.complement;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class UnivariateTest {

    @Test
    public void instantiate() {
        Univariate u = new Univariate();
        assertNotNull(u);
    }
}
