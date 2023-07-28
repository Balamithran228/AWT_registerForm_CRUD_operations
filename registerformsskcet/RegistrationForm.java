package org.registerformsskcet;

import java.awt.*;
import javax.swing.JOptionPane;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;



class RegistrationForm extends Frame
{
    private TextField nameTextField, ageTextField, emailTextField, phoneNumberTextField, dobTextField;
    private TextField passwordTextField, confirmPasswordTextField;
    private Button registerButton,viewStudentDetailsButton;
    private TextArea displayArea;
    private ArrayList<StudentRegister> studentList;

    RegistrationForm() {
        System.out.println("Hello wwwww! 1");

        studentList = new ArrayList<>();


        setTitle("Registration Form");
        setSize(500, 500);
        setLayout(null);

        Label nameLabel = new Label("Name:*");
        nameLabel.setBounds(50, 50, 100, 30);
        nameTextField = new TextField(20);
        nameTextField.setBounds(160, 50, 200, 30);

        Label ageLabel = new Label("Age:*");
        ageLabel.setBounds(50, 100, 100, 30);
        ageTextField = new TextField(20);
        ageTextField.setBounds(160, 100, 200, 30);

        Label emailLabel = new Label("Email:*");
        emailLabel.setBounds(50, 150, 100, 30);
        emailTextField = new TextField(20);
        emailTextField.setBounds(160, 150, 200, 30);

        Label phoneNumberLabel = new Label("Phone Number:*");
        phoneNumberLabel.setBounds(50, 200, 100, 30);
        phoneNumberTextField = new TextField(20);
        phoneNumberTextField.setBounds(160, 200, 200, 30);

        Label dobLabel = new Label("Date of Birth:*");
        dobLabel.setBounds(50, 250, 100, 30);
        dobTextField = new TextField(20);
        dobTextField.setBounds(160, 250, 200, 30);

        Label passwordLabel = new Label("Password:*");
        passwordLabel.setBounds(50, 300, 100, 30);
        passwordTextField = new TextField(20);
        passwordTextField.setBounds(160, 300, 200, 30);
        passwordTextField.setEchoChar('*');

        Label confirmPasswordLabel = new Label("Confirm Password:*");
        confirmPasswordLabel.setBounds(50, 350, 120, 30);
        confirmPasswordTextField = new TextField(20);
        confirmPasswordTextField.setBounds(170, 350, 190, 30);
        confirmPasswordTextField.setEchoChar('*');
        System.out.println("Hello wwwww! 2");

        registerButton = new Button("Register");
        registerButton.setBounds(160, 400, 80, 30);

        viewStudentDetailsButton = new Button("View");
        viewStudentDetailsButton.setBounds(160, 450, 80, 30);
        viewStudentDetailsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                viewStudents(); // Call the viewStudents() function when the "View" button is clicked
            }
        });

        add(registerButton);
        add(viewStudentDetailsButton);

        add(nameLabel);
        add(nameTextField);

        add(ageLabel);
        add(ageTextField);

        add(emailLabel);
        add(emailTextField);

        add(phoneNumberLabel);
        add(phoneNumberTextField);

        add(dobLabel);
        add(dobTextField);
        add(passwordLabel);
        add(passwordTextField);

        add(confirmPasswordLabel);
        add(confirmPasswordTextField);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                ArrayList<String> validationMessages = validation();
                System.out.println(validationMessages.get(1));
                System.out.println(validationMessages.get(1).equals("Success"));
                System.out.println(validationMessages.get(1));
                        System.out.println(validationMessages.get(1));
                if (validationMessages.get(1).equals("Success")) {
                    System.out.println("hello");
                    JOptionPane.showMessageDialog(null, validationMessages.get(0), validationMessages.get(1), JOptionPane.INFORMATION_MESSAGE);

                } else {
                    System.out.println("error");
                    JOptionPane.showMessageDialog(null, validationMessages.get(0), "Invalid Input", JOptionPane.ERROR_MESSAGE);

                }

            }
        });
        setVisible(true);
    }
        public ArrayList<String> validation(){
                ArrayList<String> message = new ArrayList<String>();

                String name = nameTextField.getText();
                String ageStr = ageTextField.getText();
                String email = emailTextField.getText();
                String phoneNumber = phoneNumberTextField.getText();
                String dob = dobTextField.getText();
                String password = passwordTextField.getText();
                String confirmPassword = confirmPasswordTextField.getText();

            // Validation regex patterns
            String nameRegex = "[a-zA-Z\\s]+";
            String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
            String phoneNumberRegex = "^[0-9\\s-]*$";
            String dobRegex = "\\d{4}-\\d{2}-\\d{2}";
            String passwordRegex = "^(?=.*\\d)(?=.*[A-Z]).{6,}$";

            if (name.isEmpty() || !name.matches(nameRegex)) {
                message.add("Invalid name. Name should contain only letters and spaces.");
                message.add("Error");
                return message;

            }



            int age = -1;
            try {
                age = Integer.parseInt(ageStr);
                if (age <= 0) {
                            message.add("Invalid age. Age should be a positive number.");
                            message.add("Error");
                    return message;
                }
            } catch (NumberFormatException e) {
                            message.add("Invalid age. Age should be a positive number.");
                    return message;
            }

            if (email.isEmpty() || !email.matches(emailRegex)) {
                message.add("Invalid email address.");
                message.add("Error");
                return message;
            }

            if (phoneNumber.isEmpty() || !phoneNumber.matches(phoneNumberRegex)) {
                message.add("Invalid phone number. Phone number should contain only digits and optional spaces or dashes.");
                message.add("Error");
                return message;
            }

            if (dob.isEmpty() || !dob.matches(dobRegex)) {
                message.add("Invalid date of birth. Date of birth should be in the format YYYY-MM-DD.");
                message.add("Error");

                return message;
            }

            if (password.isEmpty() || !password.equals(confirmPassword) || !password.matches(passwordRegex)) {
                message.add("Invalid password. Password must be at least 6 characters long and contain at least one digit and one uppercase letter.");
                message.add("Error");

                return message;
            }


                     age =  Integer.parseInt(ageStr);
                    StudentRegister student = new StudentRegister(name, age, email, phoneNumber, dob, password);
                    studentList.add(student);
                  clearFields();
                    message.add("Registration successful!");
                    message.add("Success");


            return message;
        }



