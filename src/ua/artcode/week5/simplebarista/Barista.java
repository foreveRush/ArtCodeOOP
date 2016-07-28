package ua.artcode.week5.simplebarista;

public class Barista {

    public static void main(String[] args) {

        Drink[] drinks = {new Tea(), new Coffee()};

        for (Drink drink : drinks) {
            drink.prepareRecipe();
        }
    }
}
