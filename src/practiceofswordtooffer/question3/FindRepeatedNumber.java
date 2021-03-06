package practiceofswordtooffer.question3;

/**
 * @author dengg
 */
public class FindRepeatedNumber {

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

        for (int i = 0; i < numbers.length; i++) {

            //当当前元素的值不在 对应的索引位置的时候 --该循环的意义在于将获取当前位置的正确值
            while (numbers[i] != i) {
                //当元素对应的索引上的值已存在的时候
                if (numbers[i] == numbers[numbers[i]]) {
                    duplicateNumber = numbers[i];
                    return true;
                }
                //交换位置
                swap(numbers, i, numbers[i]);
            }
        }
        return false;

    }

    public static void main(String[] args) {

        int[] numbers = {1,2,4,5,2,6,0};
        FindRepeatedNumber findRepeatedNumber = new FindRepeatedNumber();
        boolean result = findRepeatedNumber.duplicate(numbers);
        System.err.println(result);
        System.err.println(findRepeatedNumber.getDuplicateNumber());

    }

}
