package practiceofswordtooffer.question5;

import org.junit.Test;

public class ReplaceBlankSpace {

    public String replaceBlankSpace(StringBuffer stringBuffer) {

        if (stringBuffer == null) {
            throw new IllegalArgumentException("传入参数错误");
        }

        int length = stringBuffer.length();
        int indexOfOriginal = length - 1;
        for (int i = 0; i <= indexOfOriginal; i++) {
            if (stringBuffer.charAt(i) == ' ') {
                length += 2;
            }
        }

        //更新字符数组的长度
        stringBuffer.setLength(length);

        int indexOfNew = length - 1;
        for (int i = indexOfOriginal; i >= 0; i--) {
            if (stringBuffer.charAt(i) != ' '){
                stringBuffer.setCharAt(indexOfNew--,stringBuffer.charAt(i));
            }else {
                stringBuffer.setCharAt(indexOfNew--,'0');
                stringBuffer.setCharAt(indexOfNew--,'2');
                stringBuffer.setCharAt(indexOfNew--,'%');
            }
        }
        return stringBuffer.toString();
    }

    public static String replaceBlankSpace2(StringBuffer stringBuffer) {
        int length = stringBuffer.length();
        int newLength = length;
        for (int i = 0; i < length; i++) {
            if (stringBuffer.charAt(i) == ' ') {
                newLength += 2;
            }
        }

        stringBuffer.setLength(newLength);

        //从末尾开始设置字符
        int index = newLength-1;

        for (int i = length-1; i >= 0; i--) {
            if (stringBuffer.charAt(i) == ' ') {
                stringBuffer.setCharAt(index--,'0');
                stringBuffer.setCharAt(index--,'2');
                stringBuffer.setCharAt(index--,'%');
            }else {
                stringBuffer.setCharAt(index--,stringBuffer.charAt(i));
            }
        }

        return stringBuffer.toString();
    }

    /**
     * 输入字符串为首尾空格，中间连续空格
     */
    @Test
    public void test4() {
        System.out.print("Test4：");
        StringBuffer sBuffer = new StringBuffer(" a b  c  ");
        String s = replaceBlankSpace2(sBuffer);
        System.out.println(s);
    }

}
