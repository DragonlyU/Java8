package lyx;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

public class Lx_test2 {

	public static List<Apple> filterGreenApples(List<Apple> inventroy){ // 库存 inventory
		List<Apple>	result = new ArrayList<Apple>();
		for(Apple apple : inventroy) {
			if("green".equals(apple.getColor())) {
				result.add(apple);
			}
		}
		return result;
	}
	
	public static List<Apple> filterHeavyApples(List<Apple> inventroy){
		List<Apple>	result = new ArrayList<Apple>();
		for(Apple apple : inventroy) {
			if(apple.getWeight() > 150) {
				result.add(apple);
			}
		}
		return result;
	}	
	
	
	
	
	static List<Apple> filerApples(List<Apple> inventory, Predicate<Apple> p){//谓词
		List<Apple> result = new ArrayList<Apple>();
		
		for(Apple apple : inventory) {
			if(p.test(apple)) {
				result.add(apple);
			}
		}
		
		return result;
	}
	
	
	
	
	public static void main(String[] args) {
		
		List<Apple> inventory = new ArrayList<Apple>();
		inventory.parallelStream();
		//使用方法引用
		filerApples(inventory , Apple::isGreenApple);
		
	}
}
