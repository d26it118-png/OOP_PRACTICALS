
abstract class Shapes{

    abstract double area();
}

class Circle extends Shapes {

    double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    double area() {
        return 3.14 * radius * radius;
    }
}

class Rectangle extends Shapes{

    double length, width;

    Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    double area() {
        return length * width;
    }
}

class Triangle extends Shapes {

    double base, height;

    Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    double area() {
        return 0.5 * base * height;
    }
}

public class shape {
    public static void main(String args[]) {

        Shapes s[] = new Shapes[3];

        s[0] = new Circle(5);
        s[1] = new Rectangle(4, 6);
        s[2] = new Triangle(8, 3);

        double total = 0;
        double largest = 0;

        for (int i = 0; i < s.length; i++) {

            double a = s[i].area();

            System.out.println("Area = " + a);

            total = total + a;

            if (a > largest) {
                largest = a;
            }
        }

        System.out.println("Total Area = " + total);
        System.out.println("Largest Area = " + largest);
    }

}