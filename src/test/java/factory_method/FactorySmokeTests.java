package factory_method;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class FactorySmokeTests {

    @Test
    public void instantiateFactories() {
        FactoryGenerator fg = new FactoryGenerator();
        FactoryLoader fl = new FactoryLoader();
        FactorySampling fs = new FactorySampling();
        FactoryMutation fm = new FactoryMutation();
        FactoryReplace fr = new FactoryReplace();

        assertNotNull(fg);
        assertNotNull(fl);
        assertNotNull(fs);
        assertNotNull(fm);
        assertNotNull(fr);
    }
}
