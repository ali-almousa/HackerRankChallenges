package Stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

/**
 * @author Ali Almousa
 *
 * This class mainly checkes if a string
 * is balanced in the contest of brackets.
 */
public class BalancedBrackets {
	private static ArrayList<Character> opening = new ArrayList<Character>(Arrays.asList('{', '[', '('));
	private static HashMap<Character, Character> openingClosingPairs = new HashMap<Character, Character>();
	
	static {
		openingClosingPairs.put('{', '}');
		openingClosingPairs.put('[', ']');
		openingClosingPairs.put('(', ')');
	}
	
	/**
	 * 
	 * @param args
	 * 
	 * quick test cases
	 */
	public static void main(String[] args) {
		System.out.println(isBalanced("{([])}")); 			//balanced
		System.out.println(isBalanced("{[(])}"));			//not balanced
		System.out.println(isBalanced("{{[[(())]]}}")); 	//balanced
	}
	
	/**
	 * 
	 * @param brackets
	 * @return YES if the string bracket is balanced
	 * and NO otherwise.
	 */
	public static String isBalanced(String brackets) {
		
		Stack<Character> openningBrackets = new Stack<>();
		
		char[] brackets2Chars = brackets.toCharArray();
		
		// traverse the brackets in the string
		for (char bracket : brackets2Chars) {
			
			// OPENING BRACKET
			if (opening.contains(bracket)) {
				openningBrackets.add(bracket);
			}
			
			// CLOSING BRACKET
			else {
				// if stack is empty then there is no
				// matching opening bracket: return NO
				if (openningBrackets.isEmpty()) {
					return "NO";
				}
				
				// stack is not empty
				else{
					// the last bracket in stack not 
					// a matching opening bracket: return NO
					if (bracket != openingClosingPairs.get(openningBrackets.pop())) {
						return "NO";
					}
				}
			}
		}
		// passed all tests and stack is empty: return YES
		if (openningBrackets.isEmpty()) return "YES";
		// passed all tests and stack is not empty meaning
		// an opening bracket has no closing one: return NO
		else return "NO";
		
		
	}
}
