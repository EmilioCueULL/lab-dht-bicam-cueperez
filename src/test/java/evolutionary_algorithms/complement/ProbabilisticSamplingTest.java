package evolutionary_algorithms.complement;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import metaheurictics.strategy.Strategy;
import metaheuristics.generators.GeneratorType;
import problem.definition.Codification;
import problem.definition.Problem;
import problem.definition.State;

public class ProbabilisticSamplingTest {

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
            return 1;
        }

    }

    @Test
    public void listStateInitializesCorrectlyAndSamplingProducesExpectedSizes() {
        Strategy.destroyExecute();
        Strategy strat = Strategy.getStrategy();
        strat.setCountCurrent(7);

        Problem p = new Problem();
        p.setPossibleValue(3);
        p.setCodification(new TestCodification());
        strat.setProblem(p);

        ProbabilisticSampling ps = new ProbabilisticSampling();

        List<State> fathers = new ArrayList<>();
        // Create 2 fathers each with code size 2
        for (int i = 0; i < 2; i++) {
            State s = new State();
            ArrayList<Object> code = new ArrayList<>();
            code.add(0);
            code.add(1);
            s.setCode(code);
            fathers.add(s);
        }

        // listState
        List<State> lst = ps.listState(5);
        assertEquals(5, lst.size());
        for (State st : lst) {
            assertEquals(7, st.getNumber());
            assertEquals(GeneratorType.DistributionEstimationAlgorithm, st.getTypeGenerator());
        }

        // sampling should produce countInd states each with code size equal to fathers.get(0).getCode().size()
        List<State> out = ps.sampling(fathers, 4);
        assertEquals(4, out.size());
        for (State st : out) {
            assertEquals(fathers.get(0).getCode().size(), st.getCode().size());
        }
    }
}
 
