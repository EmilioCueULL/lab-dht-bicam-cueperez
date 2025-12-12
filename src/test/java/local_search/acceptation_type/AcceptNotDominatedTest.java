package local_search.acceptation_type;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class AcceptNotDominatedTest {

    @Test
    public void instantiation() {
        AcceptNotDominated and = new AcceptNotDominated();
        assertNotNull(and);
    }
}
