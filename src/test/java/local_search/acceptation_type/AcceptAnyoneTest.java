package local_search.acceptation_type;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class AcceptAnyoneTest {

    @Test
    public void instantiation() {
        AcceptAnyone aa = new AcceptAnyone();
        assertNotNull(aa);
    }
}
