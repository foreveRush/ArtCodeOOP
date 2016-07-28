package ua.artcode.week5.simplebarista;

public class Tea extends Drink{
 
	public void prepareRecipe() {
		System.out.println("Making tea...");
		boilWater();
		steepTeaBag();
		pourInCup();
		addLemon();
		System.out.println("Tea is ready\n");
	}

	public void steepTeaBag() {
		System.out.println("Steeping the tea");
	}
 
	public void addLemon() {
		System.out.println("Adding Lemon");
	}
 

}
