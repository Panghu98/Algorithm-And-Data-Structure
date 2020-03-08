package practiceofswordtooffer.question14;

public class CutRope {

    public static int maxProductAfterByDynamicPlaning2(int length) {
        if (length < 2) {
            throw new IllegalArgumentException();
        }
        if (length == 2) {
            return 1;
        }

        int[] ropes = new int[length+1];

        ropes[0] = 0;
        ropes[1] = 1;
        ropes[2] = 2;
        ropes[3] = 3;

        for (int i = 4; i <= length; i++) {
            int max = 0;
            for (int j = 1; j <= (i/2); j++) {
                int product = (ropes[j] * ropes[i - j]);
                if (product > max) {
                    max = product;
                }
            }
            ropes[i] = max;
        }

        return ropes[length];
    }













    public static int maxProductAfterByDynamicPlaning(int length) {

        if (length < 2 ) {
            throw new IllegalArgumentException();
        }
        if (length == 2) {
            return 1;
        }else if (length == 3) {
            return 2;
        }

        // 记录绳子长度

        //记录子问题最优解,f(3) 的最优解为2，但如果子问题有3的话--最优解为3
        int[] products = new int[length+1];
        products[0] = 0;
        products[1] = 1;
        products[2] = 2;
        products[3] = 3;

        int max = 0;
        for (int i = 4; i <= length; i++) {
            max = 0;

            //寻找子问题当中的最优解
            for (int j = 1; j <= i / 2; j++) {
                int product = products[j] * products[i -j];
                if (max < product) {
                    max = product;
                }
            }
            products[i] = max;
        }

        max = products[length];
        products = null;
        return max;
    }

    public static int maxProductAfterGreedily(int length) {
        if (length < 2) {
            throw new IllegalArgumentException();
        }
        if (length == 2) {
            return 1;
        }else if (length == 3) {
            return 2;
        }

        //尽可能减去长度为3的绳子段
        int timesOf3 = length/3;

        //当剩下的最后剩下的长度为4的时候，最优子解为4，所以3子长度的数量-1
        if(length - timesOf3 * 3 == 1) {
            timesOf3--;
        }


        //除以3的结果只有2或者4，如果是1（被转换成4）
        //这里2的次数是由3的次数所决定
        int timesOf2 = (length - timesOf3 * 3)/2;

        return (int)((Math.pow(3,timesOf3))*(Math.pow(2,timesOf2)));
    }


    public static void main(String[] args) {
        int result = maxProductAfterGreedily(12);
        System.err.println(result);
    }

}
