package lyx;

import java.util.function.Function;

public class Lyx_test3 {
	
	public static void main(String[] args) {
//		Apple redApple = new Apple("red",130);
//		Predicate<Apple> redApple = (a) -> "red".equals(a.getColor());
//		Predicate<Apple> notredApple = redApple.negate(); //negate 相反的
//		
//		Predicate<Apple> redAndHeavyApple = redApple.and(a -> a.getWeight() >150);
//		
//		Predicate<Apple> redAndHeavyOrGreenApple = redApple.and(a -> a.getWeight() > 150).or(a -> "green".equals(a.getColor()));
		
		Function<Integer, Integer> f = x -> x + 1;
		Function<Integer, Integer> g = x -> x * 2;
		Function<Integer, Integer> h = f.andThen(g); // 数学中表达式 g(f(x))
		Function<Integer, Integer> j = f.compose(g);//  数学中表达是 f(g(x))
		int result = h.apply(1);
		int res = j.apply(1);
		System.out.println(result);
		System.out.println(res);
	}
}
