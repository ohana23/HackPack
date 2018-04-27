import java.io.*;

public class Knapsack {

    public static int Knapsack(int n, int[] weights, int[] values, int capacity)
    {
        int[] dp = new int[capacity + 1];
        for(int i = 0; i < n; i++) {
/*------Use this loop if you want to be able to choose only one of each item----*/
            for(int w = capacity; w >= weights[i]; w--)

/*------Use this loop if you want to be able to choose more than one of each item----*/
            //for(int w = weights[i]; w <= capacity; w++)
                dp[w] = Math.max(dp[w], dp[w - weights[i]] + values[i]);
        }

        return dp[capacity];
    }

    public static void main(String args[])
    {
        int n = 4;
        int capacity = 8;
        int[] weights = {1, 5, 3, 4};
        int[] values = {15, 10, 9, 5};

        System.out.println(Knapsack(n, weights, values, capacity));
    }
}
