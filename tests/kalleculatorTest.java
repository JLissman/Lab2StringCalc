import jdk.swing.interop.SwingInterOpUtils;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import static org.junit.jupiter.api.Assertions.*;

class kalleculatorTest {

    @Test
    void addTest() {
        kalleculator calc = new kalleculator();

        int actualValue = calc.add("1,2");
        int expectedValue = 3;

        assertEquals(expectedValue,actualValue);

    }
    @Test
    void testRandomAmountOfNumbers(){
        kalleculator calc = new kalleculator();
        Random rng = new Random();
        String testNumbers = "";
        int expectedValue = 0;
        int rotations = rng.nextInt(20);
        System.out.println("Testing with " + rotations + " numbers");
        for (int i = 0; i < rotations; i++) {

            if (i == rotations - 1) {
                //dont add last comma to string
                int ranNum = rng.nextInt(9);
                testNumbers = testNumbers + ranNum;
                expectedValue+=ranNum;
            }else{
                int ranNum = rng.nextInt(9);
                testNumbers = testNumbers + ranNum + ",";
                expectedValue+=ranNum;
            }}
        System.out.println("Argument string is now "+testNumbers);
        System.out.println("Expected result is "+expectedValue);
            int actualValue = calc.add(testNumbers);

            assertEquals(expectedValue,actualValue);
        }


        @Test
        void testNewDelim(){
        kalleculator calc = new kalleculator();

        int actualValue = calc.add("1,2\n3");
        int expectedValue = 6;

        assertEquals(expectedValue,actualValue);





        }

        @Test
        void testgetNumbersFromString(){
        kalleculator calc = new kalleculator();

        ArrayList<Integer> actualResult = calc.getNumbersFromString("1,2\n3");
        //we expect that the length of the arraylist is 3.
        int expectedResult = 3;
        //
        assertEquals(expectedResult,actualResult.size());


        }

        @Test
        void addNewDelimsTest(){
            kalleculator calc = new kalleculator();

            //return numbers of added delims
            int actualResult = calc.addDelims(";");
            int expectedResult = 1;

            assertEquals(expectedResult,actualResult);

        }
        @Test
        void addMultipleNewDelims(){
            kalleculator calc = new kalleculator();

            //returns numbers of added delims
            int actualResult = calc.addDelims(";","K","d");
            int expectedResult = 3;

            assertEquals(expectedResult,actualResult);

        }
        @Test
        void addLongerNewDelimiter(){ kalleculator calc = new kalleculator();

            //returns numbers of added delims
            int actualResult = calc.addDelims(";;");
            int expectedResult = 1;

            assertEquals(expectedResult,actualResult);}





        @Test
        void sumNumTest(){
            kalleculator calc = new kalleculator();
            ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(1,2,3));
            //returns numbers of added delims
            int actualResult = calc.sumNum(numbers);
            int expectedResult = 6;

            assertEquals(expectedResult,actualResult);

        }
        @Test
        void testAddDelimFromAddMethod(){
            kalleculator calc = new kalleculator();
            //returns numbers of added delims
            int actualResult = calc.add("//;\n1,2;3");
            int expectedResult = 6;

            assertEquals(expectedResult,actualResult);


    }
    }

