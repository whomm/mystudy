public class App {


    public static void main(String[] args) {

        App m = new App();
        m.sortTest();
        m.testOther();

    }


    private void sortTest() {

        int[] array = {10, 9, 8, 7, 6, 5, 12, 109, 56};

        quickSort(array, 0, array.length - 1);
        System.out.println("quickSort");
        for (int i : array) {
            System.out.println(i);
        }


        int[] array2 = {10, 9, 8, 7, 6, 5, 12, 109, 56};

        heapSort(array2);
        System.out.println("heapSort");
        for (int i : array2) {
            System.out.println(i);
        }

    }

    public void testOther() {
        System.out.println("rainwaterCollection");
        int[] array3 = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(rainwaterCollection(array3));


        System.out.println("maxProfit");
        int[] array4 = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(array4));


        int[] coin = {1, 2, 5};
        int amount = 16;
        System.out.println("coinChange");
        System.out.println(coinChange(coin, amount));

        int[] coin2 = {1};
        int amount2 = 0;
        System.out.println("coinChange");
        System.out.println(coinChange(coin2, amount2));
    }


    /**
     * 接雨水 双指针解法
     *
     * @param array
     * @return
     */
    public static int rainwaterCollection(int[] array) {

        if (array.length < 3) {
            return 0;
        }
        int leftMax = array[0];
        int rightMax = array[array.length - 1];
        int total = 0;
        for (int i = 1, j = array.length - 2; i <= j; ) {

            leftMax = Math.max(leftMax, array[i]);
            rightMax = Math.max(rightMax, array[j]);

            if (leftMax < rightMax) {
                total += (leftMax - array[i]);
                i++;
            } else {
                total += (rightMax - array[j]);
                j--;
            }
        }

        return total;
    }

    /**
     * 股票交易 https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
     *
     * @param array
     * @return
     */
    public static int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        int[] result = new int[prices.length];
        result[0] = 0;
        for (int i = 1; i < prices.length; i++) {
            result[i] = result[i - 1];
            for (int j = i - 1; j >= 0; j--) {
                result[i] = Math.max((prices[i] - prices[j]) + result[j], result[i]);
            }
        }
        return result[prices.length - 1];
    }

    /**
     * 零钱兑换 https://leetcode-cn.com/problems/coin-change/
     *
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {

        if (amount < 1) {
            return -1;
        }
        if (coins.length < 1) {
            return -1;
        }
        int[] ret = new int[amount + 1];

        for (int i = 1; i <= amount; i++) {
            ret[i] = -1;
            for (int j = 0; j < coins.length; j++) {

                if (i == coins[j]) {
                    ret[i] = 1;
                    break;
                } else if (i - coins[j] >= 1 && ret[i - coins[j]] != -1) {

                    if (ret[i] == -1) {
                        ret[i] = ret[i - coins[j]] + 1;
                    } else {
                        ret[i] = Math.min(ret[i - coins[j]] + 1, ret[i]);
                    }

                }

            }

        }

        return ret[amount];
    }





    /*

    1 2 3 4 5 6 7 8

           1
        2    3
     4   5 6   7
   8
     */

    public static void maxHeap(int[] array, int dad, int last) {

        int thedad = dad;
        int theson = 2 * dad + 1;

        for (; theson <= last; ) {
            if (theson + 1 <= last && array[theson] < array[theson + 1]) {
                theson++;
            }
            if (array[theson] < array[thedad]) {
                return;
            }

            int tmp = array[theson];
            array[theson] = array[thedad];
            array[thedad] = tmp;

            thedad = theson;
            theson = thedad * 2 + 1;
        }

    }

    /**
     * 堆排序
     *
     * @param array
     */
    public static void heapSort(int[] array) {

        //从最后一个父节点开始调整成最大堆
        for (int i = array.length / 2 - 1; i >= 0; i--) {
            maxHeap(array, i, array.length - 1);
        }

        //不停将堆顶 换到最后 同时调整前面的堆
        for (int i = array.length - 1; i > 0; i--) {

            int tmp = array[0];
            array[0] = array[i];
            array[i] = tmp;

            maxHeap(array, 0, i - 1);
        }

    }


    /**
     * 快速排序
     *
     * @param array
     * @param left
     * @param right
     */
    public static void quickSort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }

        int l = left;
        int r = right;

        int theone = array[l];

        while (l < r) {

            while (r > l && array[r] > theone) {
                r--;
            }
            array[l] = array[r];
            while (l < r && array[l] < theone) {
                l++;
            }
            array[r] = array[l];

        }
        array[l] = theone;
        quickSort(array, left, l);
        quickSort(array, l + 1, right);

    }

}
