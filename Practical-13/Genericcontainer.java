class Box<T> {
    private T value;

    public void set(T value) {
        this.value = value;
    }

    public T get() {
        return value;
    }
}

class Pair<A, B> {
    private A first;
    private B second;

    public Pair(A first, B second) {
        this.first = first;
        this.second = second;
    }

    public A getFirst() {
        return first;
    }

    public B getSecond() {
        return second;
    }
}

public class Genericcontainer {

    // Generic method to return the first element of an array
    public static <T> T firstElement(T[] array) {
        if (array == null || array.length == 0) {
            return null;
        }
        return array[0];
    }

    public static void main(String[] args) {

        // Using Box with different types
        Box<Integer> intBox = new Box<>();
        intBox.set(100);
        System.out.println("Integer Box: " + intBox.get());

        Box<String> strBox = new Box<>();
        strBox.set("Hello Java");
        System.out.println("String Box: " + strBox.get());

        // Using Pair with different types
        Pair<String, Integer> p1 =
                new Pair<>("Jigar", 20);

        System.out.println("Pair First: " + p1.getFirst());
        System.out.println("Pair Second: " + p1.getSecond());

        // Using generic method
        String[] names = {"Jigar", "Rahul", "Amit"};
        Integer[] numbers = {10, 20, 30};

        System.out.println("First Name: " +
                firstElement(names));

        System.out.println("First Number: " +
                firstElement(numbers));
    }
}