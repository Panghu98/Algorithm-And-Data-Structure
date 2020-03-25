package leetcode_tencent;

import org.junit.Test;

/**
 * @author: panghu
 * @Description:
 *
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1:
 *
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 *
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 *
 * 所有输入只包含小写字母 a-z 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-common-prefix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date: Created in 18:25 2020/3/25
 * @Modified By:
 */
public class Solution14 {

    public String longestCommonPrefix(String[] strs) {

        if (strs == null ||strs.length == 0) {
            return "";
        }

        if (strs.length == 1) {
            return strs[0];
        }

        // 统计字符串的最短长度
        int minLength = Integer.MAX_VALUE;
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].length() < minLength) {
                minLength = strs[i].length();
            }
        }


        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < minLength; i++) {
            // j从1开始。所以要少减去一位
            int length = strs.length -1;
            // 相同的字符
            char prefix = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].charAt(i) == prefix) {
                    length--;
                }
            }

            if (length == 0) {
                stringBuilder.append(prefix);
            }else {
                break;
            }
        }
        return stringBuilder.toString();

    }

    @Test
    public void test() {
        String[] strings = new String[]{"dog","racecar","car"};
        System.out.println(longestCommonPrefix(strings));
    }

}
