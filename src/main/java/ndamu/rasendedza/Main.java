package ndamu.rasendedza;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        int choice;

        // Main loop, because what program is complete without one?
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Add Student");
            System.out.println("2. Display Marksheet");
            System.out.println("3. Search Student");
            System.out.println("4. Show Students");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            // Get the user's choice
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Clear invalid input
            }
            choice = scanner.nextInt();

            try {
                switch (choice) {
                    case 1:
                        addStudent(students, scanner); // Add a new student, because we all need more friends
                        break;
                    case 2:
                        displayMarksheet(students); // Display the marksheet for all students, because we like to show
                        // off
                        break;
                    case 3:
                        searchStudent(students, scanner); // Search for a student by name, because sometimes we forget
                        break;
                    case 4:
                        showStudents(students, scanner); // Show all students, because it's nice to see them all
                        break;
                    case 5:
                        System.out.println("Exiting..."); // Finally, we get to leave
                        break;
                    default:
                        System.out.println("Invalid choice!"); // The user can't follow instructions
                }
            } catch (Exception e) {
                // Catching all the exceptions because we are too cool to crash!
                System.out.println("Oops! Something went wrong: " + e.getMessage());
            }
        } while (choice != 5); // Back to the top!

        scanner.close();
    }

    private static void addStudent(ArrayList<Student> students, Scanner scanner) {
        System.out.print("Enter student name: ");
        scanner.nextLine(); // Consume newline left-over
        String name = scanner.next(); // Get that name

        // How many subjects does this student have?
        System.out.print("Enter number of subjects: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.next(); // Clear invalid input
        }
        int numSubjects = scanner.nextInt();

        if (numSubjects <= 0) {
            System.out.println("Number of subjects must be greater than zero."); // No subjects, no student
            return;
        }

        ArrayList<Integer> marks = new ArrayList<>();
        // Loop to get all the marks
        for (int i = 0; i < numSubjects; i++) {
            System.out.print("Enter marks for subject " + (i + 1) + ": ");
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Clear invalid input
            }
            marks.add(scanner.nextInt()); // Adding the marks to our list
        }

        students.add(new Student(name, marks)); // Finally, we add our new student
        System.out.println("Student added successfully!");
    }

    private static void displayMarksheet(ArrayList<Student> students) {
        // Display the marksheet for all students, because we like to show off
        if (students.isEmpty()) {
            System.out.println("No students found!"); // Sad times, no students
            return;
        }

        for (Student student : students) {
            System.out.println(student); // Assuming grades are already calculated
        }
    }

    private static void searchStudent(ArrayList<Student> students, Scanner scanner) {
        System.out.print("Enter student name to search: ");
        scanner.nextLine(); // Consume newline left-over
        String name = scanner.next(); // Get that name

        Student foundStudent = null;
        // Look for the student in our list
        for (Student student : students) {
            if (student.getName().equals(name)) {
                foundStudent = student;
                break;
            }
        }

        if (foundStudent != null) {
            System.out.println(foundStudent); // We found them, job done
            searchStudentMenu(foundStudent, students, scanner);
        } else {
            System.out.println("Student not found!"); // Whoops, no such student
        }
    }

    private static void searchStudentMenu(Student student, ArrayList<Student> students, Scanner scanner) {
        int choice;

        // This menu is like a secret level in a game
        do {
            System.out.println("\nSearch Student Menu:");
            System.out.println("1. Update Marks");
            System.out.println("2. Delete Student");
            System.out.println("3. Back");
            System.out.print("Enter your choice: ");

            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Clear invalid input
            }
            choice = scanner.nextInt();

            try {
                switch (choice) {
                    case 1:
                        updateMarks(student, scanner); // Update marks for a student, because sometimes mistakes happen
                        break;
                    case 2:
                        deleteStudent(students, student); // Delete a student, because sometimes it's just not working
                        // out
                        break;
                    case 3:
                        break;
                    default:
                        System.out.println("Invalid choice!"); // The user can't follow instructions
                }
            } catch (Exception e) {
                System.out.println("Error in Search Student Menu: " + e.getMessage());
            }
        } while (choice != 3);
    }

    private static void showStudents(ArrayList<Student> students, Scanner scanner) {
        // Display all students before the menu
        if (students.isEmpty()) {
            System.out.println("No students found!"); // Again, no students
            return;
        }

        for (Student student : students) {
            System.out.println(student); // Showing off the students' marks (like i would like to show off my MySQL project marks but nooo someone gave me a 51% whyyyyy)
        }

        int choice;

        do {
            System.out.println("\nShow Students Menu:");
            System.out.println("1. Sort Students");
            System.out.println("2. Back");
            System.out.print("Enter your choice: ");

            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Clear invalid input
            }
            choice = scanner.nextInt();

            try {
                switch (choice) {
                    case 1:
                        sortStudentsMenu(students, scanner); // Sort students based on total marks (ascending order), because order is everything
                        break;
                    case 2:
                        break;
                    default:
                        System.out.println("Invalid choice!"); // The user can't follow instructions
                }
            } catch (Exception e) {
                System.out.println("Error in Show Students Menu: " + e.getMessage());
            }
        } while (choice != 2);
    }

    private static void sortStudentsMenu(ArrayList<Student> students, Scanner scanner) {
        int choice;

        do {
            System.out.println("\nSort Students Menu:");
            System.out.println("1. By Name");
            System.out.println("2. By Marks");
            System.out.println("3. Back");
            System.out.print("Enter your choice: ");

            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Clear invalid input
            }
            choice = scanner.nextInt();

            try {
                switch (choice) {
                    case 1:
                        sortStudentsByName(students); // Sort students by name, because alphabetical order is cool
                        displayMarksheet(students); // Display the marksheet for all students, because we like to show off
                        break;
                    case 2:
                        sortStudentsByMarks(students); // Sort students by their total marks, high scores rule!
                        displayMarksheet(students); // Display the marksheet for all students, because we like to show off
                        break;
                    case 3:
                        break;
                    default:
                        System.out.println("Invalid choice!"); // The user can't follow instructions
                }
            } catch (Exception e) {
                System.out.println("Error in Sort Students Menu: " + e.getMessage());
            }
        } while (choice != 3);
    }

    private static void sortStudentsByName(ArrayList<Student> students) {
        // Sorting students by name, because alphabetical order is cool (although ill be last )
        students.sort((s1, s2) -> s1.getName().compareTo(s2.getName()));
    }

    private static void sortStudentsByMarks(ArrayList<Student> students) {
        // Sorting students by their total marks, high scores rule!
        students.sort((s1, s2) -> Integer.compare(s1.getTotalMarks(), s2.getTotalMarks()));
    }

    private static void updateMarks(Student student, Scanner scanner) {
        int choice;

        do {
            System.out.println("\nUpdate Marks Menu:");
            System.out.println("1. Update marks for all subjects");
            System.out.println("2. Update marks for a specific subject");
            System.out.println("3. Back");
            System.out.print("Enter your choice: ");

            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Clear invalid input
            }
            choice = scanner.nextInt();

            try {
                switch (choice) {
                    case 1:
                        updateAllMarks(student, scanner); // Update the marks  (like we should on my MySQL project how did i get 51% 😭😭 still not okay)
                        break;
                    case 2:
                        updateSpecificMark(student, scanner); // Update the marks
                        break;
                    case 3:
                        break;
                    default:
                        System.out.println("Invalid choice!"); // The user can't follow instructions
                }
            } catch (Exception e) {
                System.out.println("Error in Update Marks Menu: " + e.getMessage());
            }
        } while (choice != 3);
    }

    private static void updateAllMarks(Student student, Scanner scanner) {
        ArrayList<Integer> marks = new ArrayList<>();
        // Loop to get all the marks
        for (int i = 0; i < student.getMarks().size(); i++) {
            System.out.print("Enter new marks for subject " + (i + 1) + ": ");

            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Clear invalid input
            }
            marks.add(scanner.nextInt()); // Adding the marks to our list
        }
        student.setMarks(marks);
        System.out.println("Marks updated successfully!"); // We did it!
    }

    private static void updateSpecificMark(Student student, Scanner scanner) {
        System.out.print("Enter subject number to update (1-" + student.getMarks().size() + "): ");

        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.next(); // Clear invalid input
        }
        int subjectNumber = scanner.nextInt();

        if (subjectNumber < 1 || subjectNumber > student.getMarks().size()) {
            System.out.println("Invalid subject number!"); // Whoops, no such student
            return;
        }

        System.out.print("Enter new marks for subject " + subjectNumber + ": ");

        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.next(); // Clear invalid input
        }
        int newMark = scanner.nextInt();

        student.getMarks().set(subjectNumber - 1, newMark); // Update the marks
        System.out.println("Marks updated successfully!"); // We did it!
    }

    private static void deleteStudent(ArrayList<Student> students, Student student) {
        students.remove(student); // Remove the student
        System.out.println("Student deleted successfully!"); // Gone, but not forgotten
    }
}



