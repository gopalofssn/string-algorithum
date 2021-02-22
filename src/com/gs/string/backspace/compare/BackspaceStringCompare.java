package com.gs.string.backspace.compare;

public class BackspaceStringCompare {
  
  private class CharAndPostion {
    private int pos;
    private char ch;

    CharAndPostion(char ch, int pos) {
      this.pos = pos;
      this.ch = ch;
    }
  }

  public boolean backspaceCompare(String S, String T) {
    if (S == T)
      return true;
    if (S == null && T != null)
      return false;
    if (S != null && T == null)
      return false;

    int sPos = S.length() - 1;
    int tPos = T.length() - 1;

    while (sPos >= 0 || tPos >= 0) {

      CharAndPostion sCharAndPostion = getCharAndPostion(S, sPos);
      CharAndPostion tCharAndPostion = getCharAndPostion(T, tPos);
      if (sCharAndPostion.ch != tCharAndPostion.ch)
        return false;
      sPos = sCharAndPostion.pos - 1;
      tPos = tCharAndPostion.pos - 1;
    }

    return true;
  }

  private CharAndPostion getCharAndPostion(String str, int pos) {
    int originalPos = pos;
    int skip = 0;
    while(pos >= 0 && str.charAt(pos) == '#') {
      skip = skip + 2;
      pos--;
    }
    
    pos = (originalPos - skip);
    if(pos < 0) {
      return new CharAndPostion(' ', pos);
    }else {
      return new CharAndPostion(str.charAt(pos), pos);
    }
  }
  
  public static void main(String[] args) {
    System.out.println(new BackspaceStringCompare().backspaceCompare("ab##", "c#d#"));
  }
}
