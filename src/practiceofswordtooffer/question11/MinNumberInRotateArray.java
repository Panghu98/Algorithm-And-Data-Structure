package practiceofswordtooffer.question11;

/**
 * @author panghu
 *
 * 判断最小值的存在有两种方式  左边大于右边(最小值的位置)，右边大于左边（最小值的位置）
 */
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

    public static int minNumberInRotateArray2(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException();
        }

        if (nums.length == 1) {
            return nums[0];
        }

        int right = nums.length-1;
        int left = 0;
        while(left <= right) {

            if (nums[left] > nums[right]) {
                return nums[right];
            }

            int middle = (left + right) /2;
            // 当最小数在右边 {7,8,1,2,3,4,5}

            if (middle >= 1 && nums[middle-1] > nums[middle]) {
                return nums[middle];
            }



            if (nums[middle]  > nums[middle+1]) {
                return nums[middle+1];
            }

            if (nums[middle] < nums[left]) {
                right = middle+1;
                //当最小数在左边 {3,4,5,6,1,2}
            }else {
                left = middle-1;
            }
        }
        return -1;

    }

    public static void main(String[] args) {
        int[] nums = {5, 5, 5, 6, 7, 1, 2, 3, 4, 5};
        int min = minNumberInRotateArray2(nums);
        System.err.println(min);
    }
}
