package org.registerformsskcet;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellEditor;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.TableCellRenderer;

class ButtonColumn extends AbstractCellEditor implements TableCellRenderer, TableCellEditor {
    private JButton renderButton;
    private JButton editButton;
    private String text;

    ButtonColumn(Action action) {
        renderButton = new JButton();
        editButton = new JButton();

        // Set the action for the buttons
        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fireEditingStopped();
            }
        });
    }

    // Implement the TableCellRenderer interface
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        if (isSelected) {
            renderButton.setForeground(table.getSelectionForeground());
            renderButton.setBackground(table.getSelectionBackground());
        } else {
            renderButton.setForeground(table.getForeground());
            renderButton.setBackground(UIManager.getColor("Button.background"));
        }

        renderButton.setText((value == null) ? "" : value.toString());
        return renderButton;
    }

    // Implement the TableCellEditor interface
    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        text = (value == null) ? "" : value.toString();
        editButton.setText(text);
        return editButton;
    }

    @Override
    public Object getCellEditorValue() {
        return text;
    }
}
