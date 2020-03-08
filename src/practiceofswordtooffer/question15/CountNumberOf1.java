package practiceofswordtooffer.question15;

public class CountNumberOf1 {

    /**
     * 可能造成死循环
     * @param n
     * @return
     */
    public int getNumberOf1(int n) {
        int count = 0;
        while (n != 0) {
            n = n>>1;
            count++;
        }
        return count;
    }

    /**
     * 避免死循环的写法
     *
     * 需要循环
     */
    public static int getNumberOf1Method2(int n) {
        int count = 0;

        int flag = 1;
        //判断时候为最后一位，会遍历32次
        while (flag != 0) {
            //判断flag对应的数位n是否为1
            if ((n & flag) != 0) {
                count++;
            }
            flag = flag << 1;
        }

        return count;
    }

    public static int getNumberOf1Method3(int n) {
        int count = 0;
        while (n != 0) {
            ++count;
            //该操作会将最右边的1变成0
            //例如 1100 & 1011 = 1000
            //通过计算该操作（抹去最低位的1）的次数，即可记录1的二进制数量
            n = (n-1) & n;
        }
        return count;
    }

    public static int getNumberOf1Method4(int num) {
        int count = 0;
        while (num != 0) {
            count++;
            num = num & (num -1 );
        }
        return count;
    }

    public static void main(String[] args) {
        int result = getNumberOf1Method4(0x7fffffff);
        System.err.println(result);
    }
}
