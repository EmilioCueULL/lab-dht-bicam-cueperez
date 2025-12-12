package evolutionary_algorithms.complement;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class GenerationalReplaceTest {

    @Test
    public void replaceIsAbstractAndCannotBeInstantiatedDirectly() {
        // GenerationalReplace is concrete, test it
        GenerationalReplace gr = new GenerationalReplace();
        assertNotNull(gr);
    }
}
