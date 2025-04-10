package ProductData;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InventoryUI {
    private JFrame frame;
    private JTextField txtProductId, txtName, txtDescription, txtPrice, txtQuantity;
    private JButton btnAdd, btnClear;

    public InventoryUI() {
        frame = new JFrame("Inventory Management");
        frame.setSize(400, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(7, 2));

        // UI Components
        frame.add(new JLabel("Product ID:"));
        txtProductId = new JTextField();
        frame.add(txtProductId);

        frame.add(new JLabel("Name:"));
        txtName = new JTextField();
        frame.add(txtName);

        frame.add(new JLabel("Description:"));
        txtDescription = new JTextField();
        frame.add(txtDescription);

        frame.add(new JLabel("Product Price:"));
        txtPrice = new JTextField();
        frame.add(txtPrice);

        frame.add(new JLabel("Quantity:"));
        txtQuantity = new JTextField();
        frame.add(txtQuantity);

        // Buttons
        btnAdd = new JButton("Add Product");
        btnClear = new JButton("Clear");

        frame.add(btnAdd);
        frame.add(btnClear);

        // Button Actions
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addProduct();
            }
        });

        btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearFields();
            }
        });

        frame.setVisible(true);
    }

    private void addProduct() {
        try {
            int productId = Integer.parseInt(txtProductId.getText());
            String name = txtName.getText();
            String description = txtDescription.getText();
            double price = Double.parseDouble(txtPrice.getText());
            double quantity = Double.parseDouble(txtQuantity.getText());

            DatabaseConnection.insertProduct(productId, name, description, price, quantity);
            JOptionPane.showMessageDialog(frame, "Product Added Successfully!");

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Invalid Input! Ensure numeric fields are numbers.");
        }
    }

    private void clearFields() {
        txtProductId.setText("");
        txtName.setText("");
        txtDescription.setText("");
        txtPrice.setText("");
        txtQuantity.setText("");
    }
}