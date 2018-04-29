import java.io.*;

public class MatrixChainMultiplication {
    public static int[][] memo;

    public static int mcm(int [][] mat) {
        //set up memo table
        int n = mat.length;
        memo = new int[n][n];
        //recurse and return

        return minMult(mat, 0, n-1);
    }

    public static int minMult(int[][] dim, int sIndex, int eIndex) {
        if(memo[sIndex][eIndex] != 0) return memo[sIndex][eIndex];
        if(sIndex == eIndex) return 0;
        int best = minMult(dim, sIndex + 1, eIndex) + dim[sIndex][0]*dim[sIndex][1]*dim[eIndex][1];

        for(int split = sIndex + 1; split < eIndex; split++) {
            int costLeft = minMult(dim, sIndex, split);
            int costRight = minMult(dim, split + 1, eIndex);
            int cost = costLeft + costRight + dim[sIndex][0] * dim[split][1]*dim[eIndex][1];
            best = Math.min(best, cost);
        }
        memo[sIndex][eIndex] = best;
        return best;
    }

    public static void main(String args[]) {
        int[][] matricies = {{10, 20}, {20, 30}};
        System.out.println(mcm(matricies));
    }
}
