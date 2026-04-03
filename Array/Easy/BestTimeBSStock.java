package Array.Easy;

/* 
 * Problem: Best Time to Buy and Sell Stock
 * 
 * This is a fairly easy problem that requires you to realize one thing. Once we
 * go past a certain price, we don't care about the prices before that price. Basically,
 * we can't go back in time to make the max profit.
 * 
 * So, at each price we check if the price is less than the minimum and if it
 * is, we update it since all future differences will be less than the current.
 * 
 * If the price is not less than the minimum, then the best idea would be to
 * substract that price from the minimum and see if it's greater than the max profit, 
 * and if it is, we update the max profit.
 * 
 * Note that it is an else-if statement, because if the 
 * price is less than the minimum, then max profit will be negative, so there
 * would be no need to use an additional if statement.
 */

public class BestTimeBSStock {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int price : prices) {
            if (price < min) {
                min = price;
            } else if (price - min > maxProfit) {
                maxProfit = price - min;
            }
        }
        return maxProfit;
    }
}
