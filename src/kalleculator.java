import static java.lang.Integer.parseInt;

public class kalleculator {



    int add(String s){
        String[] nums = s.split(",");
        int parsedNum = 0;
        int sum = 0;
        for (String num:nums
             ) {
            if(!num.equals("")){
                parsedNum = parseInt(num);
                sum = sum+parsedNum;
            }
        }
        return sum;
    }

}
