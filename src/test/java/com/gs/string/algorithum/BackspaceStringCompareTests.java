package com.gs.string.algorithum;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class BackspaceStringCompareTests {

  private BackspaceStringCompare backspaceStringCompare = new BackspaceStringCompare();

  @Test
  public void testCase1() {
    assertTrue(backspaceStringCompare.backspaceCompare("lc#d#", "lab##"));
  }
  
  @Test
  public void testCase2() {
    assertTrue(backspaceStringCompare.backspaceCompare(null, null));
  }
  
  @Test
  public void testCase3() {
    assertTrue(backspaceStringCompare.backspaceCompare("", ""));
  }
  
  @Test
  public void testCase4() {
    assertTrue(backspaceStringCompare.backspaceCompare("#lc#d#", "##lab##"));
  }
  
  @Test
  public void testCase5() {
    assertFalse(backspaceStringCompare.backspaceCompare("r#lc#d#", "##lab##"));
  }
  
}
