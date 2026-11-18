
package com.mycompany.matressgui;

import java.awt.GridLayout;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.*;

// Main class: the window (JFrame) for the mattress sales application
public class MatressGUI extends JFrame {


    // Form components
    private final JTextField txtCustomer = new JTextField(20);
    private final JComboBox<String> cboProduct = new JComboBox<>(new String[]{
        "Cozy Nights Monarch", "Restonic Barbados", "Sealy Phuket"});
    private final JTextField txtPrice = new JTextField(20);
    private final JButton btnProcess = new JButton("PROCESS");
    private final JButton btnClear = new JButton("CLEAR");

    public MatressGUI() {
        super("Product App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(450, 300);
        setLocationRelativeTo(null);

        buildMenu();

        // Grid layout: labels on the left, inputs on the right
        JPanel panel = new JPanel(new GridLayout(5, 2, 10, 15));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panel.add(new JLabel("Customer Name:"));
        panel.add(txtCustomer);
        panel.add(new JLabel("Select Product:"));
        panel.add(cboProduct);
        panel.add(new JLabel("Enter Price:"));
        panel.add(txtPrice);
        panel.add(new JLabel(""));
        panel.add(btnProcess);
        panel.add(new JLabel(""));
        panel.add(btnClear);
        add(panel);

        // Button actions
        btnProcess.addActionListener(e -> processSale());
        btnClear.addActionListener(e -> clearForm());
    }

    private void buildMenu() {
        JMenuBar bar = new JMenuBar();

        JMenu file = new JMenu("File");
        JMenuItem exit = new JMenuItem("Exit");
        exit.addActionListener(e -> System.exit(0));
        file.add(exit);

        // Menu items reuse the same logic as the buttons
        JMenu tools = new JMenu("Tools");
        JMenuItem process = new JMenuItem("Process");
        JMenuItem clear = new JMenuItem("Clear");
        process.addActionListener(e -> processSale());
        clear.addActionListener(e -> clearForm());
        tools.add(process);
        tools.add(clear);

        bar.add(file);
        bar.add(tools);
        setJMenuBar(bar);
    }

    private void processSale() {
        String name = txtCustomer.getText().trim();
        String product = (String) cboProduct.getSelectedItem();

        // Validate the customer name
        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter the customer name.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Validate the price (must be a number greater than 0)
        double price;
        try {
            price = Double.parseDouble(txtPrice.getText().trim());
            if (price <= 0) throw new NumberFormatException();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid price greater than 0.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Calculate VAT (15%), commission (5%) and total
        IProductCalculations calc = new ProductCalculations(price);
        double vat = calc.GetVat();
        double commission = calc.GetCommission();
        double total = calc.GetTotal();

        String details = "Customer Name: " + name
                + "\nProduct: " + product
                + "\nVAT: R " + vat
                + "\nCOMMISSION: R " + commission
                + "\nTOTAL: R " + total;

        JOptionPane.showMessageDialog(this, details, "Message",
                JOptionPane.INFORMATION_MESSAGE);

        saveToFile(details);
    }

    // Writes the sale details to data.txt
    private void saveToFile(String details) {
        try (PrintWriter out = new PrintWriter(new FileWriter("data.txt"))) {
            out.println("DATA LOG");
            out.println("**********************************");
            out.println(details);
            out.println("**********************************");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Could not save data.txt: " + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Resets the form to its starting state
    private void clearForm() {
        txtCustomer.setText("");
        txtPrice.setText("");
        cboProduct.setSelectedIndex(0);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MatressGUI().setVisible(true));
    }
}