package problem.definition;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ObjetiveFunctionTest {

    static class LocalFunc extends ObjetiveFunction {
        @Override
        public Double Evaluation(State state) {
            return 2.0;
        }
    }

    @Test
    public void weightAndType() {
        LocalFunc f = new LocalFunc();
        f.setWeight(1.5f);
        assertEquals(1.5f, f.getWeight());
        f.setTypeProblem(Problem.ProblemType.Maximizar);
        assertEquals(Problem.ProblemType.Maximizar, f.getTypeProblem());
    }
}
