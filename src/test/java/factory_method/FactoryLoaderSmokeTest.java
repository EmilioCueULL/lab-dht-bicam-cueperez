package factory_method;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class FactoryLoaderSmokeTest {

    @Test
    public void instantiate() {
        FactoryLoader fl = new FactoryLoader();
        assertNotNull(fl);
    }
}
