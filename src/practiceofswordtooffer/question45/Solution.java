package practiceofswordtooffer.question45;

import java.util.ArrayList;

/**
 * @author dengg
 */
public class Solution {


    public String PrintMinNumber(int [] numbers) {
        int n;
        StringBuilder s = new StringBuilder();
        ArrayList<Integer> list = new ArrayList<Integer>();
        n = numbers.length;

        for (int i = 0; i < n; i++) {
            //将数组放入arrayList中
            list.add(numbers[i]);
        }
        //实现了Comparator接口的compare方法，将集合元素按照compare方法的规则进行排序
        list.sort((str1, str2) -> {
            String s1 = str1 + "" + str2;
            String s2 = str2 + "" + str1;

            //String的compareTo()方法，从左到右依次排序比较字符（比较的次数取较短字符串的长度）
            return s1.compareTo(s2);
        });

        for (int j : list) {
            s.append(j);
        }
        return s.toString();
    }

    public static void main(String[] args) {
        String str1 = "avdf";
        String str2 = "avcd";
        System.err.println(str1.compareTo(str2));
    }
}
