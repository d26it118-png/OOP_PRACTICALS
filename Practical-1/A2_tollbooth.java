import java.util.Scanner;

public class A2_tollbooth {

    static class VehicleRecord {
        private final String registrationNo;
        private final String category;

        public VehicleRecord(String registrationNo, String category) {
            this.registrationNo = registrationNo;
            this.category = category;
        }

        public String registrationNo() {
            return registrationNo;
        }

        public String category() {
            return category;
        }
    }

    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        int totalCollection = 0, motorcycleCount = 0, heavyVehicleCount = 0, passengerCarCount = 0;

        System.out.println("ENTER VEHICLE (Type 'done' for STOP):");

        while (true) {
            System.out.print("Enter Vehicle Number: ");
            String regNum = inputScanner.next().toUpperCase();

            if (regNum.equals("DONE")) {
                break;
            }

            System.out.print("Vehicle Type (bike, car, truck): ");
            String vehType = inputScanner.next().toLowerCase();

            VehicleRecord currentVehicle = new VehicleRecord(regNum, vehType);

            switch (currentVehicle.category()) {
                case "bike":
                    motorcycleCount++;
                    totalCollection += 20;
                    System.out.println(" " + currentVehicle.registrationNo() + " (" + currentVehicle.category() + ") pays 20.");
                    break;
                case "car":
                    passengerCarCount++;
                    totalCollection += 50;
                    System.out.println(" " + currentVehicle.registrationNo() + " (" + currentVehicle.category() + ") pays 50.");
                    break;
                case "truck":
                    heavyVehicleCount++;
                    totalCollection += 150;
                    System.out.println(" " + currentVehicle.registrationNo() + " (" + currentVehicle.category() + ") pays 150.");
                    break;
                default:
                    break;
            }
        }

        System.out.println("\nTotal Toll: " + totalCollection);

        String mostFrequentType;
        if (motorcycleCount > passengerCarCount && motorcycleCount > heavyVehicleCount) {
            mostFrequentType = "bike";
        } else if (passengerCarCount > motorcycleCount && passengerCarCount > heavyVehicleCount) {
            mostFrequentType = "car";
        } else if (heavyVehicleCount > motorcycleCount && heavyVehicleCount > passengerCarCount) {
            mostFrequentType = "truck";
        } else if (motorcycleCount == passengerCarCount && motorcycleCount == heavyVehicleCount) {
            mostFrequentType = "All Vehicle Number are Same";
        } else if (motorcycleCount == passengerCarCount) {
            mostFrequentType = "cars & bikes both";
        } else if (motorcycleCount == heavyVehicleCount) {
            mostFrequentType = "bikes & trucks both";
        } else if (passengerCarCount == heavyVehicleCount) {
            mostFrequentType = "cars & trucks both";
        } else {
            mostFrequentType = "Null";
        }

        if (totalCollection == 0) {
            System.out.println("NOT any Vehicle Pass from TOLL.");
        } else {
            System.out.println("Most Frequent: " + mostFrequentType);
        }
    }
}