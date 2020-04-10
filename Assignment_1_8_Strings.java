package assignment1;

import java.util.*;

public class Exercise_1_8_Strings {

	public static TreeSet<String> generateStrings(char[] chSet, int length) {
		TreeSet<String> charStrings = new TreeSet<>();

		// Terminate recursion if length becomes zero without changing the string
		if (length == 0) {
			charStrings.add("");
		} else {
			// Generate all possible strings of given length
			TreeSet<String> permutations = generateStrings(chSet, length - 1);
			// for-each loop to generate possible strings
			for (String perm : permutations) {
				//for-each loop generating each new string with all of the characters
				for (char ch : chSet) {
					String str = ch + perm;
					//adding the finished string to the TreeSet
					charStrings.add(str);
				}
			}
		}
		return charStrings;
	}

	public static void main(String[] args) {
		char[] characters = { 'A', 'B', 'C', 'D', 'E' };
		int count = 0;
		for (String sequence : generateStrings(characters, 4)) {
			count++;
			System.out.printf("%5d. %s%n", count, sequence);
		}

	}
}
