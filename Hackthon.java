import java.util.Scanner;

class Hackthon {
    private String studentName;
    private String rollNumber;
    private double marks;
    private String courseName;
    private int courseCredits;

    // Parameterized constructor
    public Student(String studentName, String rollNumber, double marks, String courseName, int courseCredits) {
        this.studentName = studentName;
        this.rollNumber = rollNumber;
        this.marks = marks;
        this.courseName = courseName;
        this.courseCredits = courseCredits;
    }

    // Method to check eligibility
    public boolean checkEligibility() {
        return this.marks >= 50;
    }

    // Method to calculate total course fee
    public double calculateFee() {
        return this.courseCredits * 1500.0;
    }

    // Method to calculate scholarship amount based on marks
    public double calculateScholarship() {
        double fee = calculateFee();
        if (this.marks >= 85) {
            return fee * 0.20; // 20% scholarship
        } else if (this.marks >= 70) {
            return fee * 0.10; // 10% scholarship
        } else {
            return 0.0; // No scholarship
        }
    }

    // Method to calculate final fee after scholarship deduction
    public double calculateFinalFee() {
        return calculateFee() - calculateScholarship();
    }

    // Method to display all details
    public void displayDetails() {
        System.out.println("\n--- Student Registration Details ---");
        System.out.println("Student Name: " + studentName);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Marks: " + marks);
        System.out.println("Course Name: " + courseName);
        System.out.println("Course Credits: " + courseCredits);
        System.out.println("Eligibility Status: Eligible");
        System.out.println("Total Course Fee: Rs. " + calculateFee());
        System.out.println("Scholarship Amount: Rs. " + calculateScholarship());
        System.out.println("Final Fee to Pay: Rs. " + calculateFinalFee());
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Reading student details
        System.out.print("Enter Student Name: ");
        String studentName = scanner.nextLine();

        System.out.print("Enter Roll Number: ");
        String rollNumber = scanner.nextLine();

        System.out.print("Enter Marks: ");
        double marks = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        System.out.print("Enter Course Name: ");
        String courseName = scanner.nextLine();

        System.out.print("Enter Course Credits: ");
        int courseCredits = scanner.nextInt();

        // Creating Student object
        Student student = new Student(studentName, rollNumber, marks, courseName, courseCredits);

        // Check eligibility and process registration
        if (student.checkEligibility()) {
            student.displayDetails();
        } else {
            System.out.println("\n--- Student Registration Details ---");
            System.out.println("Student Name: " + studentName);
            System.out.println("Roll Number: " + rollNumber);
            System.out.println("Marks: " + marks);
            System.out.println("Eligibility Status: Not Eligible for registration (Marks are below 50).");
        }

        scanner.close();
    }
}