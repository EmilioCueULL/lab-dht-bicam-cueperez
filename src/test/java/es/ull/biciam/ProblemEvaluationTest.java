package es.ull.biciam;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import problem.definition.Problem;
import problem.definition.Problem.ProblemType;
import problem.definition.State;

@DisplayName("Problem Evaluation Tests")
public class ProblemEvaluationTest {

    private Problem problem;
    private State solution;

    @BeforeEach
    public void setUp() {
        problem = new Problem();
        ArrayList<Object> code = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            code.add(i);
        }
        solution = new State(code);
    }

    @Test
    @DisplayName("Test maximization problem setup")
    public void testMaximizationProblem() {
        problem.setTypeProblem(ProblemType.Maximizar);
        assertEquals(ProblemType.Maximizar, problem.getTypeProblem(), 
                     "Problem type should be Maximizar");
    }

    @Test
    @DisplayName("Test minimization problem setup")
    public void testMinimizationProblem() {
        problem.setTypeProblem(ProblemType.Minimizar);
        assertEquals(ProblemType.Minimizar, problem.getTypeProblem(), 
                     "Problem type should be Minimizar");
    }

    @Test
    @DisplayName("Test solution initialization")
    public void testSolutionInitialization() {
        assertNotNull(solution, "Solution should not be null");
        assertEquals(5, solution.getCode().size(), "Solution should have 5 genes");
    }

    @Test
    @DisplayName("Test solution evaluation assignment")
    public void testSolutionEvaluationAssignment() {
        ArrayList<Double> evaluation = new ArrayList<>();
        evaluation.add(100.0);
        solution.setEvaluation(evaluation);
        
        assertNotNull(solution.getEvaluation(), "Evaluation should not be null");
        assertEquals(100.0, solution.getEvaluation().get(0), "Evaluation should be 100.0");
    }

    @Test
    @DisplayName("Test multiple objectives evaluation")
    public void testMultipleObjectivesEvaluation() {
        ArrayList<Double> evaluation = new ArrayList<>();
        evaluation.add(100.0);
        evaluation.add(50.0);
        evaluation.add(75.0);
        solution.setEvaluation(evaluation);
        
        assertEquals(3, solution.getEvaluation().size(), "Solution should have 3 objectives");
        assertEquals(100.0, solution.getEvaluation().get(0));
        assertEquals(50.0, solution.getEvaluation().get(1));
        assertEquals(75.0, solution.getEvaluation().get(2));
    }

    @Test
    @DisplayName("Test comparison of two solutions")
    public void testSolutionComparison() {
        ArrayList<Object> code1 = new ArrayList<>();
        code1.add(1);
        code1.add(2);
        State sol1 = new State(code1);
        ArrayList<Double> eval1 = new ArrayList<>();
        eval1.add(50.0);
        sol1.setEvaluation(eval1);
        
        ArrayList<Object> code2 = new ArrayList<>();
        code2.add(1);
        code2.add(2);
        State sol2 = new State(code2);
        ArrayList<Double> eval2 = new ArrayList<>();
        eval2.add(100.0);
        sol2.setEvaluation(eval2);
        
        assertTrue(sol1.getEvaluation().get(0) < sol2.getEvaluation().get(0), 
                   "First solution should have lower evaluation");
    }

    @Test
    @DisplayName("Test problem variable count")
    public void testProblemVariableCount() {
        problem.setPossibleValue(10);
        assertEquals(10, problem.getPossibleValue(), "Possible values should be 10");
    }

    @Test
    @DisplayName("Test solution feasibility")
    public void testSolutionFeasibility() {
        ArrayList<Object> feasibleCode = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            feasibleCode.add(i % 10); // Values between 0-9
        }
        State feasibleSolution = new State(feasibleCode);
        
        assertNotNull(feasibleSolution.getCode(), "Code should not be null");
        assertTrue(feasibleSolution.getCode().size() > 0, "Code should not be empty");
    }

    @Test
    @DisplayName("Test solution evaluation comparison")
    public void testEvaluationComparison() {
        ArrayList<Double> eval1 = new ArrayList<>();
        eval1.add(50.0);
        
        ArrayList<Double> eval2 = new ArrayList<>();
        eval2.add(100.0);
        
        State s1 = new State(new ArrayList<>());
        s1.setEvaluation(eval1);
        
        State s2 = new State(new ArrayList<>());
        s2.setEvaluation(eval2);
        
        assertTrue(s1.getEvaluation().get(0) < s2.getEvaluation().get(0), 
                   "s1 evaluation should be less than s2");
    }
}
