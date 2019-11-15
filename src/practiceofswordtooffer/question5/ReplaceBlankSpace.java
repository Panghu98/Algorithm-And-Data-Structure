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

    /**
     * 输入字符串为首尾空格，中间连续空格
     */
    @Test
    public void test4() {
        System.out.print("Test4：");
        StringBuffer sBuffer = new StringBuffer(" a b  c  ");
        String s = replaceBlankSpace(sBuffer);
        System.out.println(s);
    }

}
