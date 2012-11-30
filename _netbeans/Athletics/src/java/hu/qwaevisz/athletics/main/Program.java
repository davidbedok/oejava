package hu.qwaevisz.athletics.main;

import hu.qwaevisz.athletics.model.Sex;
import hu.qwaevisz.athletics.model.Sport;
import hu.qwaevisz.athletics.model.Student;
import hu.qwaevisz.athletics.model.StudentCatalog;

public class Program {

    private static void fillModel() {
        StudentCatalog catalog = StudentCatalog.getInstance();
        catalog.addStudent("Alpha", Sex.MAN, 1981, 10, 30);
        catalog.addStudent("Bravo", Sex.MAN, 1975, 2, 20);
        catalog.addStudent("Charlie", Sex.WOMAN, 1990, 3, 8);

        catalog.find("Alpha").addResult(Sport.FLAT_RACE, 14);
        catalog.find("Alpha").addResult(Sport.LONG_JUMP, 4);
        catalog.find("Alpha").addResult(Sport.SMALL_BALL_THROWING, 70);

        catalog.find("Bravo").addResult(Sport.FLAT_RACE, 13);
        catalog.find("Bravo").addResult(Sport.LONG_JUMP, 3);

        catalog.find("Charlie").addResult(Sport.SMALL_BALL_THROWING, 11);
        catalog.find("Charlie").addResult(Sport.LONG_JUMP, 50);
    }
    
    public static void testModel() {
        StudentCatalog catalog = StudentCatalog.getInstance();
        for (Student student : catalog.getStudents()) {
            System.out.println(student);
        }
    }

    public static void main(String[] args) {
        Program.fillModel();
        Program.testModel();
    }
}
