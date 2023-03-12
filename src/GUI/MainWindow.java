package GUI;

import StudentManagement.Management;

import javax.management.DescriptorAccess;
import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class MainWindow extends JFrame {

    public static Management students = new Management();

    public static TableStudents table;
    public static File staticFile = null;
    FunctionButton button;

    public MainWindow() {
        JFileChooser fileChooser = new JFileChooser();

        fileChooser.setCurrentDirectory(new File("."));

        int response = fileChooser.showOpenDialog(null);

        if (response == JFileChooser.APPROVE_OPTION) {
            staticFile = new File(fileChooser.getSelectedFile().getAbsolutePath());
            students.readFile(staticFile.toString());
        }


        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1200, 750);
        this.setLayout(new BorderLayout());
        this.setTitle("Student Management");

        JLabel myLabel = new JLabel();
        myLabel.setText("Manage Student");
        myLabel.setFont(new Font("MV Boli", Font.PLAIN, 50));
        myLabel.setHorizontalAlignment(JLabel.CENTER);
        myLabel.setVerticalAlignment(JLabel.TOP);

        table = new TableStudents();

        JPanel myPanel1 = new JPanel();
        JPanel myPanel2 = new JPanel();

        button = new FunctionButton();


        this.add(myLabel, BorderLayout.PAGE_START);
        this.add(table, BorderLayout.CENTER);
        this.add(myPanel1, BorderLayout.LINE_START);
        this.add(myPanel2, BorderLayout.LINE_END);
        this.add(button, BorderLayout.PAGE_END);
        this.setResizable(false);
//        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
