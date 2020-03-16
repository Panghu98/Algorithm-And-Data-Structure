package practiceofswordtooffer.question58;

import array.Array;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: panghu
 * @Description:
 * @Date: Created in 22:07 2020/3/14
 * @Modified By:
 */
public class Solution_Copy {

    public String sentenceReverse(String string) {
        if (string == null || string.length() == 0) {
            return "";
        }
        int length = string.length();
        ArrayList<String> list = new ArrayList<>(10);
        int start = 0;
        for (int i = 0; i < length; i++) {
            if (string.charAt(i) == ' ') {
                list.add(string.substring(start,i));
                start = i+1;
            }
            if (i == length -1) {
                list.add(string.substring(start,length));
            }
        }

        int left = 0;
        int right = list.size()-1;
        while (left < right) {
            swap(list,left++,right--);
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            stringBuilder.append(list.get(i));
            if (i != list.size()-1) {
                stringBuilder.append(" ");
            }
        }
        string = stringBuilder.toString();
        return string;
    }

    private void swap(ArrayList<String> list,int indexLeft,int indexRight) {
        String temp = list.get(indexLeft);
        list.set(indexLeft,list.get(indexRight));
        list.set(indexRight,temp);
    }

    @Test
    public void test() {
        System.err.println(sentenceReverse("I am a student."));
    }
}
