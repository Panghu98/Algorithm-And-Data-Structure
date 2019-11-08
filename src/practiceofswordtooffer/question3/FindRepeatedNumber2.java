package practiceofswordtooffer.question3;

/**
 * 在不修改数组的情况下  使用 O(n)的辅助数组
 * @author dengg
 */
public class FindRepeatedNumber2 {

    private int duplicateNumber;

    public int getDuplicateNumber() {
        return duplicateNumber;
    }

    public void swap(int[] arr, int indexX, int indexY){
        int temp = arr[indexX];
        arr[indexX] = arr[indexY];
        arr[indexY] = temp;
    }

    boolean duplicate(int[] numbers){

        //排除错误条件
        if (numbers.length == 0){
            return true;
        }

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] < 0 || numbers[i] >= numbers.length){
                return false;
            }
        }

        //用于标记数组中某元素是否存在
        int[] flagArr = new int[numbers.length];

        for (int i = 0; i < numbers.length; i++) {

            //当前元素的值
            int value = numbers[i];

            if (flagArr[value] == 1) {
                duplicateNumber = value;
                return true;
            }else {
                flagArr[value] = 1;
            }

        }
        return false;

    }

    public static void main(String[] args) {

        int[] numbers = {1,2,4,5,2,6,0};
        FindRepeatedNumber2 findRepeatedNumber = new FindRepeatedNumber2();
        boolean result = findRepeatedNumber.duplicate(numbers);
        System.err.println(result);
        System.err.println(findRepeatedNumber.getDuplicateNumber());

    }


}
