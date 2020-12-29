//package labuladong;
//
//import java.util.HashSet;
//import java.util.Set;
//
///**
// * @author: panghu
// * @Description:
// * @Date: Created in 21:55 2020/12/26
// * @Modified By:
// */
//public class CollectChange {
//
//    public static int coinChange(Set<Integer> coins, int limit) {
//
//
//
//    }
//
//
//    private static int dp(int n,Set<Integer> coins) {
//
//        if (n < 0) {
//            return -1;
//        }
//
//
//        for (Integer next : coins) {
//            if (next == n) {
//                return 1;
//            } else {
//                return 1 + dp(n - next, coins);
//            }
//        }
//
//        return -1;
//    }
//
//
//
//    public static void main(String[] args) {
//        Set<Integer> coinsSet = new HashSet<>();
//        coinsSet.add(1);
//        coinsSet.add(2);
//        coinsSet.add(5);
//
//        int limit = 3;
//
//        int i = coinChange(coinsSet, limit);
//        System.err.println(i);
//    }
//
//}
