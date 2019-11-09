package practiceofswordtooffer.question3;

/**
 *  使用辅助数组（不改变原数组中的元素），并且降低空间度
 */
public class FindRepeatedNumber3 {

    private int duplicateNumber;


    public int getDuplicateNumber() {
        return duplicateNumber;
    }

    public void swap(int[] arr, int indexX, int indexY){
        int temp = arr[indexX];
        arr[indexX] = arr[indexY];
        arr[indexY] = temp;
    }

    int duplicate(int[] numbers){

        int start = 0;
        int end = numbers.length-1;
        while (end >= start){
            //使用位移运算符运算速度会更快
            int middle = (end - start)>>1+start;
            int count = countRange(numbers,numbers.length,start,middle);
            if (end == start){
                if (count > 1){
                    //返回start和end都是一样的效果
                    return start;
                }else {
                    break;
                }
            }
            if (count > (middle-start+1)){
                // 继续循环 ，范围在前半部分
                end = middle;
            }else {
                //继续循环 ，范围在后半部分
                start = middle +1;
            }

        }
        return -1;
    }

    int countRange(int[] numbers,int length,int start,int end){
        int count = 0;
        for (int i = 0; i < length; i++) {
            if (numbers[i] >= start && numbers[i] <= end){
                ++count;
            }
        }
        return count;
    }

    public static void main(String[] args) {

        int[] numbers = {0,1,1,3,4,5,6,7,7,9};
        FindRepeatedNumber3 findRepeatedNumber = new FindRepeatedNumber3();
        int result = findRepeatedNumber.duplicate(numbers);
        System.err.println(result);
        System.err.println(findRepeatedNumber.getDuplicateNumber());

    }

}
