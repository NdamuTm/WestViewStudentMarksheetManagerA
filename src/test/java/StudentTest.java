import static org.junit.Assert.*;

import ndamu.rasendedza.Student;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

public class StudentTest {
    private Student student;

    @Before
    public void setUp() {
        ArrayList<Integer> marks = new ArrayList<>();
        marks.add(85);
        marks.add(90);
        marks.add(78);
        student = new Student("John Doe", marks);
    }

    @Test
    public void testGetName() {
        assertEquals("John Doe", student.getName());
    }

    @Test
    public void testGetMarks() {
        ArrayList<Integer> expectedMarks = new ArrayList<>();
        expectedMarks.add(85);
        expectedMarks.add(90);
        expectedMarks.add(78);
        assertEquals(expectedMarks, student.getMarks());
    }

    @Test
    public void testSetMarks() {
        ArrayList<Integer> newMarks = new ArrayList<>();
        newMarks.add(70);
        newMarks.add(75);
        newMarks.add(80);
        student.setMarks(newMarks);
        assertEquals(newMarks, student.getMarks());
        assertEquals('C', student.getGrade());
    }

    @Test
    public void testGetTotalMarks() {
        assertEquals(253, student.getTotalMarks());
    }

    @Test
    public void testGetAverage() {
        assertEquals(84.33, student.getAverage(), 0.01);
    }

    @Test
    public void testGetGrade() {
        assertEquals('B', student.getGrade());
    }

    @Test
    public void testToString() {
        String expected = "Name: John Doe\n" +
                "Marks: s1: 85, s2: 90, s3: 78\n" +
                "Total Marks: 253\n" +
                "Average: 84.33333333333333\n" +
                "Grade: B\n";
        assertEquals(expected, student.toString());
    }


    @Test
    public void testEmptyMarks() {
        ArrayList<Integer> emptyMarks = new ArrayList<>();
        student.setMarks(emptyMarks);
        assertEquals(emptyMarks, student.getMarks());
        assertEquals(0, student.getTotalMarks());
        assertEquals(0.0, student.getAverage(), 0.01);
        assertEquals('F', student.getGrade());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidMarks() {
        ArrayList<Integer> invalidMarks = new ArrayList<>();
        invalidMarks.add(110); // Invalid mark greater than 100
        student.setMarks(invalidMarks);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeMarks() {
        ArrayList<Integer> negativeMarks = new ArrayList<>();
        negativeMarks.add(-5); // Invalid mark less than 0
        student.setMarks(negativeMarks);
    }

    @Test
    public void testPerfectGrade() {
        ArrayList<Integer> perfectMarks = new ArrayList<>();
        perfectMarks.add(100);
        perfectMarks.add(100);
        perfectMarks.add(100);
        student.setMarks(perfectMarks);
        assertEquals(300, student.getTotalMarks());
        assertEquals(100.0, student.getAverage(), 0.01);
        assertEquals('A', student.getGrade());
    }
}
