package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: panghu
 * @Description:
 * @Date: Created in 9:52 2021/3/7
 * @Modified By:
 */
public class Leetcode131 {

    @Test
    public void test() {
        List<List<String>> lists = partition("aab");
        System.out.println(lists);
    }

    int[][] f;

    List<List<String>> lists = new ArrayList<>();

    List<String> list = new ArrayList<>();

    int length;

    public List<List<String>> partition(String s) {
        String[] items = s.split("");
        length = items.length;
        f = new int[length][length];

        dfs(s,0);
        return lists;
    }

    private void dfs(String s,int i) {
        if (i == length) {
            lists.add(new ArrayList<>(list));
            return;
        }

        for (int j = i; j < length; j++) {
            if (isPalindrome(s,i,j) == 1) {
                list.add(s.substring(i,j + 1));
                // 下一节字符串
                dfs(s,j + 1);
                list.remove(list.size() - 1);
            }
        }

    }

    /**
     *
     * @param s
     * @param i 左边
     * @param j 右边
     * @return
     */
    private int isPalindrome(String s, int i, int j) {
        if (f[i][j] != 0) {
            return f[i][j];
        }

        // 相互重合，回文串形成
        if (i >= j) {
            f[i][j] = 1;
        }else if (s.charAt(i) == s.charAt(j)) {
            f[i][j] = isPalindrome(s,i + 1,j -1);
        }else {
            f[i][j] = -1;
        }

        return f[i][j];
    }




}
