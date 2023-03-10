import StudentManagement.*;

public class Main {
    public static void main(String[] args) {
//        Student student = new Student();
        Management management = new Management();

//        management.addStudent(student);
//        management.saveFile("student.dat");
        management.readFile("student.dat");
        management.print();

    }
}