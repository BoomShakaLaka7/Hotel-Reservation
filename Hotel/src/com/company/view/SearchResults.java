package com.company.view;

import com.company.model.Hotel;
import com.company.model.Model;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.io.IOException;
import java.util.ArrayList;

public class SearchResults extends JFrame{
    private JPanel panel;
    private static JTextArea results;
    View view;
    ArrayList<Hotel> hotels;

    public static void getSearchResultsView(){
        SearchResults frame = new SearchResults();
        frame.setVisible(true);
    }

    public SearchResults(){
        setTitle("Search Results");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
//        setContentPane(panel);
//        panel.setLayout(null);
        setSize(500, 500);
        results = new JTextArea();
        results.setText("");

    }
}
