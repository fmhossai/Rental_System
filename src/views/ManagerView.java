package views;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.util.HashMap;
import models.Property;

public class ManagerView extends GUIview {
    JButton logoutButton;
    JButton changeStateButton;
    JButton submitButton;
    JButton accessDatabaseButton;
    JButton generateReportButton;
    JButton setFeesButton;
    TablePanel tPanel;
    feeForm form;

    public ManagerView(String frameName, int width, int height) {
        super(width, height);
        tPanel = new TablePanel(width, height, "save changes");
        initalizeFrame(frameName);
        form = new feeForm();
    }

    // creates and saves dashboard elements into memory
    public void intializeDashboard() {
        changeStateButton = new JButton("Change listing state");
        logoutButton = new JButton("Logout");
        generateReportButton = new JButton("Generate periodical report");
        accessDatabaseButton = new JButton("Access database");
        submitButton = new JButton("Submit");
        setFeesButton = new JButton("Set or change fees");
        panel = new JPanel(new FlowLayout());
        panel.add(changeStateButton);
        panel.add(generateReportButton);
        panel.add(accessDatabaseButton);
        panel.add(setFeesButton);
        panel.add(logoutButton);

    }

    public void displayDashboard() {
        frame.setContentPane(panel);
        frame.revalidate();

    }

    // the following methods until the end add event listeners to all the buttons
    public void addLogoutListener(ActionListener listener) {
        logoutButton.addActionListener(listener);

    }

    public void addChangeStateListener(ActionListener listener) {
        changeStateButton.addActionListener(listener);

    }

    public void addAccessDBListener(ActionListener listener) {
        accessDatabaseButton.addActionListener(listener);

    }

    public void addReportListener(ActionListener listener) {
        generateReportButton.addActionListener(listener);

    }

    public void addSubmitListener(ActionListener listener) {
        submitButton.addActionListener(listener);
    }

    public void addSetFeesListner(ActionListener listener) {
        setFeesButton.addActionListener(listener);
    }

    public void TableButtonListener(ActionListener listener) {
        tPanel.submitButton.addActionListener(listener);
    }

    public void FeesListener(ActionListener listener) {
        form.submit.addActionListener(listener);

    }

    public void displayForm(int periodValue, int feesValue) {
        backButton.setBounds(110, (int) (height * 0.20), (int) (width * 0.1), (int) (height * 0.025));
        form.add(backButton);
        form.displayFees(width, height, periodValue, feesValue);
        frame.setContentPane(form);
        frame.revalidate();
    }

    public void displayFormError(String error) {
        form.displayError(error);
    }

    public String[] getFormFields() {
        return form.getFields();
    }

    public HashMap<Integer, String> getSelectedProperties() {
        return tPanel.getSelectedProperties(7);
    }

    public void displayListingChanges(ArrayList<Property> properties) {
        backButton.setBounds((int) (width * 0.25), (int) (height * 0.55), (int) (width * 0.2),
                (int) (height * 0.030));
        tPanel.add(backButton);
        tPanel.displayPropertyTableChangeListing(properties);
        frame.setContentPane(tPanel);
        frame.revalidate();

    }

}