package lyx;


public class Dish implements Menu{

	private final String name;
	private final boolean vegetarian;
	private final Integer calories;
	private final Type type;


	public Dish(String name, boolean vegetarian, Integer calories, Type type) {
		super();
		this.name = name;
		this.vegetarian = vegetarian;
		this.calories = calories;
		this.type = type;
	}


	public boolean isVegetarian() {
		return vegetarian;
	}


	public Type getType() {
		return type;
	}


	public Integer getCalories() {
		return calories;
	}
	

	public String getName() {
		return name;
	}
	
	public enum Type{
		MEAT,FISH,OTHER
	}
	
	@Override
	public String toString() {
		return name;
	}
	
}
