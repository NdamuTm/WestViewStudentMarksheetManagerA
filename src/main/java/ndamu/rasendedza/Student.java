package ndamu.rasendedza;

import java.util.ArrayList;

public class Student {
    private final String name;
    private ArrayList<Integer> marks;
    private char grade; // Initialize grade as empty character  (first time using char in my life 😂 i never use this i always use String )

    // Constructor, because how else will we make a student?
    public Student(String name, ArrayList<Integer> marks) {
        this.name = name;
        this.marks = marks;
        this.grade = ' ';
        calculateGrade(); // Set that grade
    }

    // Getters and setters, "the backbone of any good class" - Miss Primrose (she didn't say it like this but yeah)
    public String getName() {
        return name;
    }

    public ArrayList<Integer> getMarks() {
        return marks;
    }

    public void setMarks(ArrayList<Integer> marks) {
        this.marks = marks;
        calculateGrade(); // Set that grade
    }

    public int getTotalMarks() {
        // Calculate total marks, because math is important
        int total = 0;
        for (int mark : marks) {
            total += mark;
        }
        return total;
    }

    public double getAverage() {
        // Calculate average, because we need to know where we stand
        return (double) getTotalMarks() / marks.size();
    }

    public char getGrade() {
        return grade;
    }

    private void calculateGrade() {
        // Calculate grades based on marks (replace with your specific grading logic)
        double average = getAverage();
        if (average >= 90) {
            grade = 'A';
        } else if (average >= 80) {
            grade = 'B';
        } else if (average >= 70) {
            grade = 'C';
        } else if (average >= 60) {
            grade = 'D';
        } else {
            grade = 'F';
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Name: ").append(name).append("\n");
        sb.append("Marks: ");

        for (int i = 0; i < marks.size(); i++) {
            sb.append("s").append(i + 1).append(": ").append(marks.get(i)).append(", ");
        }

        sb.delete(sb.length() - 2, sb.length());
        sb.append("\n");

        sb.append("Total Marks: ").append(getTotalMarks()).append("\n");
        sb.append("Average: ").append(getAverage()).append("\n");
        sb.append("Grade: ").append(getGrade()).append("\n");
        return sb.toString();
    }
}