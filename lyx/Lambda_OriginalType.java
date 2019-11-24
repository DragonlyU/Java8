package lyx;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Lambda_OriginalType {

	public static void main(String[] args) {
		List<Dish> menu = Arrays.asList(
				new Dish("pork", false, 800, Dish.Type.MEAT),  
				new Dish("beef", false, 700, Dish.Type.MEAT),
				new Dish("chicken", false, 400, Dish.Type.MEAT),
				new Dish("french fries", true, 530, Dish.Type.OTHER),
				new Dish("rice", true, 350, Dish.Type.OTHER),
				new Dish("season fruit", true, 120, Dish.Type.OTHER),
				new Dish("pizza", true, 550, Dish.Type.OTHER),
				new Dish("prawns", false, 300, Dish.Type.FISH),
				new Dish("salmon", false, 450, Dish.Type.FISH));
		int sum = menu.stream().mapToInt(Dish::getCalories).sum();
		System.out.println(sum);
		int max = menu.parallelStream().mapToInt(Dish::getCalories).max().orElse(1);
		System.out.println(max);
		IntStream evenNumbers = IntStream.rangeClosed(1, 100).filter(i -> i % 2 == 0);//range 不包含结束值，rangeClosed包含结束值
		System.out.println(evenNumbers.sum());
		
//		IntStream.rangeClosed(1, 100)
//		.filter(b -> Math.sqrt(a*a + b*b) % 1 == 0)
//		.boxed()
//		.map(b -> new int[] {a, b, (int)Math.sqrt(a*a + b*b)});
		Stream<int[]> pythagoreanTriples = IntStream.rangeClosed(1, 100).boxed()
				.flatMap(a ->
					IntStream.rangeClosed(a, 100)
						.filter(b -> Math.sqrt(a*a + b*b) % 1 == 0)
						.mapToObj(b -> 
								new int[] {a, b, (int)Math.sqrt(a*a + b*b)})
						);
		
//		pythagoreanTriples.limit(3).forEach(t -> System.out.println(t[0] + ", " + t[1] + " ," + t[2]));
		
		Stream<double[]> triples = IntStream.rangeClosed(1, 100).boxed()
				.flatMap(a ->
					IntStream.rangeClosed(a, 100)
							  .mapToObj(b -> new double[] {a, b, Math.sqrt(a*a + b*b)})
							  .filter(t -> t[2] % 1 == 0)
						);
//		System.out.println(triples.count());
		triples.forEach(t -> System.out.println(t[0] + ", " + t[1] + " ," + t[2]));
		
	}
	
}
