package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: panghu
 * @Description:
 * @Date: Created in 12:01 2021/1/11
 * @Modified By:
 */
public class Leetcode08_09 {

    private final static char leftChar = '(';

    private final static char rightChar = ')';

    private int size;

    private List<String> resultList = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        StringBuilder result = new StringBuilder();
        size = n*2;
        backtrack(0,result);
        return  resultList;
    }

    private void backtrack(int index ,StringBuilder str) {
        // 验证不通过的，直接返回
        if (!isValid(str.toString())) {
            return;
        }

        if (index == size) {
            resultList.add(str.toString());
            return;
        }

        backtrack(++index,str.append(leftChar));
        str.deleteCharAt(str.length()-1);
        --index;

        backtrack(++index,str.append(rightChar));
        str.deleteCharAt(str.length()-1);
        --index;
    }

    /**
     * 验证括号是否合法
     * @param str
     * @return
     */
    private boolean isValid(String str) {
        char[] chars = str.toCharArray();
        int rightCount = 0;
        int leftCount = 0;
        for (int i = 0; i < chars.length; i++) {
            char currentChar = chars[i];
            if (currentChar == leftChar) {
                ++leftCount;
            }else {
                ++rightCount;
            }

            if (rightCount > leftCount) {
                return false;
            }
        }


        if (str.length() == size) {
            return rightCount == leftCount;
        }else {
            return true;
        }
    }

    @Test
    public void test() {
        List<String> strings = generateParenthesis(3);
        System.err.println(strings.size());
        strings.forEach(System.out::println);
    }

}