//    private void viewStudents() {
//        if (studentList.isEmpty()) {
//            JOptionPane.showMessageDialog(this, "No students registered yet.", "No Students", JOptionPane.INFORMATION_MESSAGE);
//            return;
//        }
//
//        // Create a new JFrame to display student details
//        JFrame studentDetailsFrame = new JFrame("Student Details");
//        studentDetailsFrame.setSize(400, 300);
//
//        // Create a JTextArea to display student details
//        JTextArea studentDetailsTextArea = new JTextArea();
//        studentDetailsTextArea.setEditable(false);
//
//        // Append student details to the JTextArea
//        for (StudentRegister student : studentList) {
//            studentDetailsTextArea.append("Student ID: " + student.getStudentID() + "\n");
//            studentDetailsTextArea.append("Name: " + student.getName() + "\n");
//            studentDetailsTextArea.append("Age: " + student.getAge() + "\n");
//            studentDetailsTextArea.append("Email: " + student.getEmail() + "\n");
//            studentDetailsTextArea.append("Phone Number: " + student.getPhoneNumber() + "\n");
//            studentDetailsTextArea.append("Date of Birth: " + student.getDob() + "\n");
//            studentDetailsTextArea.append("-------------------------------\n");
//        }
//
//
//        // Add the JTable to a JScrollPane
//        JScrollPane scrollPane = new JScrollPane(studentTable);
//        studentDetailsFrame.add(scrollPane);
//
//        // Set the JFrame visible
//        studentDetailsFrame.setVisible(true);
//    }

