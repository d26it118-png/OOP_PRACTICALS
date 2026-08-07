abstract class Employee {

    String name;
    int id;

    Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    abstract double monthlySalary();
}
class FullTime extends Employee {

    double salary;

    FullTime(String name, int id, double salary) {
        super(name, id);
        this.salary = salary;
    }

    double monthlySalary() {
        return salary;
    }
}
class PartTime extends Employee {

    int hours;
    double rate;

    PartTime(String name, int id, int hours, double rate) {
        super(name, id);
        this.hours = hours;
        this.rate = rate;
    }

    double monthlySalary() {
        return hours * rate;
    }
}
class Intern extends Employee {

    double stipend;

    Intern(String name, int id, double stipend) {
        super(name, id);
        this.stipend = stipend;
    }

    double monthlySalary() {
        return stipend;
    }
}
class employees{

    public static void main(String args[]) {

        Employee e[] = new Employee[3];

        e[0] = new FullTime("Jigar", 1, 60000);
        e[1] = new PartTime("Jash", 2, 80, 800);
        e[2] = new Intern("Shivam", 3, 70000);

        double total = 0;

        for (int i = 0; i < e.length; i++) {

            System.out.println(e[i].name + " Salary = " + e[i].monthlySalary());

            total = total + e[i].monthlySalary();

            if (e[i] instanceof Intern) {
                System.out.println("Note: This employee is an Intern.");
            }
        }

        System.out.println("Total Salary = " + total);
    }
}