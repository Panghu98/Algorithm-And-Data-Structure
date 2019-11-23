package practiceofswordtooffer.question11;

public class MinNumberInRotateArray {

    public static int minNumberInRotateArray(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[l] < nums[r]) {
                return nums[r];
            }

            // 4 5 1 2 3
            //当n比n右边大的时候，说明是n+1最小值
            if (nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            }

            //当n比n左边小的时候，说明n是最小值
            if (nums[mid] < nums[mid - 1]) {
                return nums[mid];
            }

            //用于确定当前段为较小段还是较大段
            if (nums[mid] < nums[0]) {
                //较小段选择左边
                r = mid + 1;
            } else {
                //较大段选择右边
                l = mid - 1;
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {5, 5, 5, 6, 7, 1, 2, 3, 4, 5};
        int min = minNumberInRotateArray(nums);
        System.err.println(min);
    }
}
