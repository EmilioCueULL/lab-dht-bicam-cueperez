package evolutionary_algorithms.complement;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import metaheurictics.strategy.Strategy;
import problem.definition.Codification;
import problem.definition.Problem;
import problem.definition.State;

public class OnePointMutationTest {

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

    @Test
    public void mutationWithZeroProbability() {
        Strategy.destroyExecute();
        Strategy strat = Strategy.getStrategy();
        Problem p = new Problem();
        p.setCodification(new TestCodification());
        p.setPossibleValue(3);
        strat.setProblem(p);

        OnePointMutation m = new OnePointMutation();
        State s = new State();
        ArrayList<Object> code = new ArrayList<>();
        code.add(0);
        code.add(1);
        s.setCode(code);
        
        // With probability 0, mutation should not occur
        State result = m.mutation(s, 0.0);
        assertNotNull(result);
    }

    @Test
    public void mutationWithHighProbability() {
        Strategy.destroyExecute();
        Strategy strat = Strategy.getStrategy();
        Problem p = new Problem();
        p.setCodification(new TestCodification());
        p.setPossibleValue(3);
        strat.setProblem(p);

        OnePointMutation m = new OnePointMutation();
        State s = new State();
        ArrayList<Object> code = new ArrayList<>();
        code.add(0);
        code.add(1);
        s.setCode(code);
        
        // With probability 1.0, mutation should occur
        State result = m.mutation(s, 1.0);
        assertNotNull(result);
    }
}
