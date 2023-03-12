package StudentManagement;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;

public class Management {
    private ArrayList<Student> _students = null;

    public Management() {
        _students = new ArrayList<Student>();
    }

    public void addStudent(Student student) {
        _students.add(student);
        Collections.sort(_students, Student.StudentIDComparator);
//        Collections.sort(_students, Student.StudentIDGreaterComparator.reversed());
    }

    public void print() {
        for (Student student : _students) {
            System.out.println(student);
        }
    }

    public void saveFile(String fileName) {
        try {
            FileOutputStream file = new FileOutputStream(fileName);
            ObjectOutputStream objectOut = new ObjectOutputStream(file);

            objectOut.writeObject(_students);
            objectOut.flush();
            objectOut.close();
            file.close();
            System.out.println("The Object  was succesfully written to a file");

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public Student getStudent(int index) {
        return _students.get(index);
    }

    public int updateStudent(int index, Student student) {
        try {
            _students.get(index).updateStudent(student);
            return 1;
        } catch (Exception e) {
            System.out.println(e);
            return 0;
        }
    }

    public Student removeStudent(String id) {
        for (int i = 0; i < _students.size(); i++) {
            if (id.equals(_students.get(i).getID())) {
                Student student = _students.get(i);
                _students.remove(i);
                return student;
            }
        }
        return null;
    }

    public int deleteStudent(int index) {
        try {
            _students.remove(index);
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

            _students = (ArrayList<Student>) objecIn.readObject();

            objecIn.close();
            file.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void SortIDAscending() {
        Collections.sort(_students, Student.StudentIDComparator);
    }

    public void SortIDDescending() {
        Collections.sort(_students, Student.StudentIDComparator);
        Collections.sort(_students, Student.StudentIDComparator.reversed());
    }

    public void SortMarkAscending() {
        Collections.sort(_students, Student.StudentMarkComparator);
    }

    public void SortMarkDescending() {
        Collections.sort(_students, Student.StudentMarkComparator);
        Collections.sort(_students, Student.StudentMarkComparator.reversed());
    }

    private static Student createStudent(String[] metadata) {
        String _id = metadata[0];
        String _fullName = metadata[1];
        float _mark = Float.parseFloat(metadata[2]);
        String _image = metadata[3];
        String _address = metadata[4];
        String _note = metadata[5];

        return new Student(_id, _fullName, _mark, _image, _address, _note);
    }

    public int ImportStudents(String fileName) {
        Path pathToFile = Paths.get(fileName);

        try (BufferedReader br = Files.newBufferedReader(pathToFile)) {

            String line = br.readLine();

            while (line != null) {
                String[] attributes = line.split(",");

                Student student = createStudent(attributes);

                this.addStudent(student);

                line = br.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }

        return 1;
    }

    public int ExportStudents(String fileName) {
        try {
            File csvFile = new File(fileName);
            PrintWriter out = new PrintWriter(csvFile);

            for (Student student : _students) {
                out.printf("%s,%s,%f,%s,%s,%s\n", student.getID(), student.getFullName(), student.getMark(), student.getImage(), student.getAddress(), student.getNote());
            }

            out.close();
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }

        return 1;
    }

    public ArrayList<Student> getStudents() {
        return _students;
    }
}
