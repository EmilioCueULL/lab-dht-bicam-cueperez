package problem.definition;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

public class ProblemTest {

    static class TestCodification extends Codification {
        @Override
        public boolean validState(State state) {
            return true;
        }

        @Override
        public Object getVariableAleatoryValue(int key) {
            return 0;
        }

        @Override
        public int getAleatoryKey() {
            return 0;
        }

        @Override
        public int getVariableCount() {
            return 5;
        }
    }

    static class TestObjectiveFunction extends ObjetiveFunction {
        @Override
        public Double Evaluation(State state) {
            return 10.0;
        }
    }

    @Test
    public void gettersAndSetters() {
        Problem p = new Problem();
        
        Codification cod = new TestCodification();
        p.setCodification(cod);
        assertEquals(cod, p.getCodification());
        
        p.setPossibleValue(5);
        assertEquals(5, p.getPossibleValue());
        
        State s = new State();
        p.setState(s);
        assertEquals(s, p.getState());
        
        p.setTypeProblem(Problem.ProblemType.Maximizar);
        assertEquals(Problem.ProblemType.Maximizar, p.getTypeProblem());
        
        p.setTypeProblem(Problem.ProblemType.Minimizar);
        assertEquals(Problem.ProblemType.Minimizar, p.getTypeProblem());
    }

    @Test
    public void functionListGettersSetters() {
        Problem p = new Problem();
        ArrayList<ObjetiveFunction> funcs = new ArrayList<>();
        funcs.add(new TestObjectiveFunction());
        
        p.setFunction(funcs);
        assertEquals(funcs, p.getFunction());
        assertEquals(1, p.getFunction().size());
    }

    @Test
    public void evaluateState() throws Exception {
        Problem p = new Problem();
        ArrayList<ObjetiveFunction> funcs = new ArrayList<>();
        funcs.add(new TestObjectiveFunction());
        p.setFunction(funcs);
        
        State s = new State();
        ArrayList<Object> code = new ArrayList<>();
        code.add(1);
        s.setCode(code);
        
        p.Evaluate(s);
        
        assertNotNull(s.getEvaluation());
        assertEquals(1, s.getEvaluation().size());
        assertEquals(10.0, s.getEvaluation().get(0));
    }

    @Test
    public void typeSolutionMethodGettersSetters() {
        Problem p = new Problem();
        p.setTypeSolutionMethod(null);
        assertNull(p.getTypeSolutionMethod());
    }

    @Test
    public void operatorGettersSetters() {
        Problem p = new Problem();
        Operator op = new Operator() {
            @Override
            public java.util.List<State> generatedNewState(State stateCurrent, Integer operatornumber) {
                return null;
            }

            @Override
            public java.util.List<State> generateRandomState(Integer operatornumber) {
                return null;
            }
        };
        p.setOperator(op);
        assertEquals(op, p.getOperator());
    }
}
