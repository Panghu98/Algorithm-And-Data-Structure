package leetcode;

/**
 * @author: panghu
 * @Description:
 * @Date: Created in 18:01 2020/12/30
 * @Modified By:
 */
public class LeetCode1306 {

    public boolean canReach(int[] arr, int start) {
        return dfs(arr, start, 0);
    }

    public boolean dfs(int[] arr, int start, int step){
        if (start < 0 || start >= arr.length) return false;
        if (step == arr.length) return false;
        if (arr[start] == 0) return true;

        return dfs(arr, start - arr[start], step + 1) || dfs(arr, start + arr[start], step + 1);
    }

}
