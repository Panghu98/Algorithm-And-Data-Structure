package leetcode;

/**
 * @author panghu
 * @title: Solution9
 * @projectName Algorithm_And_Data_Structure
 * @date 19-7-10 下午7:24
 */
public class Solution9 {

    public static boolean isPalindrome(int x) {
        int rev = 0;
        int temp = x;
        while (x != 0){

            int pop = x % 10;
            x = x/10;
            rev = rev * 10 + pop;
        }
        return rev==temp;

    }

    public static void main(String[] args) {
        int x = 121;
        System.out.println(isPalindrome(x));
    }

}
