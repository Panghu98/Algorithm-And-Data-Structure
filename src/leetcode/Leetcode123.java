package leetcode;

/**
 * @author: panghu
 * @Description: https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/
 * @Date: Created in 17:58 2021/1/9
 * @Modified By:
 *
 * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
 *
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Leetcode123 {

    public int maxProfit(int[] prices) {
        int length = prices.length;

        int buy1 = -prices[0];
        int buy2 = -prices[0];
        int sell1 = 0,sell2 = 0;

        for (int i = 0; i < length; i++) {

            buy1 = Math.max(buy1,-prices[i]);
            sell1 = Math.max(sell1,buy1 + prices[i]);
            buy2 = Math.max(buy2,sell1-prices[i]);
            sell2 = Math.max(sell2,buy2 + prices[i]);
        }

        return sell2;
    }

}
