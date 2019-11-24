package lyx;

public class Apple {

	private String Color;
	private int weight;
	
	public static boolean isGreenApple(Apple apple) {
		return "green".equals(apple.getColor());
	}
	
	public static boolean isHeavyApple(Apple apple) {
		return apple.getWeight() > 150;
	}
	// getter,setter
	public String getColor() {
		return Color;
	}

	public void setColor(String color) {
		Color = color;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	
}
