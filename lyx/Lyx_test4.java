package lyx;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Lyx_test4 {

//jdk 1.7标准写法	
	public static void main(String[] args) {
		List<Dish> lowCalorichDishes = new ArrayList<>();
		
		List<Dish> menu = null; //Arrays.asList(new Dish(500, "lyx"), new Dish(399,"lianlong"), new Dish(345,"xg"));
		menu = Arrays.asList(
				new Dish("pork", false, 800, Dish.Type.MEAT), 
				new Dish("beef", false, 700, Dish.Type.MEAT),
				new Dish("chicken", false, 400, Dish.Type.MEAT),
				new Dish("french fries", true, 530, Dish.Type.OTHER),
				new Dish("rice", true, 350, Dish.Type.OTHER),
				new Dish("season fruit", true, 120, Dish.Type.OTHER),
				new Dish("pizza", true, 550, Dish.Type.OTHER),
				new Dish("prawns", false, 300, Dish.Type.FISH),
				new Dish("salmon", false, 450, Dish.Type.FISH));
		
		for(Dish d : menu) {
			if(d.getCalories() < 400) {
				lowCalorichDishes.add(d);
			}
		}
		Collections.sort(lowCalorichDishes, new Comparator<>() {

			@Override
			public int compare(Dish d1, Dish d2) {
				return Integer.compare(d1.getCalories(), d2.getCalories());
			}
			
			
		});
		
		List<String> lowCaloricDishesName = new ArrayList<String>();
		for(Dish d : lowCalorichDishes) {
			lowCaloricDishesName.add(d.getName());
		}
		
		System.out.println(lowCaloricDishesName);
	}
	
}
