package ua.artcode.week5.testequals;

public class ColorPoint extends Point {
    private Color color;

    public ColorPoint(int x, int y, Color color) {
        super(x, y);
        this.color = color;
    }

     public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Point)) return false;

         return super.equals(o);
    }
}
