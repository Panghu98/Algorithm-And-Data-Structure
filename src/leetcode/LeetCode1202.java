package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author: panghu
 * @Description:
 * @Date: Created in 11:30 2021/1/11
 * @Modified By:
 */
public class LeetCode1202 {

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {

        char[] chars = s.toCharArray();
        ArrayList<Character> characters = new ArrayList<>();
        for (char aChar : chars) {
            characters.add(aChar);
        }

        characters.sort(Character::compareTo);

        StringBuilder res = new StringBuilder();
        for (Character character : characters) {
            res.append(character);
        }

        return res.toString();
    }

    private String swap(String str,int left,int right) {
        char[] chars = str.toCharArray();
        char temp = chars[left];
        chars[left] = chars[right];
        chars[right] = temp;

        return new String(chars);
    }

    @Test
    public void test() {
        List<List<Integer>> pairs  = new ArrayList<>();
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(0);
        list1.add(3);
        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(2);
        ArrayList<Integer> list3 = new ArrayList<>();
        list3.add(0);
        list3.add(2);
        pairs.add(list1);
        pairs.add(list2);
        pairs.add(list3);

        String str = smallestStringWithSwaps("dcab", pairs);
        System.err.println(str);
    }


}
