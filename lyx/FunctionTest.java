package lyx;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

public class FunctionTest {

	 public static<T, R> List<R> map(List<T> list, Function<T, R> f){
		 List<R> result = new ArrayList<>();
		 for(T t : list) {
			 result.add(f.apply(t));
		 }
		 return result;
	 }
	 
	 public static void main(String[] args) {
		List<Integer> l = map(Arrays.asList("lianlong", "lxy", "wangxudong"), (String s) -> s.length());
		System.out.println(l);
		
		Comparator<Apple> c = Comparator.comparing(Apple::getWeight);
	}
}
