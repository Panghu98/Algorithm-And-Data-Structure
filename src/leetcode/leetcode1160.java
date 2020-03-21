package leetcode;

import org.junit.Test;

/**
 * @author: panghu
 * @Description:
 * @Date: Created in 21:36 2020/3/17
 * @Modified By:
 */
public class leetcode1160 {

    public int countCharacters(String[] words, String chars) {
        char[] charArr = chars.toCharArray();
        boolean[] alphabets = new boolean[26];
        // 标记出现的字符
        for (int i = 0; i < charArr.length; i++) {
            int index = charArr[i] - 97;
            alphabets[index] = true;
        }

        // 用于记录认识的单词个数
        int counter = 0;
        for (int i = 0; i < words.length; i++) {
            char[] arr = words[i].toCharArray();
            // 循环遍历字符数组
            for (int j = 0; j <= arr.length; j++) {
                // 内循环结束判定
                if (j == arr.length) {
                    counter += arr.length;
                    break;
                }else {
                    int index = arr[j] - 97;
                    if (!alphabets[index]) {
                        break;
                    }else {
                        // 标记被使用
                        alphabets[index] = false;
                    }
                }
            }
        }
        charArr = null;
        chars = null;
        return counter;
    }

    @Test
    public void test() {
        String[] strings = new String[]{"cat","bt","hat","tree"};
        String str = "atach";
        System.out.println(countCharacters(strings,str));
    }

}
