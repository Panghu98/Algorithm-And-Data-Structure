package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: panghu
 * @Description: https://leetcode-cn.com/problems/is-unique-lcci/
 * @Date: Created in 17:42 2020/12/28
 * @Modified By:
 */
public class Leetcode01_01 {

    public boolean isUnique(String astr) {
        Set<Character> set = new HashSet();
        char[] chars = astr.toCharArray();

        for (char aChar : chars) {
            if (!set.contains(aChar)) {
                set.add(aChar);
            }else {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Leetcode01_01 solution = new Leetcode01_01();
        System.out.println(solution.isUnique("leetcode"));
    }

}
