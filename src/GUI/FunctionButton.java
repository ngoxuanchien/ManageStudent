package GUI;

import StudentManagement.Student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import static GUI.MainWindow.*;

public class FunctionButton extends JPanel implements ActionListener {
    private JButton addButton;
    private JButton deleteButton;
    private JButton updateButton;
    private JButton saveButton;
    private JButton exportButton;
    private JButton importButton;
    private JButton sortID;
    private JButton sortMark;
    private int intSortId = 1;
    private int intSortMark = 1;

    public FunctionButton() {
        addButton = new JButton("Add");
        updateButton = new JButton("Update");
        deleteButton = new JButton("Delete");
        saveButton = new JButton("Save");
        exportButton = new JButton("Export");
        importButton = new JButton("Import");
        sortID = new JButton("Sort ID");
        sortMark = new JButton("Sort Mark");

        addButton.addActionListener(this);
        saveButton.addActionListener(this);
        deleteButton.addActionListener(this);
        updateButton.addActionListener(this);
        exportButton.addActionListener(this);
        importButton.addActionListener(this);
        sortID.addActionListener(this);
        sortMark.addActionListener(this);

        this.setLayout(new FlowLayout());
        this.add(addButton);
        this.add(updateButton);
        this.add(deleteButton);
        this.add(saveButton);
//        this.add(sortID);
//        this.add(sortMark);
        this.add(exportButton);
        this.add(importButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            new StudentForm();
        }

        if (e.getSource() == saveButton) {

            JFileChooser fileChooser = new JFileChooser();

            fileChooser.setCurrentDirectory(new File("."));

            int response = fileChooser.showSaveDialog(null);

            if (response == JFileChooser.APPROVE_OPTION) {
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                students.saveFile(file.toString());
            }
        }

        if (e.getSource() == exportButton) {

            JFileChooser fileChooser = new JFileChooser();

            fileChooser.setCurrentDirectory(new File("."));

            int response = fileChooser.showSaveDialog(null);

            if (response == JFileChooser.APPROVE_OPTION) {
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                students.ExportStudents(file.toString());
            }

            System.out.print("Export");
        }

        if (e.getSource() == importButton) {

            JFileChooser fileChooser = new JFileChooser();

            fileChooser.setCurrentDirectory(new File("."));

            int response = fileChooser.showOpenDialog(null);

            if (response == JFileChooser.APPROVE_OPTION) {
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                students.ImportStudents(file.toString());
            }

            System.out.print("Import");
            table.updateTable();
        }

        if (e.getSource() == updateButton) {
            String id = table.getSelectedId();
            Student student = students.removeStudent(id);
            new StudentForm(student);
        }

        if (e.getSource() == deleteButton) {
            String id = table.getSelectedId();
            students.removeStudent(id);
            table.updateTable();
        }

        if (e.getSource() == sortID) {
            if (intSortId == 1) {
                students.SortIDAscending();
            } else {
                students.SortIDDescending();
            }

            intSortId *= -1;
            table.updateTable();
        }

        if (e.getSource() == sortMark) {
            if (intSortMark == 1) {
                students.SortMarkAscending();
            } else {
                students.SortMarkDescending();
            }

            intSortMark *= -1;
            table.updateTable();
        }
    }

}
