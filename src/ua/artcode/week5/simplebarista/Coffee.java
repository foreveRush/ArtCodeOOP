package ua.artcode.week5.simplebarista;

public class Coffee extends Drink{
 
	public void brewCoffeeGrinds() {
		System.out.println("Dripping Coffee through filter");
	}
 
	public void addSugarAndMilk() {
		System.out.println("Adding Sugar and Milk");
	}

	@Override
	public void addAdditions() {
		brewCoffeeGrinds();
		addSugarAndMilk();
	}
}
