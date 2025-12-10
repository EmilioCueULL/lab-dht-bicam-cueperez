package es.ull.biciam;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import problem.definition.State;
import problem_operators.MutationOperator;

public class MutationOperatorTest {

    private MutationOperator mutationOperator;
    private State state;

    @BeforeEach
    public void setUp() {
        mutationOperator = new MutationOperator();
        ArrayList<Object> code = new ArrayList<>();
        code.add(1);
        code.add(2);
        code.add(3);
        state = new State(code);
    }

    @Test
    public void testMutationOperatorNotNull() {
        assertNotNull(mutationOperator, "MutationOperator should not be null");
    }

    @Test
    public void testStateNotNull() {
        assertNotNull(state, "State should not be null");
        assertEquals(3, state.getCode().size());
    }
}
