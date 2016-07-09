package ua.artcode.week2.servicecenter.model;
import ua.artcode.week2.newpost.model.MyDate;

/**
 * Created by Serhii Fursenko on 09.07.2016.
 * fyrsenko@gmail.com
 */
public class Tech {

    private String title;
    private String serialNumber;
    private int price;
    private MyDate buyDate;
    private Condition condition;

    public Tech(String title, String serialNumber, int price, MyDate buyDate, Condition condition) {
        this.title = title;
        this.serialNumber = serialNumber;
        this.price = price;
        this.buyDate = buyDate;
        this.condition = condition;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }
}
