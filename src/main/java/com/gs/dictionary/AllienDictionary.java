package com.gs.dictionary;

import java.util.HashMap;
import java.util.Map;

public class AllienDictionary {

	private Map<Character, Integer> indexMap = new HashMap<Character, Integer>();

	public boolean isAlienSorted(String[] words, String order) {
		buildIndexMap(order);
		for (int index = 1; index < words.length; index++) {
			String prev = words[index - 1];
			String current = words[index];
			if ( !isOrder(prev, current)) {
				return false;
			}
		}
		return true;
	}

	private boolean isOrder(String prev, String current) {
		if (prev == null) return true;
		
		if (current == null || prev.length() > current.length()) return false;
		
		int limit = Math.min(prev.length(), current.length());
		for (int index = 0; index < limit; index++) {
			int prevIndexPos = indexMap.get(prev.charAt(index));
			int currentIndexPos = indexMap.get(current.charAt(index));
			if (prevIndexPos > currentIndexPos) {
				return false;
			}
		}
		return true;
	}

	private void buildIndexMap(String order) {
		int count = 0;
		for (char c : order.toCharArray()) {
			indexMap.put(c, count++);
		}
	}

}
