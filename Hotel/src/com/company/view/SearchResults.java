package com.company.view;

import com.company.model.Hotel;
import com.company.model.Model;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.io.IOException;
import java.util.ArrayList;

public class SearchResults extends JFrame{
    private JPanel contentPane;
    private JTable table;
    private DefaultTableModel tableModel;
    View view;
    ArrayList<Hotel> hotels;

    public static void searchResultsImpl() throws IOException {
        SearchResults frame = new SearchResults();
        frame.setVisible(true);
    }

    public SearchResults() throws IOException {

        setTitle("Search Results");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 702, 769);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 45, 500, 608);
        contentPane.add(scrollPane);

        table = new JTable();

        tableModel = new DefaultTableModel(
                Model.getSearchResults(),
                new String[]{
                        "Hotel Name", "Location", "Star", "Price" ,"Review"
                }) {

            private static final long serialVersionUID = 1L;
            @SuppressWarnings("rawtypes")
            Class[] columnTypes = new Class[]{
                    String.class, String.class, Integer.class, Integer.class, String.class
            };

            public Class getColumnClass(int columnIndex) {
                return columnTypes[columnIndex];
            }
        };
        table.setModel(tableModel);

        table.getColumnModel().getColumn(0).setPreferredWidth(200);
        table.getColumnModel().getColumn(1).setPreferredWidth(150);
        table.getColumnModel().getColumn(2).setPreferredWidth(50);
        table.getColumnModel().getColumn(3).setPreferredWidth(70);
        table.getColumnModel().getColumn(4).setPreferredWidth(50);
        scrollPane.setViewportView(table);
    }

    public JTable getTable() {
        return table;
    }
}
