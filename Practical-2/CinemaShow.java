class CinemaShow {

    private String title;
    private int seatsAvailable;
    private final int capacity;

    private static int totalBooked = 0;

    // Constructor
    CinemaShow(String title, int capacity) {
        this.title = title;
        this.capacity = capacity;
        seatsAvailable = capacity;
    }

    // Constructor with default capacity
    CinemaShow(String title) {
        this(title, 100);
    }

    // Book seats
    boolean book(int n) {
        if (n <= seatsAvailable) {
            seatsAvailable = seatsAvailable - n;
            totalBooked = totalBooked + n;
            return true;
        } else {
            return false;
        }
    }

    // Cancel seats
    void cancel(int n) {
        seatsAvailable = seatsAvailable + n;

        if (seatsAvailable > capacity) {
            seatsAvailable = capacity;
        }
    }

    int getSeatsAvailable() {
        return seatsAvailable;
    }

    static int getTotalBooked() {
        return totalBooked;
    }

    public static void main(String[] args) {

        CinemaShow show = new CinemaShow("Avengers", 50);

        System.out.println("Book 20 : " + show.book(20));
        System.out.println("Seats Left : " + show.getSeatsAvailable());

        System.out.println();

        System.out.println("Book 25 : " + show.book(25));
        System.out.println("Seats Left : " + show.getSeatsAvailable());

        System.out.println();

        System.out.println("Book 10 : " + show.book(10));
        System.out.println("Seats Left : " + show.getSeatsAvailable());

        System.out.println();

        show.cancel(15);
        System.out.println("After Cancel");
        System.out.println("Seats Left : " + show.getSeatsAvailable());

        System.out.println();

        System.out.println("Book 10 : " + show.book(10));
        System.out.println("Seats Left : " + show.getSeatsAvailable());

        System.out.println();

        System.out.println("Total Booked = " + CinemaShow.getTotalBooked());
    }
}