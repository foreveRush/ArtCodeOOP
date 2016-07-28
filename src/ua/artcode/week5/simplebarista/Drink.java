package ua.artcode.week5.simplebarista;

/**
 * Created by Serhii Fursenko on 28.07.16.
 */
public abstract class Drink {

    public void boilWater() {
        System.out.println("Boiling water");
    }

    public void pourInCup() {
        System.out.println("Pouring into cup");
    }

    public abstract void prepareRecipe();
}
