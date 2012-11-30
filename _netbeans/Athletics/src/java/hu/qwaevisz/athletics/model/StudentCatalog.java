package hu.qwaevisz.athletics.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class StudentCatalog {

    private final List<Student> students;
    private Calendar calendar;

    public void addStudent(String name, Sex sex, int birthDateYear, int birthDateMonth, int birtDateDayOfMonth) {
        calendar.set(birthDateYear, birthDateMonth, birtDateDayOfMonth);
        this.addStudent(name, sex, calendar.getTime());
    }

    public void addStudent(String name, Sex sex, Date birthDate) {
        this.students.add(new Student(name, sex, birthDate));
    }

    public Student find(String name) {
        Student result = null;
        for (Student student : this.students) {
            if (student.getName().equals(name)) {
                result = student;
                break;
            }
        }
        return result;
    }

    public List<Student> compare(Sex sex, String direction, Sport sport, Student student) {
        List<Student> result = new ArrayList<Student>();
        Student refStudent = this.find(student.getName());
        Integer refResult = refStudent.getResult(sport);
        for (Student currentStudent : this.students) {
            if (student.getSex().equals(sex)) {
                Integer currentResult = currentStudent.getResult(sport);
                if (currentResult != null) {
                    if ("better".equals(direction)) {
                        if (refResult < currentResult) {
                            result.add(currentStudent);
                        }
                    } else {
                        if (refResult > currentResult) {
                            result.add(currentStudent);
                        }
                    }
                }
            }
        }
        return result;
    }

    public List<Student> getStudents() {
        return this.students;
    }
    private static StudentCatalog instance = null;

    private StudentCatalog() {
        this.students = new ArrayList<Student>();
        this.calendar = Calendar.getInstance();
        this.init();
    }

    private void init() {
        this.addStudent("Alpha", Sex.MAN, 1981, 10, 30);
        this.addStudent("Bravo", Sex.MAN, 1975, 2, 20);
        this.addStudent("Charlie", Sex.WOMAN, 1990, 3, 8);
        this.addStudent("Delta", Sex.MAN, 1988, 9, 11);
        this.addStudent("Echo", Sex.WOMAN, 1956, 7, 9);
        this.addStudent("Foxtrot", Sex.MAN, 1999, 4, 4);
        this.addStudent("Golf", Sex.WOMAN, 2002, 3, 15);
        this.addStudent("Hotel", Sex.MAN, 1991, 4, 18);
        this.addStudent("India", Sex.WOMAN, 1990, 10, 20);

        this.find("Alpha").addResult(Sport.FLAT_RACE, 14);
        this.find("Alpha").addResult(Sport.LONG_JUMP, 4);
        this.find("Alpha").addResult(Sport.SMALL_BALL_THROWING, 70);

        this.find("Bravo").addResult(Sport.FLAT_RACE, 13);
        this.find("Bravo").addResult(Sport.LONG_JUMP, 3);

        this.find("Charlie").addResult(Sport.SMALL_BALL_THROWING, 60);
        this.find("Charlie").addResult(Sport.LONG_JUMP, 2);
        this.find("Charlie").addResult(Sport.FLAT_RACE, 10);
        
        this.find("Delta").addResult(Sport.SMALL_BALL_THROWING, 65);
        this.find("Delta").addResult(Sport.LONG_JUMP, 1);
        this.find("Delta").addResult(Sport.FLAT_RACE, 18);
        
        this.find("Echo").addResult(Sport.SMALL_BALL_THROWING, 75);
        this.find("Echo").addResult(Sport.LONG_JUMP, 6);
        
        this.find("Foxtrot").addResult(Sport.SMALL_BALL_THROWING, 80);
        this.find("Foxtrot").addResult(Sport.LONG_JUMP, 2);
        this.find("Foxtrot").addResult(Sport.FLAT_RACE, 20);
        
        this.find("Golf").addResult(Sport.SMALL_BALL_THROWING, 40);
        this.find("Golf").addResult(Sport.LONG_JUMP, 4);
        
        this.find("India").addResult(Sport.SMALL_BALL_THROWING, 35);
        this.find("India").addResult(Sport.LONG_JUMP, 3);
        this.find("India").addResult(Sport.FLAT_RACE, 15);
    }

    public static StudentCatalog getInstance() {
        if (StudentCatalog.instance == null) {
            synchronized (StudentCatalog.class) {
                if (StudentCatalog.instance == null) {
                    StudentCatalog.instance = new StudentCatalog();
                }
            }
        }
        return StudentCatalog.instance;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }
}
