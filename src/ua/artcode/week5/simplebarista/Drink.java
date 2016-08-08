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

    public final void prepareRecipe(){
        System.out.println("Making " + this.getClass().getSimpleName() + "...");
        boilWater();
        addAdditions();
        pourInCup();
        System.out.println(this.getClass().getSimpleName() + " is ready\n");
    };

    public abstract void addAdditions();
}
