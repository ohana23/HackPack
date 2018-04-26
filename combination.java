public static void main(String[] args) {
  combination("ABC");
  // or combination("", "ABC);
  // These will print:
  // ABC
  // AB
  // A
  // BC
  // B
  // C
}

// Overloaded function if empty string not included.
public static combination(String s) {
  combination("", s);
}

// Takes an empty string, comb, and a string, s, to conduct combinations on.
public static combination(String comb, String s) {
  if (s.length() > 0 {
    // Print current combination.
    System.out.println(comb + s.charAt(0);
    
    combination(comb + s.charAt(0), s.substring(1));
    combination(comb, s.substring(1));
  }
}
