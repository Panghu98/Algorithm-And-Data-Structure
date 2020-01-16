package practiceofswordtooffer.question58;

public class Solution1 {

    public String ReverseSentence(String str) {

        str = reverse(str);

        StringBuilder stringBuilder = new StringBuilder();

        int pStart = 0;
        int pEnd = 0;
        while (pEnd < str.length()) {

            if (str.charAt(pEnd) == ' ') {
                //截取字符串

                //添加空格
                stringBuilder.append(" ");
                stringBuilder.append(reverse(str.substring(pStart,pEnd)));
                pStart = pEnd+1;
            }

            if (pEnd == str.length() -1) {
                stringBuilder.append(" ");
                // ++pEnd才是最后一位
                stringBuilder.append(reverse(str.substring(pStart,++pEnd)));
            }

            pEnd ++;

        }

        str = null;
        return stringBuilder.toString();
    }


    private String reverse(String str) {
        //输入验证
        if (str == null) {
            throw new NullPointerException();
        }

        //空串或者是只有一个长度的字符串直接返回
        if (str.length() < 2) {
            return str;
        }

        //字符串的长度
        int length = str.length();

        StringBuilder stringBuilder = new StringBuilder();

        //第一步，翻转字符串
        for (int i = length-1;i >= 0; i--) {
            stringBuilder.append(str.charAt(i));
        }

        str = stringBuilder.toString();

        //帮助GC
        stringBuilder = null;

        return str;
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        System.err.println(solution1.ReverseSentence("I am a student."));
    }

}
