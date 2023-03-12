package StudentManagement;


import java.io.Serializable;
import java.util.Comparator;
import java.util.Scanner;

public class Student implements Serializable {

    private static final long serialVersionUID = -6500665823330706018L;

    private String ID;
    private String FullName;
    private float Mark;
    private String Image;
    private String Address;
    private String Note;

    public Student() {
        ID = "";
        FullName = "";
        Mark = 0;
        Image = "";
        Address = "";
        Note = "";
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.print("Student ID: ");
//        ID = scanner.next();
//        System.out.print("Student name: ");
//        FullName = scanner.nextLine();
//        FullName = scanner.nextLine();
//        System.out.print("Student Mark: ");
//        Mark = scanner.nextFloat();
//        System.out.print("Student Image: ");
//        Image = scanner.nextLine();
//        Image = scanner.nextLine();
//        System.out.print("Student Address: ");
//        Address = scanner.nextLine();
//        Address = scanner.nextLine();
//        System.out.print("Sudent Note: ");
//        Note = scanner.nextLine();
//        Note = scanner.nextLine();
//
//        scanner.close();
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

    private static int stringCompare(String str1, String str2) {
        int l1 = str1.length();
        int l2 = str2.length();
        int lmax = Math.max(l1, l2);

        StringBuilder sb1 = new StringBuilder(str1);
        StringBuilder sb2 = new StringBuilder(str2);

        for (int i = l1; i < l2; i++) {
            sb1.insert(0, "0");
        }

        for (int i = l2; i < l1; i++) {
            sb2.insert(0, "0");
        }

        for (int i = 0; i < lmax; i++) {
            int str1_ch = (int) sb1.charAt(i);
            int str2_ch = (int) sb2.charAt(i);

            if (str1_ch != str2_ch) {
                return str1_ch - str2_ch;
            }
        }

        return l1 - l2;
    }


    @Override
    public String toString() {
        String result = "";
        result = ID + " " + FullName + " " + Mark + " " + Address + " " + Image + " " + Address + " " + Note;
        return result;
    }

    public static Comparator<Student> StudentIDComparator = new Comparator<Student>() {
        @Override
        public int compare(Student o1, Student o2) {
            String compareID1 = ((Student) o1).getID();
            String compareID2 = ((Student) o2).getID();


            return stringCompare(compareID1, compareID2);
        }

        @Override
        public Comparator<Student> reversed() {
            return Comparator.super.reversed();
        }
    };


    public static Comparator<Student> StudentMarkComparator = new Comparator<Student>() {
        @Override
        public int compare(Student o1, Student o2) {
            double compareMark1 = ((Student) o1).getMark();
            double compareMark2 = ((Student) o2).getMark();

            if (compareMark1 == compareMark2) {
                return 0;
            } else if (compareMark1 > compareMark2) {
                return 1;
            } else {
                return -1;
            }
        }

        @Override
        public Comparator<Student> reversed() {
            return Comparator.super.reversed();
        }
    };

}