package es.ull.biciam;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import local_search.acceptation_type.AcceptType;
import local_search.candidate_type.CandidateType;
import evolutionary_algorithms.complement.DistributionType;
import evolutionary_algorithms.complement.SamplingType;

public class LocalSearchEnumsTest {

    @Test
    public void testAcceptTypeValues() {
        AcceptType[] types = AcceptType.values();
        assertTrue(types.length > 0, "AcceptType should have values");
        assertTrue(contains(types, AcceptType.AcceptBest));
        assertTrue(contains(types, AcceptType.AcceptAnyone));
        assertTrue(contains(types, AcceptType.AcceptNotBad));
    }

    @Test
    public void testCandidateTypeValues() {
        CandidateType[] types = CandidateType.values();
        assertTrue(types.length > 0, "CandidateType should have values");
        assertTrue(contains(types, CandidateType.Greater));
        assertTrue(contains(types, CandidateType.Smaller));
        assertTrue(contains(types, CandidateType.Random));
    }

    @Test
    public void testDistributionTypeValues() {
        DistributionType[] types = DistributionType.values();
        assertTrue(types.length > 0, "DistributionType should have values");
    }

    @Test
    public void testSamplingTypeValues() {
        SamplingType[] types = SamplingType.values();
        assertTrue(types.length > 0, "SamplingType should have values");
        assertTrue(contains(types, SamplingType.Probabilistic));
    }

    @Test
    public void testAcceptTypeToString() {
        assertNotNull(AcceptType.AcceptBest.toString());
    }

    @Test
    public void testCandidateTypeToString() {
        assertNotNull(CandidateType.Greater.toString());
    }

    private <T extends Enum<T>> boolean contains(T[] values, T target) {
        for (T value : values) {
            if (value.equals(target)) {
                return true;
            }
        }
        return false;
    }
}
