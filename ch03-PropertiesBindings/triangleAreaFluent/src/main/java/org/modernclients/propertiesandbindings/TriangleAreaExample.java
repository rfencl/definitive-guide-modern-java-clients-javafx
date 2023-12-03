package org.modernclients.propertiesandbindings;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.NumberBinding;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
class Point {
    public IntegerProperty x;
    public IntegerProperty y;

    public Point (IntegerProperty x, IntegerProperty y) {
        this.x = x;
        this.y = y;
    }

    public void set(int x, int y) {
        this.x.set(x);
        this.y.set(y);
    }

}
public class TriangleAreaExample {
    public static void main(String[] args) {
        Point p1 = new Point (new SimpleIntegerProperty(0), new SimpleIntegerProperty(0));
        Point p2 = new Point (new SimpleIntegerProperty(0), new SimpleIntegerProperty(0));
        Point p3 = new Point (new SimpleIntegerProperty(0), new SimpleIntegerProperty(0));
//        final NumberBinding p1p2 = Bindings.multiply(p1.x, p2.y);
//        final NumberBinding p2p3 = Bindings.multiply(p2.x, p3.y);
//        final NumberBinding p2p1 = Bindings.multiply(p2.x, p1.y);
//        final NumberBinding p3p2 = Bindings.multiply(p3.x, p2.y);
//        final NumberBinding sum2 = Bindings.add(Bindings.add(p1p2, p2p3), Bindings.multiply(p3.x, p1.y));
//        final NumberBinding diff1 = Bindings.subtract(Bindings.add(sum2, Bindings.multiply(p3.x, p1.y)), Bindings.multiply(p1.x, p3.y));
//        final NumberBinding diff2 = Bindings.subtract(diff1, p2p1);
//        final NumberBinding determinant = Bindings.subtract(diff2, p3p2);
//        final NumberBinding area = Bindings.divide(determinant, 2.0D);

        // The fluent version
        final NumberBinding area = p1.x.multiply(p2.y)
                .add(p2.x.multiply(p3.y))
                .add(p3.x.multiply(p1.y))
                .subtract(p1.x.multiply(p3.y))
                .subtract(p2.x.multiply(p1.y))
                .subtract(p3.x.multiply(p2.y))
                .divide(2.0D);

        p1.set(0, 0);
        p2.set(6, 0);
        p3.set(4,3);
        printResult(p1, p2, p3, area);
        p1.set(1, 0);
        p2.set(2, 2);
        p3.set(0, 1);
        printResult(p1, p2, p3, area);
    }

    private static void printResult(Point p1, Point p2, Point p3, NumberBinding area) {
        System.out.println("For A(" +
                p1.x.get() + "," + p1.y.get() + "), B(" +
                p2.x.get() + "," + p2.y.get() + "), C(" +
                p3.x.get() + "," + p3.y.get() +
                "), the area of triangle ABC is " +
                area.getValue());
    }
}