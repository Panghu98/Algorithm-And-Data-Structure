package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author panghu
 * @title: Solution13  昨天没做出来的原因在于  罗马数字转化的数组顺序是相反的
 * @projectName Algorithm_And_Data_Structure
 * @date 19-7-11 下午10:02
 */
public class Solution13 {

    public static int romanToInt(String s) {

        Map<Character, Integer> map = new HashMap<>(10);
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);

        int result = 0;

        char[] character = s.toCharArray();
        for (int i = 0; i < character.length; i++) {
            for (int j=i+1;j < character.length;j++){
                if (map.get(character[j]) > map.get(character[i])){
                    result =result - 2*map.get(character[i]);
                    System.out.println(result);
                    break;
                }
            }

            result += map.get(character[i]);

        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println("最终的结果："+romanToInt("LIIV"));
    }

}
