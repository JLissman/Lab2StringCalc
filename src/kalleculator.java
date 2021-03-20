import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        String[] rawSults = inputNumbers.split("\\|");
        for (String resource :rawSults
        ) {
            if (!resource.equals("|")){
                result.add(parseInt(resource));
             }
        }
        return result;}



    int add(String inputString){
        ArrayList<Integer> numbers;
        int sum = 0;
        String extractNumRegex = "//(.+)\\n([0-9]+.*)";
        Pattern numPat = Pattern.compile(extractNumRegex);
        Matcher numMatch = numPat.matcher(inputString);
        boolean foundNum = numMatch.matches();
        String regexForMultipleDelims = "//\\[(.*)]*\n(.*)";
        Pattern multiDelimPattern = Pattern.compile(regexForMultipleDelims);
        Matcher multiDelimMatch = multiDelimPattern.matcher(inputString);
        boolean foundMultiDelim = multiDelimMatch.matches();
        if (foundMultiDelim){
            System.out.println("found multidelim add");
            String rawDelim = numMatch.group(1);
            String[] rawDelimList = rawDelim.split("]\\[");
            for (String delim:rawDelimList) {
                delim = delim.replace("[","").replace("]","");
                addDelims(delim);
            }
            numbers = getNumbersFromString(numMatch.group(2));

        }else if(foundNum) {
            System.out.println("found singledelim add");
            String rawDelim = numMatch.group(1);
            rawDelim.replace("[", "").replace("]", "");
            addDelims(rawDelim);
            numbers = getNumbersFromString(numMatch.group(2));
        }else{
            numbers = getNumbersFromString(inputString);
        }

        sum = sumNum(numbers);

        return sum;
    }

    public Integer sumNum(ArrayList<Integer> numbers) {
        int sum=0;
        String negativeNumbers ="";

        for (Integer n:numbers
        ) {
            if(n>999){
                continue;
            }
            else if (n > 0) {
                sum = sum + n;
            }
            else if (n < 0){
                negativeNumbers=negativeNumbers + n +" ";

            }
        }
        if (negativeNumbers.length() > 0){
            throw new RuntimeException("Negative numbers not allowed: "+negativeNumbers);
        }else{
        return sum;
    }}
}
