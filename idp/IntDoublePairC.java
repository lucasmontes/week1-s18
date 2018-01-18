// file: IntDoublePairC.java
// author: Bob Muller
//
// CSCI 1102 Computer Science 2
//
// First example of making a new type -- a pair of an integer and a double.
//
public class IntDoublePairC implements IntDoublePair {
 
  int i;
  double d;
  
  // Constructor
  //
  public IntDoublePairC(int ii, double dd) {
    i = ii;
    d = dd;
  }
  
  public String toString() { return "(" + i + ", " + d + ")"; }
  
  public double add() { return i + d; }
  
  public static void main(String[] args) {
    
    IntDoublePair idp = new IntDoublePairC(5, 5.2);
    System.out.format("idp = %s\n", idp.toString()); 
  } 
}