// if i get 51% on this one i swear ill quit

// Pseudocode for the program (im currently reading the Basic Programming Principles 2nd Edition by CM Pretorius and HG Erasmus ) can i also get feedback on this please?
/*
 * 1. Initialize scanner and students list.
 * 2. Main loop:
 * a. Display menu.
 * b. Get user choice.
 * c. Perform action based on choice:
 * i. Add student.
 * ii. Display marksheet.
 * iii. Search student.
 * iv. Show students.
 * v. Exit.
 * 3. Add student:
 * a. Get student name and number of subjects.
 * b. Get marks for each subject.
 * c. Create and add student to the list.
 * 4. Display marksheet:
 * a. Check if students list is empty.
 * b. Display each student's details.
 * 5. Search student:
 * a. Get student name.
 * b. Search for student in the list.
 * c. If found, display student details and show search student menu.
 * 6. Search student menu:
 * a. Update marks.
 * b. Delete student.
 * c. Back to main menu.
 * 7. Show students:
 * a. Check if students list is empty.
 * b. Display all students.
 * c. Show sort students menu.
 * 8. Sort students menu:
 * a. Sort by name.
 * b. Sort by marks.
 * c. Back to show students menu.
 * 9. Update marks menu:
 * a. Update all marks.
 * b. Update specific mark.
 * c. Back to search student menu.
 * 10. Functions to sort students by name and marks.
 * 11. Functions to update all marks and specific mark.
 * 12. Function to delete student from the list.
 * 13. Student class:
 * a. Constructor, getters, and setters.
 * b. Calculate total marks and average.
 * c. Calculate grade based on average.
 * d. Override toString method to display student details.
 */
