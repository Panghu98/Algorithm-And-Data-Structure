package practiceofswordtooffer.question38;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author: panghu
 * @Description:
 * @Date: Created in 18:19 2020/4/1
 * @Modified By:
 */
public class Solution_Copy {

    public ArrayList<String> permutation(String str) {

        if (str == null || str.length() == 0) {
            return new ArrayList<>();
        }
        TreeSet<String> set = new TreeSet<>();
        helper(str.toCharArray(),0,set);
        return new ArrayList<>(set);
    }


    private static void helper(char[] arr,int i,Set<String> set) {
        if (i == arr.length) {
            set.add(String.valueOf(arr));
        }

        for (int j = i; j < arr.length; j++) {
            swap(arr,i,j);
            helper(arr, i+1, set);
            swap(arr,i,j);
        }
    }
    public static void swap(char[] s, int i, int j) {
        if (s[i] != s[j]) {
            char temp =s[i];
            s[i] = s[j];
            s[j] = temp;
        }
    }

    public static void main(String[] args) {
        ArrayList<String> arrayList = new Solution().permutation("abcd");
        System.err.println(arrayList.size());
        System.err.println(arrayList);
    }

}
