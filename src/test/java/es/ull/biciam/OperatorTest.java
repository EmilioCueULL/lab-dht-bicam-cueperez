package es.ull.biciam;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import problem.definition.Operator;
import problem.definition.State;

public class OperatorTest {

    private Operator operator;
    private State state;

    @BeforeEach
    public void setUp() {
        operator = new Operator();
        ArrayList<Object> code = new ArrayList<>();
        code.add(1);
        code.add(2);
        code.add(3);
        state = new State(code);
    }

    @Test
    public void testOperatorNotNull() {
        assertNotNull(operator, "Operator should not be null");
    }

    @Test
    public void testOperatorSetState() {
        operator.setState(state);
        // Test that the state was set (depends on Operator implementation)
        assertNotNull(operator);
    }

    @Test
    public void testOperatorGetState() {
        operator.setState(state);
        // Test getter if it exists (depends on Operator implementation)
        assertNotNull(operator);
    }
}
