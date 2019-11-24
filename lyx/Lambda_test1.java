package lyx;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;


public class Lambda_test1 {

	
	public static void main(String[] args) {
		List<String> worlds = Arrays.asList("hello", "world");
		
		List<String> result = worlds.stream()
				.map(word -> word.split(""))
				.flatMap(Arrays::stream)
				.distinct()
				.collect(toList());
		System.out.println(result);
	}
}
