package problem.extension;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class SolutionMethodSmokeTest {

    @Test
    public void instantiateEnumsAndTypes() {
        TypeSolutionMethod[] vals = TypeSolutionMethod.values();
        assertTrue(vals.length > 0);
    }
}
