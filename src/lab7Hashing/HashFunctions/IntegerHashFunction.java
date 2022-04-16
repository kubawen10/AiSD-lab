package lab7Hashing.HashFunctions;

import lab7Hashing.HashFunction;

public class IntegerHashFunction implements HashFunction<Integer> {

    //return squared value if its in range 0;99
    //return squared value without first and last digit if it is larger than 99  eg 3458 returns 45
    @Override
    public int hashCode(Integer object) {
        int sqr = object * object;
        int len = String.valueOf(sqr).length();

        if (len==1 || len==2){
            return sqr;
        }

        //crop first digit
        sqr = Integer.parseInt(Integer.toString(sqr).substring(1));
        //crop last digit
        sqr/=10;
        return sqr;
    }
}
