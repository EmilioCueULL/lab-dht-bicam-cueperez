package local_search.candidate_type;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class GreaterCandidateTest {

    @Test
    public void instantiation() {
        GreaterCandidate gc = new GreaterCandidate();
        assertNotNull(gc);
    }
}
