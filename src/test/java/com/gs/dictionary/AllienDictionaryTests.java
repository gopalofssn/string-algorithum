package com.gs.dictionary;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class AllienDictionaryTests {

  private AllienDictionary allienDictionary = new AllienDictionary();
  private final String order = "hlabcdefgijkmnopqrstuvwxyz";

  @Test
  public void testWithNull() {
    String[] words = {null, "hello", "leetoode"};
    assertTrue(allienDictionary.isAlienSorted(words, order));
  }

  @Test
  public void testWithNullCase2() {
    String[] words = {"hello", null, "leetoode"};
    assertFalse(allienDictionary.isAlienSorted(words, order));
  }

  @Test
  public void testCase1() {
    String[] words = {"apple", "app"};
    assertFalse(allienDictionary.isAlienSorted(words, order));
  }

  @Test
  public void testCase2() {
    String[] words = {"app", "apple"};
    assertTrue(allienDictionary.isAlienSorted(words, order));
  }

  @Test
  public void testCase3() {
    String[] words = {"app", "", "apple"};
    assertFalse(allienDictionary.isAlienSorted(words, order));
  }

}
