import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static List<student> studentList = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean exit = false;
        while (!exit) {
            System.out.println("\nMENU:");
            System.out.println("1. Enter new student information");
            System.out.println("2. Print student list");
            System.out.println("3. Delete student by student code");
            System.out.println("4. Sort students by descending score");
            System.out.println("5. Search students by code or name");
            System.out.println("6. Search students with score >= x");
            System.out.println("0. Exxit");
            System.out.print("Select function: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over

            switch (choice) {
                case 1:
                    inputStudent();
                    break;
                case 2:
                    outputStudents();
                    break;
                case 3:
                    removeStudentByCode();
                    break;
                case 4:
                    sortByGradeDescending();
                    break;
                case 5:
                    searchStudentByCodeOrName();
                    break;
                case 6:
                    filterStudentsByGrade();
                    break;
                case 0:
                    exit = true;
                    System.out.println("Program exited.");
                    break;
                default:
                    System.out.println("Invalid selection. Please select again.");
            }
        }
    }

    public static void inputStudent() {
        System.out.println("Enter student information:");

        System.out.print("Student code: ");
        String code = scanner.nextLine();

        System.out.print("Full name: ");
        String name = scanner.nextLine();

        System.out.print("Age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over

        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Phone: ");
        String phone = scanner.nextLine();

        System.out.print("Giới tính (0-male, 1-female): ");
        int gender = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over

        System.out.print("Scores: ");
        float grade = scanner.nextFloat();
        scanner.nextLine(); // Consume newline left-over

        student student = new student(code, name, age, email, phone, gender, grade);
        studentList.add(student);
        System.out.println("Student added successfully.");
    }

    public static void outputStudents() {
        if (studentList.isEmpty()) {
            System.out.println("Empty student list.");
        } else {
            System.out.println("\nLIST OF STUDENTS:");
            for (student student : studentList) {
                System.out.println(student.toString());
            }
        }
    }

    public static void removeStudentByCode() {
        System.out.print("Enter the student code to delete: ");
        String code = scanner.nextLine();

        boolean removed = false;
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getCode().equalsIgnoreCase(code)) {
                studentList.remove(i);
                removed = true;
                System.out.println("Deleted student with code " + code);
                break;
            }
        }

        if (!removed) {
            System.out.println("No student found with code " + code);
        }
    }

    public static void sortByGradeDescending() {
        studentList.sort((s1, s2) -> Float.compare(s2.getGrade(), s1.getGrade()));
        System.out.println("Arranged students in descending order of score.");
    }

    public static void searchStudentByCodeOrName() {
        System.out.print("Enter student code or student name to find: ");
        String keyword = scanner.nextLine().toLowerCase();

        boolean found = false;
        for (student student : studentList) {
            if (student.getCode().toLowerCase().contains(keyword) || student.getName().toLowerCase().contains(keyword)) {
                System.out.println(student.toString());
                found = true;
            }
        }

        if (!found) {
            System.out.println("No students found with keyword '" + keyword + "'");
        }
    }

    public static void filterStudentsByGrade() {
        System.out.print("Enter minimum score: ");
        float minGrade = scanner.nextFloat();
        scanner.nextLine(); // Consume newline left-over

        List<student> filteredList = new ArrayList<>();
        for (student student : studentList) {
            if (student.getGrade() >= minGrade) {
                filteredList.add(student);
            }
        }

        if (filteredList.isEmpty()) {
            System.out.println("No students have score >= " + minGrade);
        } else {
            System.out.println("\nSTUDENTS HAVE SCORE >= " + minGrade);
            for (student student : filteredList) {
                System.out.println(student.toString());
            }
        }
    }
}
