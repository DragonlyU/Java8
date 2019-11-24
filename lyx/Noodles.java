package lyx;

public class Noodles implements Menu{

	private String calories;

	public String getCalories() {
		return calories;
	}

	public void setCalories(String calories) {
		this.calories = calories;
	}

	@Override
	public String toString() {
		return "Noodles [calories=" + calories + "]";
	}
	
}
