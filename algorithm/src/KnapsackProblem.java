import java.util.Stack;

/**
 * 背包问题
 * @author zmh
 */
public class KnapsackProblem {
    private int categorySize = 6;
    private int weightSize;
    private int[] categoryArray;
    private int[] priceArray;
    private int[][] result = new int[categorySize][weightSize];

    private KnapsackProblem() {
        weightSize = 11;
        categoryArray = new int[]{0, 1, 3, 4, 5, 9};
        priceArray = new int[]{0, 1, 2, 5, 8, 10};
    }

    private void calcResult() {
        for (int c = 1; c < categorySize; c++) {
            for (int w = 1; w < weightSize; w++) {
                if (categoryArray[c] > w) {
                    result[c][w] = result[c - 1][w];
                } else {
                    int value1 = result[c - 1][w - categoryArray[c]] + priceArray[c];
                    int value2 = result[c - 1][w];
                    if (value1 > value2) {
                        result[c][w] = value1;
                    } else {
                        result[c][w] = value2;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
//        KnapsackProblem knapsackProblem = new KnapsackProblem();
//        knapsackProblem.calcResult();
//        System.out.println(knapsackProblem.result[5][6]);
        Stack<Integer> ints = new Stack<Integer>();
        ints.push(222);
        ints.pop();
    }

}
