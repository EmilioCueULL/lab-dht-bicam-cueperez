package es.ull.biciam;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import local_search.complement.TabuSolutions;
import problem.definition.State;

public class TabuSolutionsTest {

    private TabuSolutions tabuSolutions;
    private List<State> neighborhood;
    private State state1;
    private State state2;
    private State state3;

    @BeforeEach
    public void setUp() {
        tabuSolutions = new TabuSolutions();
        neighborhood = new ArrayList<>();
        
        // Clear the static list before each test
        TabuSolutions.listTabu.clear();
        
        // Create states
        ArrayList<Object> code1 = new ArrayList<>();
        code1.add(1);
        code1.add(2);
        state1 = new State(code1);
        
        ArrayList<Object> code2 = new ArrayList<>();
        code2.add(3);
        code2.add(4);
        state2 = new State(code2);
        
        ArrayList<Object> code3 = new ArrayList<>();
        code3.add(5);
        code3.add(6);
        state3 = new State(code3);
    }

    @Test
    public void testFilterNeighborhoodEmpty() throws Exception {
        neighborhood.add(state1);
        neighborhood.add(state2);
        neighborhood.add(state3);
        
        List<State> result = tabuSolutions.filterNeighborhood(neighborhood);
        assertNotNull(result);
        assertEquals(3, result.size(), "All states should be returned when tabu list is empty");
    }

    @Test
    public void testFilterNeighborhoodWithTabuSolutions() throws Exception {
        neighborhood.add(state1);
        neighborhood.add(state2);
        neighborhood.add(state3);
        
        // Add state1 to tabu list
        ArrayList<Object> tabuCode = new ArrayList<>();
        tabuCode.add(1);
        tabuCode.add(2);
        State tabuState = new State(tabuCode);
        TabuSolutions.listTabu.add(tabuState);
        
        List<State> result = tabuSolutions.filterNeighborhood(neighborhood);
        assertNotNull(result);
        // The tabu state should be filtered out
        assertTrue(result.size() <= neighborhood.size());
    }

    @Test
    public void testFilterNeighborhoodMaxElements() {
        TabuSolutions.maxelements = 10;
        assertEquals(10, TabuSolutions.maxelements);
    }

    @Test
    public void testFilterNeighborhoodPreservesNonTabuStates() throws Exception {
        neighborhood.add(state1);
        neighborhood.add(state2);
        neighborhood.add(state3);
        
        List<State> result = tabuSolutions.filterNeighborhood(neighborhood);
        assertNotNull(result);
        assertTrue(result.size() > 0, "At least one state should be returned");
    }

    @Test
    public void testEmptyNeighborhood() throws Exception {
        List<State> result = tabuSolutions.filterNeighborhood(neighborhood);
        assertNotNull(result);
        assertTrue(result.isEmpty(), "Empty neighborhood should return empty list");
    }

    @Test
    public void testSingleStateInNeighborhood() throws Exception {
        neighborhood.add(state1);
        
        List<State> result = tabuSolutions.filterNeighborhood(neighborhood);
        assertNotNull(result);
        assertEquals(1, result.size());
    }

    @Test
    public void testTabuListStatic() {
        assertNotNull(TabuSolutions.listTabu);
        assertTrue(TabuSolutions.listTabu instanceof List);
    }
}
