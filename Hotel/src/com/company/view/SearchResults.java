package com.company.view;

import com.company.model.Hotel;
import com.company.model.HotelFinder;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

public class SearchResults extends JFrame{
    private JPanel panel = new JPanel();
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
        panel.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(panel);

        JScrollPane scrollPane = new JScrollPane();
        panel.add(scrollPane);
        panel.setLayout(null);

        table = new JTable();

        tableModel = new DefaultTableModel(
                HotelFinder.getSearchResults(view.getCity(), view.getStar(), view.getCheckIn(), view.getCheckOut(),
                        view.getGuests(), view.getMinPrice(), view.getMaxPrice(), view.getReview()),
                new String[]{
                        "Hotel Name", "Location", "Star", "Review"
                }) {

            private static final long serialVersionUID = 1L;
            @SuppressWarnings("rawtypes")
            Class[] columnTypes = new Class[]{
                    String.class, String.class, Integer.class, String.class
            };

            public Class getColumnClass(int columnIndex) {
                return columnTypes[columnIndex];
            }
        };
        table.setModel(tableModel);

        table.getColumnModel().getColumn(0).setPreferredWidth(60);
        table.getColumnModel().getColumn(1).setPreferredWidth(136);
        table.getColumnModel().getColumn(2).setPreferredWidth(170);
        table.getColumnModel().getColumn(3).setPreferredWidth(205);
        scrollPane.setViewportView(table);
    }

}
