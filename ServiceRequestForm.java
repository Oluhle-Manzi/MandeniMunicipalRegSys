package com.mycompany.mandenimunicipalregistrationsys;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ServiceRequestForm extends JFrame {

    private JTextField nameField;
    private JComboBox<String> serviceCategoryBox;
    private JTextArea additionalInfoArea;
    private JButton submitButton;
    private JButton clearButton;
    private JLabel resultLabel;

    public ServiceRequestForm() {
        setTitle("Municipality Service Request Form");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

  
        nameField = new JTextField(20);
        
        String[] serviceCategories = {"Water", "Electricity", "Sanitation", "Road Maintenance", "Other"};
        serviceCategoryBox = new JComboBox<>(serviceCategories);
        
        additionalInfoArea = new JTextArea(5, 20);
        additionalInfoArea.setLineWrap(true);
        additionalInfoArea.setWrapStyleWord(true);
        
        submitButton = new JButton("Submit Request");
        clearButton = new JButton("Clear Form");
        resultLabel = new JLabel("");


        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.NORTHWEST;


        gbc.gridx = 0;
        gbc.gridy = 0;
        add(new JLabel("Enter Your Name:"), gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 0;
        add(nameField, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(new JLabel("Service Category:"), gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 1;
        add(serviceCategoryBox, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(new JLabel("Additional Information:"), gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 2;
        add(new JScrollPane(additionalInfoArea), gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 3;
        add(submitButton, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 3;
        add(clearButton, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        add(resultLabel, gbc);

       
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleSubmitAction();
            }
        });
        
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearForm();
            }
        });
    }

    private void handleSubmitAction() {
        String name = nameField.getText();
        String category = (String) serviceCategoryBox.getSelectedItem();
        String additionalInfo = additionalInfoArea.getText();

        
        if (name.isEmpty() || additionalInfo.isEmpty()) {
            resultLabel.setText("Error: All fields must be filled.");
            return;
        }
        

        int confirm = JOptionPane.showConfirmDialog(this, "Submit this service request?", 
                "Confirmation", JOptionPane.YES_NO_OPTION);
        
        if (confirm == JOptionPane.YES_OPTION) {
            resultLabel.setText("Service request submitted successfully!");
            clearForm(); 
        }
    }


    private void clearForm() {
        nameField.setText("");
        serviceCategoryBox.setSelectedIndex(0);
        additionalInfoArea.setText("");
        resultLabel.setText("");
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ServiceRequestForm().setVisible(true);
        });
    }
}
