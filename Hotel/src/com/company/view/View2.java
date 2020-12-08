//package com.company.view;
//
//import com.company.model.Hotel;
//import com.company.model.Model;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionListener;
//import java.awt.event.MouseAdapter;
//import java.awt.event.MouseEvent;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
///**
// * View2 displays sorted hotel list
// */
//public class View2 {
//    JFrame frame = new JFrame();
//    JPanel panel = new JPanel();
//    Date checkIn;
//    Date checkOut;
//    int guests;
//    int star;
//
//    JTextArea results = new JTextArea(20, 6);
//    public List<Hotel> hotelList = new ArrayList<>();
//    int hotelsFound = 0;
//    JButton reserveButton = new JButton("Reserve");
//
//
//    JLabel enterIDLabel = new JLabel("Enter Corresponding Hotel Number:");
//    JTextField enteredValue = new JTextField("e.g. 0 , 1 , 2", 10);
//
//    public List<Hotel> getHotelList() {
//        return hotelList;
//    }
//
//    public Date getCheckIn() {
//        return checkIn;
//    }
//
//    public Date getCheckOut() {
//        return checkOut;
//    }
//
//    /**
//     * Constructor for View2
//     * @param model
//     * @param view
//     */
//    public View2(Model model, View view) {
//
//        frame.setVisible(true);
//        frame.setSize(550, 500);
//        frame.setTitle("Search Results");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//        results.setEditable(false);
//        results.setText("");
//
//        String city = view.getCity();
//        checkIn = view.getCheckIn();
//        checkOut = view.getCheckOut();
//        guests = view.getGuests();
//        Date today = new Date();
//
//        if(view.filtered){
//            Double review = Double.parseDouble(view.getReview());
//            star = view.getStar();
//            int maxPrice = view.getMaxPrice();
//            int minPrice = view.getMinPrice();
//
//            try {
//                for (int i = 0; i < 25; ++i) {
//                    if (model.getHotels().get(i).getLocation().equals(city) && checkIn.before(checkOut) && checkIn.after(today)
//                            && model.getHotels().get(i).getStar() == star && Double.parseDouble(model.getHotels().get(i).getReview()) >= review
//                            && model.getHotels().get(i).getPrice() <= maxPrice && model.getHotels().get(i).getPrice() >= minPrice
//                    ) {
//                        hotelList.add(model.getHotels().get(i));
//                        hotelsFound += 1;
//                    }
//                }
//                results.append("    Hotel Name   \t" + "Location    \t" + "Price   \t" + "Star   \t" + "Reviews" + "\n\n");
//                for (int i = 0; i < hotelsFound; i++) {
//                    results.append(i+1 + ": " +  hotelList.get(i).getHotel() + "\t" + hotelList.get(i).getLocation() + "\t"
//                            + hotelList.get(i).getPrice() + "\t" + hotelList.get(i).getStar() + "\t" + hotelList.get(i).getReview() + "\n");
//                }
//
//            } catch (IOException ioException) {
//                ioException.printStackTrace();
//            }
//        }
//
//        else {
//            try {
//                for (int i = 0; i < 25; ++i) {
//                    if (model.getHotels().get(i).getLocation().equals(city) && checkIn.before(checkOut)
//                            && checkIn.after(today)) {
//                        hotelList.add(model.getHotels().get(i));
//                        hotelsFound += 1;
//                    }
//                }
//                results.append("    Hotel Name   \t" + "Location    \t" + "Price   \t" + "Star   \t" + "Reviews" + "\n\n");
//                for (int i = 0; i < hotelsFound; i++) {
//                    results.append(i + ": " + hotelList.get(i).getHotel() + "\t" + hotelList.get(i).getLocation() + "\t"
//                            + hotelList.get(i).getPrice() + "\t" + hotelList.get(i).getStar() + "\t" + hotelList.get(i).getReview() + "\n");
//                }
//
//            } catch (IOException ioException) {
//                ioException.printStackTrace();
//            }
//        }
//
//        // Save default font
//        Font defaultFont = enteredValue.getFont();
//        // Create italic font
//        Font font = new Font("Segoe Script", Font.ITALIC, 12);
//
//        enteredValue.setFont(font);
//        enteredValue.setForeground(Color.GRAY);
//
//        enteredValue.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                enteredValue.setFont(defaultFont);
//                enteredValue.setForeground(Color.BLACK);
//                enteredValue.setText(null);
//            }
//        });
//
//
//        panel.add(results);
//        panel.add(enterIDLabel);
//        panel.add(enteredValue);
//        panel.add(reserveButton);
//        frame.add(panel);
//
//    }
//
//    public void reserveButtonListener(ActionListener reserveButtonL){
//        reserveButton.addActionListener(reserveButtonL);
//    }
//
//    public int getHotelsFound(){return hotelsFound;}
//
//    public static String getEnteredValue(){return enteredValue.getText();}
//
//    public static String getHotelName(){
//        int ind = Integer.parseInt(getEnteredValue());
//        return hotelList.get(ind).getHotel();
//    }
//
//    public static int getHotelPrice(){
//        int ind = Integer.parseInt(getEnteredValue());
//        int diff = (int) (checkOut.getTime() - checkIn.getTime())/ (1000 * 60 * 60 * 24);
//        return hotelList.get(ind).getPrice() * diff * guests;
//    }
//
//    public int getStar() { return star; }
//
//}

