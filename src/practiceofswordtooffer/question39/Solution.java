package practiceofswordtooffer.question39;

import java.util.HashMap;

/**
 * @author dengg
 */
public class Solution {

    public int MoreThanHalfNum_Solution(int [] array) {
        if (array == null || array.length ==0) {
            return 0;
        }
        //如果为1，直接返回数字
        if (array.length == 1) {
            return array[0];
        }
        HashMap<Integer,Integer> map = new HashMap<>(16);
        for (int i = 0; i < array.length; i++) {
            Integer value = map.get(array[i]);
            //不存在则新建，保存数值1
            if (value == null) {
                map.put(array[i],1);
            //获取上次的数值，并+1
            }else {
                map.put(array[i],value+1);
                if (value + 1 >= array.length/2+1) {
                    return array[i];
                }
            }
        }

        return 0;
    }
    
}
