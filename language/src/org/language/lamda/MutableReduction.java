package org.language.lamda;

import java.util.Arrays;
import java.util.List;
/*
 * A mutable reduction operation process the stream elements and then accumulate it into a mutable result container. 
 * Once the elements are processed, a combining function merges all the result containers to create the result.
 */
//https://www.journaldev.com/32457/java-stream-collect-method-examples
public class MutableReduction {

	public static void main(String[] args) {
		
		//Concatenating List of Strings
		List<String> vowels = Arrays.asList("a","e","i","o","u");
		StringBuilder collect = vowels.stream().collect(StringBuilder::new,(x,y) -> x.append(y), (a,b)->a.append(",").append(b));
		System.out.println(collect.toString());
		
		// parallel stream - combiner is combining partial results
		StringBuilder result2 = vowels.parallelStream().collect(StringBuilder::new, (x, y) -> x.append(y),
				(a, b) -> a.append(",").append(b));
		System.out.println(result2);
		
		//Using method reference
		String result3 = vowels.parallelStream().collect(StringBuilder::new, StringBuilder::append, StringBuilder::append).toString();
		System.out.println(result3);
		
	}
}
