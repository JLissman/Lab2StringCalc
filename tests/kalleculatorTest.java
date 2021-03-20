import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class kalleculatorTest {

    @Test
    void add() {
        kalleculator calc = new kalleculator();

        int actualValue = calc.add("1,2,3");
        int expectedValue = 6;

        assertEquals(actualValue,expectedValue);

    }
}