package Square1;

public class Square {

    private int sideLength;
    private int area;

    public Square(int sideLength) {
        this.sideLength = sideLength;
        this.area = sideLength * sideLength;
    }
    public int getArea() {
        return area;
    }
    public void grow() {
        this.sideLength = 2 * sideLength;
    }
}
