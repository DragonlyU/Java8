package lyx;

import java.util.Arrays;
import java.util.List;

public class Lambda_reduce {

	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		int sum = 0;
//		sum = numbers.parallelStream()
//				.reduce(0, (a, b) -> a + b);//lambda表达式
//		sum  = numbers.parallelStream().reduce(0, Integer::sum);//方法引用
		 numbers.parallelStream()
				.reduce(Integer::min)
				.ifPresent(i -> System.out.println(i));
	}
}
