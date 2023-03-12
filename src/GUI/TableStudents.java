package GUI;

import StudentManagement.Student;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static GUI.MainWindow.students;

public class TableStudents extends JScrollPane {

    private JTable table;
    private DefaultTableModel tableModel;

    public TableStudents() {
        this.updateTable();
    }

    public int getSelectedRow() {
        System.out.println(table.getValueAt(table.getSelectedRow(), 0));
        return table.getSelectedRow();
    }

    public String getSelectedId() {
        return (String) table.getValueAt(table.getSelectedRow(), 0);
    }

    public void updateTable() {

        String[] columnNames = {"ID", "Full Name", "Mark", "Address", "Image", "Note"};
        tableModel = new DefaultTableModel();
        for (int i = 0; i < 6; i++) {
            tableModel.addColumn(columnNames[i]);
        }

        for (Student student : students.getStudents()) {
            Object[] rowData = {
                    student.getID(),
                    student.getFullName(),
                    student.getMark(),
                    student.getAddress(),
                    student.getImage(),
                    student.getNote()
            };
            tableModel.addRow(rowData);
        }

        table = new JTable((tableModel));
        TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(table.getModel());
        table.setRowSorter(sorter);
        table.getColumnModel().getColumn(5).setCellRenderer(new DefaultTableCellRenderer());

        List<RowSorter.SortKey> sortKeys = new ArrayList<>(25);
        sortKeys.add(new RowSorter.SortKey(0, SortOrder.ASCENDING));
        sorter.setSortKeys(sortKeys);

        sorter.setComparator(2, new Comparator<Object>() {
            @Override
            public int compare(Object o1, Object o2) {
                float score1 = (float) o1;
                float score2 = (float) o2;
                return Float.compare(score1, score2);
            }
        });

        table.setAutoCreateRowSorter(true);

//        TableRowSorter<TableModel> sorter = new TableRowSorter<>(tableModel);
//        sorter.setComparator(0, Comparator.naturalOrder());
//
//        sorter.setSortable(1, false);
//        sorter.setSortable(3, false);
//        sorter.setSortable(4, false);
//        sorter.setSortable(5, false);
//        table.setRowSorter(sorter);

        table.setRowHeight(30);
        table.setCellEditor(null);
        this.setViewportView(table);
    }


}
