package com.mycompany.siap;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VenderPasaje extends JFrame {
    private JPanel panel1;
    private JTable tableAsientos;
    private DefaultTableModel tableModel;
    private Empresa empresa;

    public VenderPasaje(Empresa empresa) {
        this.empresa = empresa;

        // Initialize components
        initComponents();

        // Create the table model with 44 seats
        tableModel = new DefaultTableModel(11, 4); // 11 rows, 4 columns
        tableAsientos.setModel(tableModel);

        // Query the database to get the seat status
        cargarEstadoAsientos();

        // Renderer to change the color of sold seats
        tableAsientos.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                if ("Vendido".equals(value)) {
                    cell.setBackground(Color.RED);
                } else {
                    cell.setBackground(Color.WHITE);
                }
                return cell;
            }
        });
    }

    private void initComponents() {
        panel1 = new JPanel();
        tableAsientos = new JTable();
        // Add tableAsientos to panel1 or set layout as needed
        panel1.add(new JScrollPane(tableAsientos));
    }

    private void cargarEstadoAsientos() {
        try (Connection conn = empresa.getConexion();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM asientos");
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int asientoId = rs.getInt("id");
                boolean vendido = rs.getBoolean("vendido");

                int row = (asientoId - 1) / 4;
                int col = (asientoId - 1) % 4;
                tableModel.setValueAt(vendido ? "Vendido" : "Disponible", row, col);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public JPanel getPanel1() {
        return panel1;
    }

    public static void main(String[] args) {
        Empresa empresa = new Empresa();
        empresa.cargarDatosConProgreso(); // Ensure the connection is established

        JFrame frame = new JFrame("Vender Pasaje");
        frame.setContentPane(new VenderPasaje(empresa).panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}