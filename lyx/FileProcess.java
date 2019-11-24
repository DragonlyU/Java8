package lyx;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class FileProcess {

	
	public static String processFile(BufferedReaderProcessor p) throws IOException{
		
		try (BufferedReader br = new BufferedReader(new FileReader("data.txt"))){
			return p.process(br);	
		}
		
	}
	
	public static <T> List<T> filter(List<T> list, Predicate<T> p){
		List<T> results = new ArrayList<T>();
		for(T t : list) {
			if(p.test(t)) {
				results.add(t);
			}
		}
		return results;
		
	}
	
	
	public static void main(String[] args) throws IOException {
		/*
		 * String oneLine = processFile((BufferedReader br) -> br.readLine()); String
		 * twoLines = processFile((BufferedReader br) -> br.readLine() + br.readLine());
		 */
		
		Predicate<String> noEmptyStringPredicate = (String s) -> !s.isEmpty();
		List<String> ListOfStrings = Arrays.asList("lianlong", "lxy", "wangxudong", "");
		System.out.println(ListOfStrings.size());
		/*
		 * List<String> ListOfStrings = new  ArrayList<String>();
		 * ListOfStrings.add("lianlong"); ListOfStrings.add("liyuxi");
		 * ListOfStrings.add("");
		 */
		List<String> list = filter(ListOfStrings, noEmptyStringPredicate);
		System.out.println(list);
		
	}
}
