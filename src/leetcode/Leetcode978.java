package leetcode;

import org.junit.Test;

/**
 * @author: panghu
 * @Description:
 * @Date: Created in 20:52 2021/2/8
 * @Modified By:
 */
public class Leetcode978 {

    public int maxTurbulenceSize(int[] arr) {
        int[] compareArr = new int[arr.length -1];
        for (int i = 0; i < arr.length -1; i++) {
            compareArr[i] = arr[i] > arr[i + 1]? 1 : 0 ;
        }

        int maxStreamSize = 1;
        int maxLengthIndex = 1;

        for (int i = 0; i < compareArr.length -1; i++) {

            int maxLength =
                    findPalindrome(i, i + 1, compareArr);

            if (maxLength > maxStreamSize) {
                if (maxLength % 2 == 0) {
                    maxLengthIndex = i + 1;
                }else {
                    maxLengthIndex += 2;
                }
                maxStreamSize = maxLength;
            }

        }

        return maxLengthIndex;

    }


    private int findPalindrome(int left,int right,int[] arr) {
        int length ;

        if (left == right) {
            length = 1;
        }else {
            if (arr[left] != arr[right]) {
                return 0;
            }
            length = 2;
        }

        left--;
        right++;

        while (left >= 0&&right <= arr.length -1 && arr[left] == arr[right] ) {
            length += 2;
            left--;
            right++;
        }

        return length;
    }

    @Test
    public void test() {
        System.out.println(maxTurbulenceSize(new int[]{4,8,12,16}));
    }

}
