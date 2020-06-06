
public class HugePizza extends Pizza{

	//Variables
	private String name;
	private int calories;
	private double basePrice;
	
	//Constructor
	public HugePizza(String name, int calories) {
		this.name = name;
		this.calories = calories;
		this.basePrice = 55;
	}
	
	@Override
	public double getTotal() {
		return this.basePrice;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCalories() {
		return calories;
	}

	public void setCalories(int calories) {
		this.calories = calories;
	}
	
	


}
