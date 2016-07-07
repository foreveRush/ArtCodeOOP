package ua.artcode.week1.garage;

/**
 * Created by home on 07.07.2016.
 */
public class TestGarage {
    public static void main(String[] args) {

        Parking parking = new Parking(5,"Kiyv", "Lesi", 22);
        Moto moto1 = new Moto();
        moto1.brand = "Suzuki";
        moto1.number = "12345";

        Moto moto2 = new Moto();
        moto2.brand = "Honda";
        moto2.number = "2555";

        Biker biker = new Biker();
        biker.buyMotorcycle(moto1);

        parking.open();
        parking.addMotoByPlaceNumber(biker.moto, 0);

        parking.addMotoOnLastFreePlace(moto2);
        parking.close();

        parking.showAllInGarage();

    }
}
