package ua.artcode.week5.simplebarista;

public class Tea extends Drink{


	public void steepTeaBag() {
		System.out.println("Steeping the tea");
	}
 
	public void addLemon() {
		System.out.println("Adding Lemon");
	}


	@Override
	public void addAdditions() {
		steepTeaBag();
		addLemon();
	}
}
