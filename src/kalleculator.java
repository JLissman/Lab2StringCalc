import java.util.ArrayList;
import java.util.Arrays;

import static java.lang.Integer.parseInt;

public class kalleculator {
    ArrayList<String> delimiters = new ArrayList<>(Arrays.asList(",","\n"));

    public int addDelims(String... newDelimiters) {
        int addedCount = 0;
        for (String delimiter:newDelimiters) {
            System.out.println("Adding delimiter with length of "+delimiter.length());
            delimiters.add(delimiter);
            addedCount++;
        }
        System.out.println("Delimiters are now :");
        for (String delim:delimiters
        ) {
            System.out.println(delim);
        }
        System.out.println("-------------------");
        return(addedCount);
    }


    public ArrayList<Integer> getNumbersFromString(String inputNumbers) {
        ArrayList<Integer> result = new ArrayList<>();
        for (String delim:delimiters
        ) {
            inputNumbers = inputNumbers.replace(delim,"|");

        }
        String[] rawSults = inputNumbers.split("|");
        for (String resource :rawSults
        ) {
            if (!resource.equals("|")){
                result.add(parseInt(resource));
            }
        }
        return result;}



    int add(String s){
        ArrayList<Integer> nums = new ArrayList();
        int sum = 0;
        
        nums = getNumbersFromString(s);
        sum = sumNum(nums);

        return sum;
    }

    public Integer sumNum(ArrayList<Integer> numbers) {
        int sum=0;
        for (Integer n:numbers
        ) {
            sum = sum+n;
        }
        return sum;
    }
}
