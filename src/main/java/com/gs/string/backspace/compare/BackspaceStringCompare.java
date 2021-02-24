package com.gs.string.backspace.compare;

public class BackspaceStringCompare {
   
  
  public boolean backspaceCompare(String S, String T) {
    if (S == T)
      return true;
    if (S == null && T != null)
      return false;
    if (S != null && T == null)
      return false;

    int sPos = S.length() - 1;
    int tPos = T.length() - 1;
    while(sPos >= 0) {
      
      int skipPos = sPos;
      char sChar = sPos >=0 ? S.charAt(sPos) : ' ';
      while(sPos >=0 && sChar == '#') {
        skipPos = skipPos - 2;
        sPos--;
        sChar = sPos >=0 ? S.charAt(sPos) : ' ';
      }
    
      sPos = skipPos;
      sChar = sPos >=0 ? S.charAt(sPos) : ' ';
      System.out.println(sChar);
      sPos--;
    }
    
    return true;
  }
 
   

  public static void main(String[] args) {
    System.out.println(new BackspaceStringCompare().backspaceCompare("lc#d#", "lab##"));
  }
}
