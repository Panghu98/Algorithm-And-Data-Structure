package labuladong;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: panghu
 * @Description:
 * @Date: Created in 20:07 2021/1/9
 * @Modified By:
 */
public class FullArray {

    private List<List<Integer>> res = new LinkedList<>();

    /* 主函数，输入一组不重复的数字，返回它们的全排列 */
    List<List<Integer>> permute(int[] nums) {
        // 记录「路径」
        LinkedList<Integer> track = new LinkedList<>();
        traceBack(nums,track);

        return res;
    }

    private void traceBack(int[] nums, LinkedList<Integer> track) {
        if (track.size() == nums.length) {
            res.add(new LinkedList<>(track));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // 去除重复的数字
            if (track.contains(nums[i])) {
                continue;
            }
            // 做选择
            track.add(nums[i]);
            //进入下一层的决策树
            traceBack(nums, track);

            //取消选择
            track.removeLast();
        }
    }

    @Test
    public void test() {
        permute(new int[]{1,2,3});
        System.out.println(res);
    }

}
