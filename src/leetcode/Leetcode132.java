package leetcode;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author: panghu
 * @Description:
 * @Date: Created in 13:39 2021/3/8
 * @Modified By:
 */
public class Leetcode132 {




    int minCut;

    int length;

    int[][] f;

    public int minCut(String s) {
        minCut = s.length();
        length = s.length();
        f = new int[length][length];

        dfs(s,0,0);

        return minCut - 1;
    }

    public void dfs(String s,int i,int cutCount) {
        if (i == length) {
            minCut = Math.min(minCut,cutCount);
        }

        for (int j = i; j < length; j++) {
            if (isPalindrome(s, i, j) == 1 ){
                dfs(s,j + 1, ++cutCount);
                cutCount--;
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


    public int minCut2(String s) {
        if(s == null || s.length() <= 1)
            return 0;
        int len = s.length();
        int dp[] = new int[len];
        Arrays.fill(dp, len-1);
        for(int i = 0; i < len; i++){
            // 注意偶数长度与奇数长度回文串的特点
            mincutHelper(s , i , i , dp);  // 奇数回文串以1个字符为中心
            mincutHelper(s, i , i+1 , dp); // 偶数回文串以2个字符为中心
        }
        return dp[len-1];
    }
    private void mincutHelper(String s, int i, int j, int[] dp){
        int len = s.length();
        while(i >= 0 && j < len && s.charAt(i) == s.charAt(j)){
            dp[j] = Math.min(dp[j] , (i==0?-1:dp[i-1])+1);
            i--;
            j++;
        }
    }

    @Test
    public void test() {
        System.out.println(minCut2("abaDbCabab"));
    }

}
