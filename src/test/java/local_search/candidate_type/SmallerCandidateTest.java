package local_search.candidate_type;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class SmallerCandidateTest {

    @Test
    public void instantiation() {
        SmallerCandidate sc = new SmallerCandidate();
        assertNotNull(sc);
    }
}
