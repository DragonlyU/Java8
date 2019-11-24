package lyx;

import java.util.Arrays;
import java.util.List;
import static java.util.stream.Collectors.toList;

public class Lyx_lambda_stream {

	
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
		List<String> threeHighCaloriesDishName = menu.stream()
				.filter(d -> {
					System.out.println("filtering :" + d.getName());
					return d.getCalories() > 300;
				})
				.map(d ->{
					System.out.println("mapping :" + d.getName());
					return d.getName();
				})
				.limit(3)
				.collect(toList());
//		System.out.println(threeHighCaloriesDishName);
		
		
//		menu.parallelStream().forEach(System.out::println);
		
		long count = menu.stream()
				.filter(d -> d.getCalories() > 300)
				.distinct()
				.limit(3)
				.count();
//		System.out.println(count);
		List<Dish> dishList = menu.stream()
				.filter(Dish :: isVegetarian)
				.collect(toList());
		System.out.println(dishList);
	}
}
