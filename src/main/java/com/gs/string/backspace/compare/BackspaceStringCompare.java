package com.gs.string.backspace.compare;

public class BackspaceStringCompare {


  public boolean backspaceCompare(String S, String T) {
    if (S == null && T == null) {
      return true;
    }
    int sPostion = S.length() - 1;
    int tPostion = T.length() - 1;
    while (sPostion >= 0 && tPostion >= 0) {
      sPostion = getValidCharPostion(S, sPostion);
      tPostion = getValidCharPostion(T, tPostion);
      if (sPostion < 0 || tPostion < 0) {
        return sPostion < 0 && tPostion < 0;
      }
      if (S.charAt(sPostion) != T.charAt(tPostion)) {
        return false;
      }
      sPostion--;
      tPostion--;
    }
    return sPostion == tPostion;
  }



  private int getValidCharPostion(String str, int pos) {
    
    for(int i = pos; i >= 0; i--) {
      if (str.charAt(i) == '#') {
        pos = pos - 2;
      }
    }
    
    if (pos >=0 && str.charAt(pos) =='#') {
      return getValidCharPostion(str, pos);
    }else {
      return pos;
    }
    
  }



  public static void main(String[] args) {
    System.out.println(new BackspaceStringCompare().backspaceCompare("lc#d#", "lab##"));
    System.out.println(new BackspaceStringCompare().backspaceCompare("#lc#d#", "##lab##"));
  }
}
