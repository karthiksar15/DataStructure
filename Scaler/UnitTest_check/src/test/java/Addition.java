import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


public class Addition {

    @Test
    public void add() {
        var obj = new AdditionMain();
        assertEquals(4, obj.sum(2, 2));
    }
}