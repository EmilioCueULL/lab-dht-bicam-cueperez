package metaheurictics.strategy;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

import org.junit.jupiter.api.Test;

import metaheuristics.generators.Generator;
import metaheuristics.generators.GeneratorType;
import metaheuristics.generators.MultiGenerator;
import problem.definition.State;

public class StrategyDeepTest {

    static class FakeGenerator extends Generator {
        private GeneratorType type;
        private float weight = 1f;
        private float[] trace = new float[10];
        private List<State> refList = new ArrayList<>();
        private List<State> sonList = new ArrayList<>();
        private int[] listCountGender = new int[10];
        private int[] listCountBetterGender = new int[10];

        public FakeGenerator(GeneratorType t){ this.type = t; }

        @Override
        public State generate(Integer operatornumber) { return new State(); }

        @Override
        public void updateReference(State stateCandidate, Integer countIterationsCurrent) { }

        @Override
        public State getReference() { return new State(); }

        @Override
        public void setInitialReference(State stateInitialRef) { }

        @Override
        public GeneratorType getType() { return type; }

        @Override
        public List<State> getReferenceList() { return refList; }

        @Override
        public List<State> getSonList() { return sonList; }

        @Override
        public boolean awardUpdateREF(State stateCandidate) { return false; }

        @Override
        public void setWeight(float weight) { this.weight = weight; }

        @Override
        public float getWeight() { return this.weight; }

        @Override
        public float[] getTrace() { return trace; }

        @Override
        public int[] getListCountBetterGender() { return listCountBetterGender; }

        @Override
        public int[] getListCountGender() { return listCountGender; }
    }

    @Test
    public void testGetListKeyAndUpdateWeightAndCountGenderAndOffline() throws Exception {
        Strategy.destroyExecute();
        Strategy strat = Strategy.getStrategy();

        // prepare mapGenerators for getListKey
        SortedMap<GeneratorType, Generator> map = new TreeMap<>();
        map.put(GeneratorType.RandomSearch, new FakeGenerator(GeneratorType.RandomSearch));
        map.put(GeneratorType.GeneticAlgorithm, new FakeGenerator(GeneratorType.GeneticAlgorithm));
        strat.mapGenerators = map;

        // getListKey
        assertEquals(2, strat.getListKey().size());

        // prepare MultiGenerator list for updateWeight and updateCountGender
        FakeGenerator[] arr = new FakeGenerator[2];
        arr[0] = new FakeGenerator(GeneratorType.RandomSearch);
        arr[1] = new FakeGenerator(GeneratorType.GeneticAlgorithm);
        arr[0].setWeight(5f);
        arr[1].setWeight(7f);
        // set some countGender values
        arr[0].countGender = 3;
        arr[1].countGender = 2;
        arr[0].countBetterGender = 1;
        arr[1].countBetterGender = 4;

        // set arrays lengths
        arr[0].getListCountGender()[0] = 10;
        arr[1].getListCountGender()[0] = 20;
        arr[0].getListCountBetterGender()[0] = 100;
        arr[1].getListCountBetterGender()[0] = 200;

        // assign to MultiGenerator
        MultiGenerator.setListGenerators(arr);

        // set periodo via reflection to 0
        Field periodoField = Strategy.class.getDeclaredField("periodo");
        periodoField.setAccessible(true);
        periodoField.setInt(strat, 0);

        // call updateCountGender
        strat.updateCountGender();

        assertEquals(0, arr[0].countGender);
        assertEquals(0, arr[1].countGender);
        assertEquals(13, arr[0].getListCountGender()[0]);
        assertEquals(22, arr[1].getListCountGender()[0]);

        // test updateWeight sets weights to 50 for non-multi generators
        strat.updateWeight();
        assertEquals(50.0f, arr[0].getWeight());
        assertEquals(50.0f, arr[1].getWeight());

        // test calculateOffLinePerformance
        strat.countPeriodChange = 5;
        strat.calculateOffLinePerformance(25f, 0);
        assertEquals(5f, strat.listOfflineError[0]);
    }
}
