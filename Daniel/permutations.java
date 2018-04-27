public static void main(String[] args) {
  permutation("ABC");
  // or permutation("", "ABC");
  // These will print:
  // ABC
  // ACB
  // BAC
  // BCA
  // CAB
  // CBA
}

// Overloaded function if empty string not included.
public static void permutation(String s) {
  permutation("", s);
}

// Takes an empty string, perm, and a string, s, to conduct permutations on.
public static void permutation(String perm, String s) {
  // Print current permutation.
  if (s.length() == 0)
    System.out.println(perm);
  else
    for (int i = 0; i < s.length(); i++)
      permutation(perm + s.charAt(i), s.substring(0, i) + s.substring(i + 1, s.length()));
}
