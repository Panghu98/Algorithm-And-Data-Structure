package practiceofswordtooffer.question64;

import org.junit.Test;

public class Solution {

    public long getSum(int num) {

        if (num == 0) {
            return 0;
        }

        return (long) ((num+1)*(num/2.0));
    }

    @Test
    public void  test() {
        System.err.println(getSum(1));
    }

}
