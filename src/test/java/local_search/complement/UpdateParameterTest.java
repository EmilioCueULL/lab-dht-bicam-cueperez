package local_search.complement;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class UpdateParameterTest {

    @Test
    public void incrementsValue() throws Exception {
        Integer in = 0;
        Integer out = UpdateParameter.updateParameter(in);
        assertEquals(Integer.valueOf(1), out);
    }
}
