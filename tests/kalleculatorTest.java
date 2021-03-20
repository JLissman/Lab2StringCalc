import jdk.swing.interop.SwingInterOpUtils;
import org.junit.jupiter.api.Test;
import java.util.Random;
import static org.junit.jupiter.api.Assertions.*;

class kalleculatorTest {

    @Test
    void addTest() {
        kalleculator calc = new kalleculator();

        int actualValue = calc.add("1,2");
        int expectedValue = 6;

        assertEquals(actualValue,expectedValue);

    }
    @Test
    void testRandomAmountOfNumbers(){
        kalleculator calc = new kalleculator();
        Random rng = new Random();
        String testNumbers = "";
        int expectedResult = 0;
        int rotations = rng.nextInt(20);
        System.out.println("Testing with " + rotations + " numbers");
        for (int i = 0; i < rotations; i++) {
            //dont add last comma
            if (i == rotations - 1) {
                int ranNum = rng.nextInt(9);
                testNumbers = testNumbers + ranNum;
                expectedResult+=ranNum;
            }else{
                int ranNum = rng.nextInt(9);
                testNumbers = testNumbers + ranNum + ",";
                expectedResult+=ranNum;
            }}
        System.out.println("Argument string is now "+testNumbers);
            int actualValue = calc.add(testNumbers);

            assertEquals(actualValue,expectedResult);
        }


    }