package com.company.view;

import com.company.model.Hotel;
import com.company.model.Model;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * View2 displays sorted hotel list
 */
public class View2 {
    JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    static Date checkIn;
    static Date checkOut;
    public int index;
    static int guests;

    JTextArea results = new JTextArea(20, 6);
    public static List<Hotel> hotelList = new ArrayList<>();
    int hotelsFound = 0;
    JButton reserveButton = new JButton("Reserve");

    JLabel enterIDLabel = new JLabel("Enter Corresponding Hotel Number:");
    static JTextField enteredValue = new JTextField("e.g. 0 , 1 , 2", 10);

    public List<Hotel> getHotelList() {
        return hotelList;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    /**
     * Constructor for View2
     * @param model
     * @param view
     */
    public View2(Model model, View view) {

        frame.setVisible(true);
        frame.setSize(550, 500);
        frame.setTitle("Search Results");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        results.setEditable(false);
        results.setText("");

        String city = view.getCity();
        checkIn = view.getCheckIn();
        checkOut = view.getCheckOut();
        guests = view.getGuests();
        Date today = new Date();

        if(view.filtered){
            Double review = Double.parseDouble(view.getReview());
            int star = view.getStar();
            int maxPrice = view.getMaxPrice();
            int minPrice = view.getMinPrice();

            try {
                for (int i = 0; i < 25; ++i) {
                    if (model.getHotels().get(i).getLocation().equals(city) && checkIn.before(checkOut) && checkIn.after(today)
                            && model.getHotels().get(i).getStar() == star && Double.parseDouble(model.getHotels().get(i).getReview()) >= review
                            && model.getHotels().get(i).getPrice() <= maxPrice && model.getHotels().get(i).getPrice() >= minPrice
                    ) {
                        hotelList.add(model.getHotels().get(i));
                        hotelsFound += 1;
                    }
                }
                results.append("    Hotel Name   \t" + "Location    \t" + "Price   \t" + "Star   \t" + "Reviews" + "\n\n");
                for (int i = 0; i < hotelsFound; i++) {
                    results.append(i + ": " +  hotelList.get(i).getHotel() + "\t" + hotelList.get(i).getLocation() + "\t"
                            + hotelList.get(i).getPrice() + "\t" + hotelList.get(i).getStar() + "\t" + hotelList.get(i).getReview() + "\n");
                }

            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }

        else {
            try {
                for (int i = 0; i < 25; ++i) {
                    if (model.getHotels().get(i).getLocation().equals(city) && checkIn.before(checkOut)
                            && checkIn.after(today)) {
                        hotelList.add(model.getHotels().get(i));
                        hotelsFound += 1;
                        index = i;
//                        System.out.println(i + " " + model.getHotels().get(i));
                    }
                }
                results.append("    Hotel Name   \t" + "Location    \t" + "Price   \t" + "Star   \t" + "Reviews" + "\n\n");
                for (int i = 0; i < hotelsFound; i++) {
                    results.append(i + ": " + hotelList.get(i).getHotel() + "\t" + hotelList.get(i).getLocation() + "\t"
                            + hotelList.get(i).getPrice() + "\t" + hotelList.get(i).getStar() + "\t" + hotelList.get(i).getReview() + "\n");
                }

            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }


        Font defaultFont = enteredValue.getFont();
        // Create italic font
        Font font = new Font("Segoe Script", Font.ITALIC, 12);

        enteredValue.setFont(font);
        enteredValue.setForeground(Color.GRAY);

        enteredValue.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                enteredValue.setFont(defaultFont);
                enteredValue.setForeground(Color.BLACK);
                enteredValue.setText(null);
            }
        });


        panel.add(results);
        panel.add(enterIDLabel);
        panel.add(enteredValue);
        panel.add(reserveButton);
        frame.add(panel);


    }

    /**
     * listens for reserve button to be clicked
     * @param reserveButtonL
     */
    public void reserveButtonListener(ActionListener reserveButtonL){
        reserveButton.addActionListener(reserveButtonL);
    }

    /**
     * getter for number of hotels found
     * @return int
     */
    public int getHotelsFound(){return hotelsFound;}

    /**
     * getter for the value(hotel number) entered by the user
     * @return String
     */
    public static String getEnteredValue(){return enteredValue.getText();}

    /**
     * getter for selected hotel name
     * @return String
     */
    public static String getHotelName(){
        int ind = Integer.parseInt(getEnteredValue());
        return hotelList.get(ind).getHotel();
    }

    /**
     * getter for selected hotel price
     * @return int
     */
    public static int getHotelPrice(){
        int ind = Integer.parseInt(getEnteredValue());
        int diff = (int) (checkOut.getTime() - checkIn.getTime())/ (1000 * 60 * 60 * 24);
        return hotelList.get(ind).getPrice() * diff * guests;
    }

}
