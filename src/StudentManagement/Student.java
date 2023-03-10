package StudentManagement;


import java.io.Serializable;
import java.util.Scanner;

public class Student implements Serializable {

//    private static final long serialVersionUID = -6500665823330706018L;

    private String ID;
    private String FullName;
    private float Mark;
    private String Image;
    private String Address;
    private String Note;

    public Student() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Student ID: ");
        ID = scanner.next();
        System.out.print("Student name: ");
        FullName = scanner.nextLine();
        FullName = scanner.nextLine();
        System.out.print("Student Mark: ");
        Mark = scanner.nextFloat();
        System.out.print("Student Image: ");
        Image = scanner.next();
        System.out.print("Student Address: ");
        Address = scanner.next();
        System.out.print("Sudent Note: ");
        Note = scanner.next();

        scanner.close();
    }

    public String getID() {
        return ID;
    }

    public void setID(String iD) {
        ID = iD;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    public float getMark() {
        return Mark;
    }

    public void setMark(float mark) {
        Mark = mark;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getNote() {
        return Note;
    }

    public void setNote(String note) {
        Note = note;
    }

    public Student(String ID, String FullName, float Mark, String Image, String Address, String Note) {
        this.ID = ID;
        this.FullName = FullName;
        this.Mark = Mark;
        this.Image = Image;
        this.Address = Address;
        this.Note = Note;
    }

    public void updateStudent(Student student) {
        this.ID = student.getID();
        this.FullName = student.getFullName();
        this.Address = student.getAddress();
        this.Image = student.getImage();
        this.Note = student.getNote();
        this.Mark = student.getMark();
    }

    @Override
    public String toString() {
        String result = "";
        result = ID + " " + FullName + " " + Mark + " " + Address + " " + Image + " " + Address + " " + Note;
        return result;
    }
}