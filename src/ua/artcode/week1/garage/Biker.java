package ua.artcode.week1.garage;

/**
 * Created by home on 07.07.2016.
 */
public class Biker {

    Moto moto;

    public void buyMotorcycle(Moto moto) {

        this.moto = moto;
    }

    public void sellMotorcycle() {
        moto = null;
        System.out.println("Motorcycle saled");
    }

    public void fixMotorcycle() {
        System.out.println("Motorcycle fixed");
    }
}
