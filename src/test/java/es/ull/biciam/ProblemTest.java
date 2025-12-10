package es.ull.biciam;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import problem.definition.ObjetiveFunction;
import problem.definition.Problem;
import problem.definition.Problem.ProblemType;
import problem.definition.State;

public class ProblemTest {

    private Problem problem;
    private State state;
    private ArrayList<Object> code;

    @BeforeEach
    public void setUp() {
        problem = new Problem();
        code = new ArrayList<>();
        code.add(1);
        code.add(2);
        code.add(3);
        state = new State(code);
    }

    @Test
    public void testProblemDefaultConstructor() {
        assertNotNull(problem, "Problem should not be null");
    }

    @Test
    public void testSetAndGetFunction() {
        ArrayList<ObjetiveFunction> functions = new ArrayList<>();
        problem.setFunction(functions);
        assertEquals(functions, problem.getFunction());
    }

    @Test
    public void testSetAndGetState() {
        problem.setState(state);
        assertEquals(state, problem.getState());
    }

    @Test
    public void testSetAndGetTypeProblem() {
        problem.setTypeProblem(ProblemType.Maximizar);
        assertEquals(ProblemType.Maximizar, problem.getTypeProblem());
    }

    @Test
    public void testSetAndGetTypeProblemMinimizar() {
        problem.setTypeProblem(ProblemType.Minimizar);
        assertEquals(ProblemType.Minimizar, problem.getTypeProblem());
    }

    @Test
    public void testProblemTypeEnumValues() {
        ProblemType[] types = ProblemType.values();
        assertTrue(types.length > 0, "ProblemType should have values");
    }

    @Test
    public void testSetAndGetPossibleValue() {
        problem.setPossibleValue(10);
        assertEquals(10, problem.getPossibleValue());
    }

    @Test
    public void testSetAndGetPossibleValueDifferent() {
        problem.setPossibleValue(50);
        assertEquals(50, problem.getPossibleValue());
    }

    @Test
    public void testGetPossibleValueDefault() {
        // Test default value (depends on implementation)
        int value = problem.getPossibleValue();
        assertTrue(value >= 0);
    }
}
