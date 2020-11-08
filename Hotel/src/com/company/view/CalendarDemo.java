package com.company.view;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class CalendarDemo extends JFrame implements ItemListener
{
    JPanel p1, p2;
    JComboBox month;
    JComboBox year;
    int days[]={31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    String weekdays[] = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
    String months[] = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    public CalendarDemo(String title)
    {
        super();
        setTitle(title);
        p1 = new JPanel();
        //p1.setSize(350, 30);
        //p1.setLayout(new FlowLayout());
        month = new JComboBox();
        for(int i=0;i< months.length;i++)
        {
            month.addItem(months[i]);
        }
        month.addItemListener(this);
        year = new JComboBox();
        for(int i=1980;i<=2099;i++)
        {
            year.addItem(i);
        }
        year.addItemListener(this);
        p1.add(month);
        p1.add(year);
        p2 = new JPanel();
        p2.setLayout(new GridLayout(0,7,5,5));
        Date date = new Date();
        drawCalendar(months[date.getMonth()], (1900+date.getYear()));
        year.setSelectedItem((1900+date.getYear()));
        month.setSelectedItem(months[date.getMonth()]);
        Container c=getContentPane();
        c.setLayout(new FlowLayout());
        add(p1);
        add(p2);
        setVisible(true);
        //setBounds(200, 200, 350, 300);
        setSize(230,220);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
//    public static void main(String args[])
//    {
//        CalendarDemo frame = new CalendarDemo("Calendar");
//    }

    @Override
    public void itemStateChanged(ItemEvent e)
    {
        if(e.getStateChange() == ItemEvent.SELECTED)
        {
            drawCalendar((String)month.getSelectedItem(), (Integer)year.getSelectedItem());
        }
    }

    public void drawCalendar(String inputMonth, int inputYear)
    {
        p2.removeAll();
        for(int i=0;i< weekdays.length;i++)
        {
            JLabel label = new JLabel(weekdays[i]);
            label.setHorizontalAlignment(SwingConstants.RIGHT);
            p2.add(label);
        }
        Date date = new Date("01-"+inputMonth+"-"+inputYear);
        int noOfDaysInMonth = days[date.getMonth()];
        if(date.getYear()%4==0 && date.getMonth()==1)
        {
            noOfDaysInMonth = 29;
        }

        for(int i=1, day=1;day<=noOfDaysInMonth;i++)
        {
            for(int j=0;j<7;j++)
            {
                if(day==1)
                {
                    if(j==date.getDay())
                    {
                        JLabel label = new JLabel(String.valueOf(day));
                        label.setHorizontalAlignment(SwingConstants.RIGHT);
                        p2.add(label);
                        day++;
                    }
                    else
                    {
                        JLabel label = new JLabel("");
                        p2.add(label);
                    }
                }
                else
                {
                    JLabel label = new JLabel(String.valueOf(day));
                    label.setHorizontalAlignment(SwingConstants.RIGHT);
                    p2.add(label);
                    day++;
                }
                if(day>noOfDaysInMonth)
                {
                    break;
                }
            }
        }
        p2.validate();
        setTitle(inputMonth+", "+inputYear);
    }
}