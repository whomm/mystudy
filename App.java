import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;

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


        int[] num = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println("lengthOfLIS");
        System.out.println(lengthOfLIS(num));


        int[][] points = {{1, 1}, {3, 2}, {5, 3}, {4, 1}, {2, 3}, {1, 4}};
        System.out.println("maxPoints");
        System.out.println(maxPoints(points));


        int[][] points2 = {{1, 1}, {2, 2}, {3, 3}};
        System.out.println("maxPoints");
        System.out.println(maxPoints(points2));


        int[][] points3 = {{2, 3}, {3, 3}, {-5, 3}};
        System.out.println("maxPoints");
        System.out.println(maxPoints(points3));

        int[][] points4 = {{40, -23}, {9, 138}, {429, 115}, {50, -17}, {-3, 80}, {-10, 33}, {5, -21}, {-3, 80}, {-6, -65}, {-18, 26}, {-6, -65}, {5, 72}, {0, 77}, {-9, 86}, {10, -2}, {-8, 85}, {21, 130}, {18, -6}, {-18, 26}, {-1, -15}, {10, -2}, {8, 69}, {-4, 63}, {0, 3}, {-4, 40}, {-7, 84}, {-8, 7}, {30, 154}, {16, -5}, {6, 90}, {18, -6}, {5, 77}, {-4, 77}, {7, -13}, {-1, -45}, {16, -5}, {-9, 86}, {-16, 11}, {-7, 84}, {1, 76}, {3, 77}, {10, 67}, {1, -37}, {-10, -81}, {4, -11}, {-20, 13}, {-10, 77}, {6, -17}, {-27, 2}, {-10, -81}, {10, -1}, {-9, 1}, {-8, 43}, {2, 2}, {2, -21}, {3, 82}, {8, -1}, {10, -1}, {-9, 1}, {-12, 42}, {16, -5}, {-5, -61}, {20, -7}, {9, -35}, {10, 6}, {12, 106}, {5, -21}, {-5, 82}, {6, 71}, {-15, 34}, {-10, 87}, {-14, -12}, {12, 106}, {-5, 82}, {-46, -45}, {-4, 63}, {16, -5}, {4, 1}, {-3, -53}, {0, -17}, {9, 98}, {-18, 26}, {-9, 86}, {2, 77}, {-2, -49}, {1, 76}, {-3, -38}, {-8, 7}, {-17, -37}, {5, 72}, {10, -37}, {-4, -57}, {-3, -53}, {3, 74}, {-3, -11}, {-8, 7}, {1, 88}, {-12, 42}, {1, -37}, {2, 77}, {-6, 77}, {5, 72}, {-4, -57}, {-18, -33}, {-12, 42}, {-9, 86}, {2, 77}, {-8, 77}, {-3, 77}, {9, -42}, {16, 41}, {-29, -37}, {0, -41}, {-21, 18}, {-27, -34}, {0, 77}, {3, 74}, {-7, -69}, {-21, 18}, {27, 146}, {-20, 13}, {21, 130}, {-6, -65}, {14, -4}, {0, 3}, {9, -5}, {6, -29}, {-2, 73}, {-1, -15}, {1, 76}, {-4, 77}, {6, -29}};
        System.out.println("maxPoints");
        System.out.println(maxPoints(points4));

    }


    /**
     * https://leetcode-cn.com/problems/trapping-rain-water/
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

    public void maxHeap(int[] array, int dad, int last) {

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
    public void heapSort(int[] array) {

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
    public void quickSort(int[] array, int left, int right) {
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

    /**
     * 目前这个写法不够好
     * https://leetcode-cn.com/problems/longest-increasing-subsequence/
     * 输入: [10,9,2,5,3,7,101,18]
     * 输出: 4
     * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
     *
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {

        if (nums.length < 1) {
            return 0;
        }
        if (nums.length < 2) {
            return 1;
        }
        int max = 1;
        int[] result = new int[nums.length];
        result[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            result[i] = 0;

            int minilength = -1;
            int re = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (result[j] < re - 1) {
                    continue;
                }
                if (nums[j] < nums[i]) {
                    if (minilength == -1) {
                        minilength = nums[i] - nums[j];
                        re = result[j] + 1;
                    } else if (result[j] + 1 > re) {
                        minilength = result[i] - result[j];
                        re = result[j] + 1;
                    } else if (result[j] + 1 == re && result[i] - result[j] < minilength)
                        minilength = result[i] - result[j];
                }
            }

            result[i] = re;
            if (re > max) {
                max = re;
            }
        }
        return max;
    }

    /**
     * 149. 直线上最多的点数
     * 输入: [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
     * 输出: 4
     * https://leetcode-cn.com/problems/max-points-on-a-line/
     *
     * @param points
     * @return
     */
    public int maxPoints(int[][] points) {

        final Pair<Integer, Integer> SAMEPOINT = new Pair<Integer, Integer>(0, 0);
        if (points.length < 3) {
            return points.length;
        }
        Object[][] doublePointsLine = new Object[points.length][points.length];
        int max = 0;
        for (int i = 0; i < points.length; i++) {

            HashMap<Pair<Integer, Integer>, Integer> thecount = new HashMap<Pair<Integer, Integer>, Integer>();
            for (int j = 0; j < i; j++) {
                doublePointsLine[i][j] = doublePointsLine[j][i];
                thecount.put((Pair<Integer, Integer>) doublePointsLine[i][j], thecount.containsKey((Pair<Integer, Integer>) doublePointsLine[i][j]) ? thecount.get((Pair<Integer, Integer>) doublePointsLine[i][j]) + 1 : 1);

            }
            for (int j = i + 1; j < points.length; j++) {

                int x = points[i][0] - points[j][0];
                int y = points[i][1] - points[j][1];


                //有一个为0的情况
                if (x == 0 && y != 0) {
                    y = y / Math.abs(y);
                }
                if (y == 0 && x != 0) {
                    x = x / Math.abs(x);
                }

                //两个都不为零归一化
                if (x != 0 && y != 0) {
                    int xx = gdb(x, y);
                    y /= xx;
                    x /= xx;
                }

                //如果两个都为零 是有重复的点 这个在判断取最大的时候要注意获取一下
                if (x == 0 && y == 0) {
                    doublePointsLine[i][j] = SAMEPOINT;
                } else {

                    //这个地方很重要：统一一下斜率的符号
                    /*

                    -1,1     1,1

                    -1,-1    1,-1

                     比如   当前点是 0,0   这个时候  1,1 和 -1,-1   是一条线上的，   -1,1 和 1,-1是一条线上的
                     */
                    if (x <= 0) {
                        x = 0 - x;
                        y = 0 - y;

                    }
                    doublePointsLine[i][j] = new Pair<Integer, Integer>(y, x);
                }


                thecount.put((Pair<Integer, Integer>) doublePointsLine[i][j], thecount.containsKey((Pair<Integer, Integer>) doublePointsLine[i][j]) ? thecount.get((Pair<Integer, Integer>) doublePointsLine[i][j]) + 1 : 1);

            }

            int tmpmax = 0;
            Pair<Integer, Integer> tmpthemaxkey = null;
            for (Map.Entry<Pair<Integer, Integer>, Integer> entry : thecount.entrySet()
            ) {

                if (entry.getValue() > tmpmax) {
                    tmpthemaxkey = entry.getKey();
                    tmpmax = entry.getValue();
                }
            }
            //获取到最大的了 但是不包含重复的点 这个地方加上
            if (!tmpthemaxkey.equals(SAMEPOINT) && thecount.containsKey(SAMEPOINT)) {
                tmpmax += thecount.get(SAMEPOINT);
            }

            //更新最大值
            if (tmpmax > max) {
                max = tmpmax;
            }


        }

        /*
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points.length; j++) {
                if (i == j) {
                    System.out.print(" 0,0");
                } else {
                    System.out.print(" " +
                            String.valueOf(((Pair<Integer, Integer>) doublePointsLine[i][j]).getKey())
                            + "," + String.valueOf(((Pair<Integer, Integer>) doublePointsLine[i][j]).getValue()))
                    ;
                }
            }
            System.out.println();
        }
        */
        return max + 1;
    }

    private int gdb(int a, int b) {
        int temp;
        if (a < b) {
            temp = a;
            a = b;
            b = temp;
        }

        while (a % b != 0) {

            temp = a % b;
            a = b;
            b = temp;
        }
        return b;
    }

}
