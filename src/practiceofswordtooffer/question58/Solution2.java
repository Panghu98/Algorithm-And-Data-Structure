package practiceofswordtooffer.question58;

import org.junit.Test;

public class Solution2 {

    public String LeftRotateString(String str,int n) {
        //参数验证
        if (n > str.length()) {
            throw new IllegalArgumentException();
        }

        //这两种情况反转后的结果不变
        if (n == 0 || n == str.length()) {
            return str;
        }

        return move(str,n-1);

    }

    /**
     * 字符串左旋核心
     * @param str 字符串
     * @param start 开始点
     * @return 左旋完毕的字符串
     */
    private String move(String str,int start) {
        //需要被移到后边的字符串
        String str1 = str.substring(0,start+1);
        //向前移动的字符串
        String str2 = str.substring(start+1);

        StringBuilder stringBuilder = new StringBuilder();

        for (int j = 0; j < str2.length(); j++) {
            stringBuilder.append(str2.charAt(j));
        }

        for (int i = 0; i < str1.length(); i++) {
            stringBuilder.append(str1.charAt(i));
        }

        //help gc
        str1 = str1 = str2 = null;

        return stringBuilder.toString();
    }

    @Test
    public void test() {
        System.err.println(LeftRotateString("abcdefg",2));
    }

}
