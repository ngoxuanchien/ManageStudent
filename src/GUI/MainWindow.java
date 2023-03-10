package GUI;

import javax.swing.*;

public class MainWindow {

    public static void createAndShowGUI() {
        JFrame frame = new JFrame("ManageStudent");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.pack();
        frame.setVisible(true);
    }

}
