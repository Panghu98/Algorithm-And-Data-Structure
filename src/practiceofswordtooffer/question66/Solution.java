package practiceofswordtooffer.question66;

import org.junit.Test;

import java.util.Arrays;

public class Solution {

    public int[] multiply(int[] A) {
        if(A==null)
            return null;
        int length=A.length;
        int[] B=new int[length];
        B[0]=1;
        //计算左三角
        for(int i=1;i<length;i++){
            B[i]=B[i-1]*A[i-1];
        }
        //计算右三角   temp用来记录有三角每一行的值
        int temp=1;
        for(int i=length-2;i>=0;i--){
            temp*=A[i+1];
            B[i]*=temp;
        }
        return B;
    }

    @Test
    public void test() {
        int[] arr = {1,2,3,4,5,6};
        System.err.println(Arrays.toString(multiply(arr)));
    }


}
