package lyx;

public class Apple implements Fruit{

	private String color;
	private int weight;
	
	
	public Apple() {
		super();
	}
	public Apple(int weight) {
		super();
		this.weight = weight;
	}
	
	public Apple(String color, int weight) {
		super();
		this.color = color;
		this.weight = weight;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	@Override
	public String toString() {
		return "Apple [color=" + color + ", weight=" + weight + "]";
	}
	
}
