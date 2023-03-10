package StudentManagement;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Management {
    private ArrayList<Student> students = null;

    public Management() {
        students = new ArrayList<Student>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void print() {
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public void saveFile(String fileName) {
        try {
            FileOutputStream file = new FileOutputStream(fileName);
            ObjectOutputStream objectOut = new ObjectOutputStream(file);

            objectOut.writeObject(students);
            objectOut.flush();
            objectOut.close();
            file.close();
            System.out.println("The Object  was succesfully written to a file");

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public int updateStudent(int index, Student student) {
        try {
            students.get(index).updateStudent(student);
            return 1;
        } catch (Exception e) {
            System.out.println(e);
            return 0;
        }
    }

    public int deleteStudent(int index) {
        try {
            students.remove(index);
            return 1;
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Index out of range");
            return 0;
        } catch (Exception e) {
            System.out.println(e);
            return 0;
        }
    }

    @SuppressWarnings("unchecked")
    public void readFile(String fileName) {
        try {
            FileInputStream file = new FileInputStream(fileName);
            ObjectInputStream objecIn = new ObjectInputStream(file);

            students = (ArrayList<Student>) objecIn.readObject();

            objecIn.close();
            file.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
