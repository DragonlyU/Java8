package lyx;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static java.util.Comparator.comparing;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class Lyx_test2 {

	public static<T, V> V filter(T s,Function<T, V> f) {
		return f.apply(s);
	}
	public static List<Apple> map(List<Integer> list, Function<Integer, Apple> f){
		List<Apple> result = new ArrayList<Apple>();
		for(Integer i : list) {
			result.add(f.apply(i));
		}
		return result;
	}
	
	static Map<String, Function<Integer, Fruit>> map = new HashMap<>();
	static Map<String, BiFunction<String, Integer, Fruit>> mapB = new HashMap<>();
	static {
		map.put("apple", Apple::new);
		map.put("orange", Orange::new);
		mapB.put("apple", Apple::new);
		mapB.put("orange", Orange::new);
		
	}
	public static Fruit giveMeFruit(String fruit,Integer weight) {
		return map.get(fruit.toLowerCase()).apply(weight);
	}
	public static Fruit giveMeFruit_(String fruit, String color, Integer weight) {
		return mapB.get(fruit.toLowerCase()).apply(color, weight);
	}
	
	
	
	
	public static void main(String[] args) {
		List<String> str = Arrays.asList("a","b","A","B");
		List<Apple> appleList = Arrays.asList(new Apple("red",120), new Apple("blue",109));
//		appleList.sort(new AppleComparator());
		appleList.sort(comparing((Apple::getColor)));
//		appleList.sort(comparing((0) -> a0.));
		System.out.println(appleList);
//		str.sort((s1,s2) -> s1.compareTo(s2));
		str.sort(String::compareToIgnoreCase);
		System.out.println(str);
//		BiPredicate<List<String>,String> contains = (List<String> list,String element) -> list.contains(element);
//		contains = List::contains;
		Function<String, Integer> stringtoInteger = (s) -> Integer.parseInt(s);
		System.out.println(filter("12",Integer::parseInt));
		
		Supplier<Apple> a1 = Apple::new;
		Apple a = a1.get();
		System.out.println(a);
		
		Function<Integer, Apple> f = Apple::new;
		Apple a2 = f.apply(110);
		System.out.println(a2);
		List<Integer> list = Arrays.asList(1,2,3,4,5);	
		System.out.println(map(list,Apple::new));
		
		BiFunction<String, Integer, Apple> c3 = Apple :: new;
		Apple a3 = c3.apply("red", 110);
		System.out.println(a3);
		
		System.out.println(giveMeFruit("apple", 520));
		System.out.println(giveMeFruit_("orange", "blue", 1314));
	}
}