private JTable table;
    private void viewStudents() {
        if (studentList.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No students registered yet.", "No Students", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        // Create a new JFrame to display student details
        JFrame studentDetailsFrame = new JFrame("Student Details");
        studentDetailsFrame.setSize(600, 400);

        // Create a JTable to display student details
        String[] columnNames = {"Student ID", "Name", "Age", "Email", "Phone Number", "Date of Birth"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        JTable studentTable = new JTable(tableModel);

        // Populate the table with student details
        for (StudentRegister student : studentList) {
            Object[] rowData = {
                    student.getStudentID(),
                    student.getName(),
                    student.getAge(),
                    student.getEmail(),
                    student.getPhoneNumber(),
                    student.getDob()

            };
            tableModel.addRow(rowData);
        }

        // Add the JTable to a JScrollPane
        JScrollPane scrollPane = new JScrollPane(studentTable);
        studentDetailsFrame.add(scrollPane);

        // Highlight the selected row in the table
        // Highlight the selected row in the table
        studentTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        studentTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int selectedRow = studentTable.getSelectedRow();
                for (int i = 0; i < studentTable.getRowCount(); i++) {
                    studentTable.setSelectionBackground(i == selectedRow ? Color.YELLOW : Color.WHITE);
                    studentTable.setSelectionForeground(i == selectedRow ? Color.BLACK : Color.BLACK);
                }
            }
        });


        // Create a Close button
        JButton closeButton = new JButton("Close");
        closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Close the studentDetailsFrame when the "Close" button is clicked
                studentDetailsFrame.dispose();
            }
        });

        // Create an Update button
        JButton updateButton = new JButton("Update");


        updateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedRow = studentTable.getSelectedRow();
                if (selectedRow == -1) {
                    JOptionPane.showMessageDialog(studentDetailsFrame, "Please select a row to update.", "No Row Selected", JOptionPane.WARNING_MESSAGE);
                } else {
                    // Get data from the selected row
                    int studentID = (int) studentTable.getValueAt(selectedRow, 0);
                    String name = (String) studentTable.getValueAt(selectedRow, 1);
                    int age = (int) studentTable.getValueAt(selectedRow, 2);
                    String email = (String) studentTable.getValueAt(selectedRow, 3);
                    String phoneNumber = (String) studentTable.getValueAt(selectedRow, 4);
                    String dob = (String) studentTable.getValueAt(selectedRow, 5);

                    // Update the data in the StudentRegister object
                    for (StudentRegister student : studentList) {
                        if (student.getStudentID() == studentID) {
                           //  Update the student details using the setter methods
                            student.setName(name);
                            student.setAge((int)age);
                            student.setEmail(email);
                            student.setPhoneNumber(phoneNumber);
                            student.setDob(dob);
                            break;
                        }
                    }

                    // Show a message or perform any other actions as needed
                    JOptionPane.showMessageDialog(studentDetailsFrame, "Row updated successfully.", "Update Success", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        // Create a Delete button
        JButton deleteButton = new JButton("Delete");
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedRow = studentTable.getSelectedRow();
                if (selectedRow == -1) {
                    JOptionPane.showMessageDialog(studentDetailsFrame, "Please select a row to delete.", "No Row Selected", JOptionPane.WARNING_MESSAGE);
                } else {
                    // Get data from the selected row
                    int studentID = (int) studentTable.getValueAt(selectedRow, 0);

                    // Delete the student from the list
                    boolean found = false;
                    for (StudentRegister student : studentList) {
                        if (student.deleteStudent(studentID)) {
                            studentList.remove(student);
                            found = true;
                            break; // Assuming studentID is unique, we delete only one student and break the loop
                        }
                    }

                    if (found) {
                        // Remove the selected row from the table
                        tableModel.removeRow(selectedRow);

                        // Show a message or perform any other actions as needed
                        JOptionPane.showMessageDialog(studentDetailsFrame, "Row deleted successfully.", "Delete Success", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(studentDetailsFrame, "Student not found.", "Delete Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
        // Create Search button
        JButton searchButton = new JButton("Search");
        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String searchIDStr = JOptionPane.showInputDialog(studentDetailsFrame, "Enter Student ID to Search:", "Search Student", JOptionPane.QUESTION_MESSAGE);
                if (searchIDStr == null || searchIDStr.isEmpty()) {
                    // User canceled or provided an empty search ID
                    return;
                }

                try {
                    int searchID = Integer.parseInt(searchIDStr);
                    StudentRegister student = findStudentByID(searchID);
                    if (student != null) {
                        // Clear the table and add the found student details
                        tableModel.setRowCount(0);
                        Object[] rowData = {
                                student.getStudentID(),
                                student.getName(),
                                student.getAge(),
                                student.getEmail(),
                                student.getPhoneNumber(),
                                student.getDob()
                        };
                        tableModel.addRow(rowData);
                    } else {
                        JOptionPane.showMessageDialog(studentDetailsFrame, "Student not found.", "Search Result", JOptionPane.INFORMATION_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(studentDetailsFrame, "Invalid Student ID. Please enter a valid number.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Create a JPanel to hold the buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(closeButton);
        buttonPanel.add(searchButton);
        studentDetailsFrame.add(buttonPanel, BorderLayout.SOUTH);

        // Set the JFrame visible
        studentDetailsFrame.setVisible(true);
    }
    private StudentRegister findStudentByID(int studentID) {
        for (StudentRegister student : studentList) {
            if (student.getStudentID() == studentID) {
                return student;
            }
        }
        return null;
    }
    private void clearFields() {
        nameTextField.setText("");
        ageTextField.setText("");
        emailTextField.setText("");
        phoneNumberTextField.setText("");
        dobTextField.setText("");
        passwordTextField.setText("");
        confirmPasswordTextField.setText("");
    }

}

