package GUI;

import StudentManagement.Student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import static GUI.MainWindow.students;
import static GUI.MainWindow.table;

public class StudentForm extends JFrame implements ActionListener {
    private JButton _cancelButton;
    private JButton _saveButton;
    private JLabel _myLabel;
    private Student student = null;

    private JLabel imageLabel;
    private JButton imageButton;
    JTextField idTextField;
    JTextField fullNameTextField;
    JTextField markTextField;
    JTextField addressTextField;
    JTextField noteTextField;


    public StudentForm() {
        this.setLayout(new BorderLayout());
        this.setSize(500, 500);
        this.setTitle("Student Form");

        _myLabel = new JLabel("Student Form");
        _myLabel.setFont(new Font("MV Boli", Font.PLAIN, 30));
        _myLabel.setHorizontalAlignment(JLabel.CENTER);
        _myLabel.setVerticalAlignment(JLabel.TOP);

        idTextField = new JTextField();
        fullNameTextField = new JTextField();
        markTextField = new JTextField();
        imageLabel = new JLabel();
        imageLabel.setBounds(50, 0, 150, 150);
        imageButton = new JButton("Browse");
        imageButton.setBounds(250, 60, 100, 30);
        imageButton.addActionListener(this);
        addressTextField = new JTextField();
        noteTextField = new JTextField();


        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.add(imageLabel);
        mainPanel.add(imageButton);

        JLabel idLabel = new JLabel("ID");
        idLabel.setBounds(50, 160, 130, 30);
        mainPanel.add(idLabel);
        idTextField.setBounds(250, 160, 200, 30);
        mainPanel.add(idTextField);

        JLabel fullNameLabel = new JLabel("Full name");
        fullNameLabel.setBounds(50, 200, 130, 30);
        mainPanel.add(fullNameLabel);
        fullNameTextField.setBounds(250, 200, 200, 30);
        mainPanel.add(fullNameTextField);

        JLabel markLabel = new JLabel("Mark");
        markLabel.setBounds(50, 240, 130, 30);
        mainPanel.add(markLabel);
        markTextField.setBounds(250, 240, 200, 30);
        mainPanel.add(markTextField);

        JLabel addressLabel = new JLabel("Address");
        addressLabel.setBounds(50, 280, 130, 30);
        mainPanel.add(addressLabel);
        addressTextField.setBounds(250, 280, 200, 30);
        mainPanel.add(addressTextField);

        JLabel noteLabel = new JLabel("Note");
        noteLabel.setBounds(50, 320, 130, 30);
        mainPanel.add(noteLabel);
        noteTextField.setBounds(250, 320, 200, 30);
        mainPanel.add(noteTextField);

        _cancelButton = new JButton("Cancel");
        _saveButton = new JButton("Save");
        JPanel myPanel = new JPanel();
        myPanel.setLayout(new FlowLayout());
        myPanel.add(_saveButton);
        myPanel.add(_cancelButton);
        _saveButton.addActionListener(this);
        _cancelButton.addActionListener(this);

        this.add(_myLabel, BorderLayout.PAGE_START);
        this.add(myPanel, BorderLayout.PAGE_END);
        this.add(mainPanel, BorderLayout.CENTER);
        this.add(new Panel(), BorderLayout.LINE_START);
        this.add(new Panel(), BorderLayout.LINE_END);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

    }

    public StudentForm (Student data) {
        student = data;
        this.setLayout(new BorderLayout());
        this.setSize(500, 500);
        this.setTitle("Student Form");

        _myLabel = new JLabel("Student Form");
        _myLabel.setFont(new Font("MV Boli", Font.PLAIN, 30));
        _myLabel.setHorizontalAlignment(JLabel.CENTER);
        _myLabel.setVerticalAlignment(JLabel.TOP);

        idTextField = new JTextField(student.getID());
        fullNameTextField = new JTextField(student.getFullName());
        markTextField = new JTextField(Float.toString(student.getMark()));
        imageLabel = new JLabel();
        imageLabel.setBounds(50, 0, 150, 150);
        ImageIcon icon = new ImageIcon(student.getImage());
        imageLabel.setIcon(icon);

        if (icon != null) {
            imageLabel.setText(null);
        } else {
            imageLabel.setText("Image not found");
        }

        imageButton = new JButton("Browse");
        imageButton.setBounds(250, 60, 100, 30);
        imageButton.addActionListener(this);
        addressTextField = new JTextField(student.getAddress());
        noteTextField = new JTextField(student.getNote());


        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.add(imageLabel);
        mainPanel.add(imageButton);

        JLabel idLabel = new JLabel("ID");
        idLabel.setBounds(50, 160, 130, 30);
        mainPanel.add(idLabel);
        idTextField.setBounds(250, 160, 200, 30);
        mainPanel.add(idTextField);

        JLabel fullNameLabel = new JLabel("Full name");
        fullNameLabel.setBounds(50, 200, 130, 30);
        mainPanel.add(fullNameLabel);
        fullNameTextField.setBounds(250, 200, 200, 30);
        mainPanel.add(fullNameTextField);

        JLabel markLabel = new JLabel("Mark");
        markLabel.setBounds(50, 240, 130, 30);
        mainPanel.add(markLabel);
        markTextField.setBounds(250, 240, 200, 30);
        mainPanel.add(markTextField);

        JLabel addressLabel = new JLabel("Address");
        addressLabel.setBounds(50, 280, 130, 30);
        mainPanel.add(addressLabel);
        addressTextField.setBounds(250, 280, 200, 30);
        mainPanel.add(addressTextField);

        JLabel noteLabel = new JLabel("Note");
        noteLabel.setBounds(50, 320, 130, 30);
        mainPanel.add(noteLabel);
        noteTextField.setBounds(250, 320, 200, 30);
        mainPanel.add(noteTextField);

        _cancelButton = new JButton("Cancel");
        _saveButton = new JButton("Save");
        JPanel myPanel = new JPanel();
        myPanel.setLayout(new FlowLayout());
        myPanel.add(_saveButton);
        myPanel.add(_cancelButton);
        _saveButton.addActionListener(this);
        _cancelButton.addActionListener(this);

        this.add(_myLabel, BorderLayout.PAGE_START);
        this.add(myPanel, BorderLayout.PAGE_END);
        this.add(mainPanel, BorderLayout.CENTER);
        this.add(new Panel(), BorderLayout.LINE_START);
        this.add(new Panel(), BorderLayout.LINE_END);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public Student getStudent() {
        return student;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == imageButton) {
            JFileChooser fileChooser = new JFileChooser();

            fileChooser.setCurrentDirectory(new File("."));

            int response = fileChooser.showOpenDialog(null);

            if (response == JFileChooser.APPROVE_OPTION) {
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                ImageIcon icon = new ImageIcon(file.toString());
                imageLabel.setIcon(icon);
                if (icon != null) {
                    imageLabel.setText(null);
                } else {
                    imageLabel.setText("Image not found");
                }
            }
        }

        if (e.getSource() == _cancelButton) {
            if (student != null) {
                students.addStudent(student);
                table.updateTable();
            }

            this.setVisible(false);
            this.dispose();
        }

        if (e.getSource() == _saveButton) {
            if (student != null) {
                student = new Student(
                        idTextField.getText(),
                        fullNameTextField.getText(),
                        Float.parseFloat(markTextField.getText()),
                        imageLabel.getIcon().toString(),
                        addressTextField.getText(),
                        noteTextField.getText()
                );

                students.addStudent(student);
                table.updateTable();

                this.setVisible(false);
                this.dispose();
            }

        }
    }
}
