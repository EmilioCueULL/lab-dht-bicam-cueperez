package es.ull.biciam;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import local_search.complement.StrategyType;
import local_search.complement.StopExecute;

public class LocalSearchComplementEnumsTest {

    @Test
    public void testStrategyTypeValues() {
        StrategyType[] types = StrategyType.values();
        assertTrue(types.length > 0, "StrategyType should have values");
    }

    @Test
    public void testStrategyTypeToString() {
        StrategyType[] types = StrategyType.values();
        for (StrategyType type : types) {
            assertNotNull(type.toString(), "StrategyType toString should not be null");
        }
    }

    @Test
    public void testStopExecuteValues() {
        StopExecute[] types = StopExecute.values();
        assertTrue(types.length > 0, "StopExecute should have values");
    }

    @Test
    public void testStopExecuteToString() {
        StopExecute[] types = StopExecute.values();
        for (StopExecute type : types) {
            assertNotNull(type.toString(), "StopExecute toString should not be null");
        }
    }
}
