public static void main(String[] args) {
  System.out.println(lcss("goodmorning", "goodnight"));
  // This will print:
  // 6
  // for longest common subsequence:
  // goodig
}

public static int lcss(String x, String y) {
  int xLen = x.length();
  int yLen = y.length();
  
  // DP array to store the LCSS of all prefix strings. Remember that 
  // all cells are automatically initialized to zero.
  int [][] DP = new int[xLen+1][yLen+1];
  
  // Fill in each LCSS value from top to bottom, left to right.
  for (int i = 1; i <= xLen; i++) {
    for (int j = 1; j <= yLen; j++) {
      // Last characters are a match!
      if (x.charAt(i-1) == y.charAt(j-1))
        DP[i][j] = DP[i-1][j-1] + 1;
      // Take the best of the two possible smaler cases.
      else
        DP[i][j] = Math.max(DP[i][j-1], DP[i-1][j]);
    }
  }
  // Answer.
  return DP[xLen][yLen];
}
