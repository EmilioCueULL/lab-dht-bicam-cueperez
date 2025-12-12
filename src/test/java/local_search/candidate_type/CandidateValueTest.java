package local_search.candidate_type;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class CandidateValueTest {

    @Test
    public void instantiation() {
        CandidateValue cv = new CandidateValue();
        assertNotNull(cv);
    }
}
