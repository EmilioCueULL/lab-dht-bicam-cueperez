package es.ull.biciam;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({
    // Factory Tests (8)
    FactoryCrossoverTest.class,
    FactoryMutationTest.class,
    FactoryFatherSelectionTest.class,
    FactoryReplaceTest.class,
    FactoryAcceptCandidateTest.class,
    FactoryCandidateTest.class,
    FactoryDistributionTest.class,
    FactorySamplingTest.class,
    
    // Enum Tests (3)
    EvolutionaryAlgorithmEnumsTest.class,
    LocalSearchEnumsTest.class,
    LocalSearchComplementEnumsTest.class,
    
    // Core Classes Tests (5)
    StateTest.class,
    ProblemTest.class,
    OperatorTest.class,
    ProbabilityAndRangeTest.class,
    CandidateValueTest.class,
    
    // Local Search Tests (2)
    TabuSolutionsTest.class,
    SearchCandidateTest.class,
    
    // Genetic Operations Tests (3)
    GeneticOperationsTest.class,
    ReplacementTest.class,
    SelectionTest.class,
    
    // Problem Evaluation Tests (1)
    ProblemEvaluationTest.class,
    
    // Integration Tests (1)
    IntegrationTest.class,
    
    // Convergence Tests (1)
    ConvergenceTest.class,
    
    // Edge Case Tests (1)
    EdgeCaseTest.class,
    
    // Problem Operators Tests (1)
    MutationOperatorTest.class
})
public class TestSuite {
    // This class remains empty, serves as test suite entry point
}
