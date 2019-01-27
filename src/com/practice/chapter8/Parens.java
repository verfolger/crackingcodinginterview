package com.practice.chapter8;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Parens {

	
	void printParens(int pairCount) {
		
		
		List<String> input = new ArrayList<>(pairCount);
		
		for (int i = 0; i < pairCount; i++)
			input.add("()");
		
		Set<String> result = generateParens(input);
		
		System.out.println(result);
	}
	
	
	
	
	private Set<String> generateParens(List<String> pairs) {
		
		System.out.println("generateParens(" + pairs + ")");
		
		if (pairs == null) return null;
		
		Set<String> parens = new HashSet<String>();
		
		if (pairs.size() == 0) {
			parens.add("");
			return parens;
		}
		
		String first = pairs.get(0);
		pairs.remove(0);
		
		Set<String> remainingParens = generateParens(pairs);
		
		for (String parensPermute : remainingParens) {			
			if (parensPermute.length() >= 2) {
					parens.add(first + parensPermute);
					parens.add(parensPermute + first);
					parens.add("(" + parensPermute + ")");
					int end = parensPermute.indexOf(")");
					parens.add(parensPermute.substring(0, end) + "()" + parensPermute.substring(end));
			} else {
				parens.add(first);
			}
			
		}
		//System.out.println("parens :" + parens);
		return parens;	
	}
	
	public static void main(String[] args) {
		
		Parens p = new Parens();
		p.printParens(3);

	}

}
