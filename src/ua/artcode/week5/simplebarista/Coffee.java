package ua.artcode.week5.simplebarista;

public class Coffee extends Drink{
 
	public void prepareRecipe() {
		System.out.println("Making coffee...");
		boilWater();
		brewCoffeeGrinds();
		pourInCup();
		addSugarAndMilk();
		System.out.println("Coffee is ready\n");
	}
 
	public void brewCoffeeGrinds() {
		System.out.println("Dripping Coffee through filter");
	}
 
	public void addSugarAndMilk() {
		System.out.println("Adding Sugar and Milk");
	}
}
