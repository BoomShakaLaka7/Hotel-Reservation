package com.company.view;

import com.company.model.Hotel;
import com.company.model.HotelFinder;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.IOException;
import java.util.ArrayList;

public class SearchResults {
    private JFrame frame = new JFrame("Search Results");
    private JPanel panel = new JPanel();
    private JTable table;
    private DefaultTableModel tableModel;
//    HotelFinder h;
    ArrayList<Hotel> hotels;

    public SearchResults() throws IOException {
        JScrollPane scrollPane = new JScrollPane();
        panel.add(scrollPane);

        table = new JTable();

//        tableModel = new DefaultTableModel(
//                HotelFinder.getHotels(),
//                new String[]{
//                        "Hotel Name", "Location", "Star", "Review"
//                }) {
//
//            private static final long serialVersionUID = 1L;
//            @SuppressWarnings("rawtypes")
//            Class[] columnTypes = new Class[]{
//                    Integer.class, String.class, String.class, String.class
//            };
//
//            public Class getColumnClass(int columnIndex) {
//                return columnTypes[columnIndex];
//            }
//        };
//        table.setModel(tableModel);
//
//        table.getColumnModel().getColumn(0).setPreferredWidth(60);
//        table.getColumnModel().getColumn(1).setPreferredWidth(136);
//        table.getColumnModel().getColumn(2).setPreferredWidth(170);
//        table.getColumnModel().getColumn(3).setPreferredWidth(205);
//        scrollPane.setViewportView(table);

        table.setModel(tableModel);

    }
}
