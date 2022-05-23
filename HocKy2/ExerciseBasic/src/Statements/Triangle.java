package Statements;

/**
 * Triangle
 */
public class Triangle {
    private double a, b, c;

    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public boolean isTriangle() {
        if (a + b > c || a + c > b || b + c > a) {
            return true;
        }
        return false;
    }

    public double perimeter() {
        return a + b + c;
    }

    public double area() {
        double p = (a + b + c) / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    public double angleA() {
        double cosA = (b * b + c * c - a * a) / (2 * b * c);
        double tgA = Math.sqrt(1 / (cosA * cosA) - 1);
        return (Math.atan(tgA) * 180) / Math.PI;
    }

    public static void main(String[] args) {
        Triangle triangle = new Triangle(5, 4, 3);
        if (!triangle.isTriangle()) {
            System.out.println("This isn't triangle");
        } else {
            System.out.println("This is triangle");
            System.out.printf("Perimeter = %.2f\n", triangle.perimeter());
            System.out.printf("Area = %.2f\n", triangle.area());
            System.out.printf("Angle A = %.2f\n", triangle.angleA());
        }
    }
}