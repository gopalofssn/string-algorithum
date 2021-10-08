package com.gs.string.algorithum;

import java.util.*;

public class AllienDictionary {

  public boolean isAlienSorted(String[] words, String order) {
    if (words == null || words.length == 0) {
      return true;
    }
    Map<Character, Integer> charPostionMap = buildCharPositionMap(order);
    for (int i = 1; i < words.length; i++) {
      boolean isOrder = isOrder(words[i - 1], words[i], charPostionMap);
      if (!isOrder) {
        return false;
      }
    }
    return true;
  }

  private boolean isOrder(String prev, String current, Map<Character, Integer> charPostionMap) {
    if (prev == null) {
      return true;
    }
    if (current == null || (prev.length() > current.length()) ) { 
      return false;
    }
    return isOrderHelper(prev, current, charPostionMap);
  }

  private boolean isOrderHelper(String prev, String current,
      Map<Character, Integer> charPostionMap) {
    int limit = Math.min(prev.length(), current.length());
    for (int i = 0; i < limit; i++) {
      char p = prev.charAt(i);
      char c = current.charAt(i);
      if (p != c) {
        return charPostionMap.get(p) < charPostionMap.get(c);
      }
    }
    return true;
  }

  private Map<Character, Integer> buildCharPositionMap(String order) {
    Map<Character, Integer> charPostionMap = new HashMap<>();
    int index = 0;
    for (char ch : order.toCharArray()) {
      charPostionMap.put(ch, index);
      index++;
    }
    return charPostionMap;
  }


}
