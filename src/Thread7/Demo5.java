package Thread7;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 绿字
 * Date: 2024-01-01
 * Time: 9:56
 */

class Point {
    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // 1.笛卡尔坐标系
    public static Point createByXY(double x,double y) {
        return new Point(x,y);
    }

    // 2.极坐标系
    public static Point createByRT(double rth,double theta) {
        double x = rth * Math.cos(theta);
        double y = rth * Math.sin(theta);
        return new Point(x,y);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}
public class Demo5 {
    public static void main(String[] args) {
        Point point = Point.createByXY(10,10);

    }
}
