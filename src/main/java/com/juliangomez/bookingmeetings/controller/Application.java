package com.juliangomez.bookingmeetings.controller;

import com.juliangomez.bookingmeetings.model.Meeting;
import com.juliangomez.bookingmeetings.model.Room;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * This class starts the Application sending and input data
 * and receiving a sorted scheduled
 * @author Julian G
 */
public class Application {
   
    public static void main(String []args){
        try{
            
            Scanner sc = new Scanner(System.in);
            String input = "";
            System.out.println("Enter Meetings and duration separated by commas ','");
            input = sc.nextLine();
            String[] array = input.split(",");
            System.out.println("This is the solution of booking meetings:");
            System.out.println(process(array));
            
        } catch (Exception ex) {
            System.out.println("ERROR: "+ex.getMessage());
            ex.printStackTrace();
        }
    }
    
    public static String process(String[] array) throws Exception{
        Room aRoom = new Room();
        List<Meeting> listOfMeetings = createMeetings(array);
        aRoom.sortingMeetings(listOfMeetings);
        Map<String, Meeting> calendar = aRoom.getMeetings();
        List<String> list = calendar.keySet().stream().sorted().collect(Collectors.toList());
        StringBuilder str = new StringBuilder();
        for(String key : list){   
            str.append(calendar.get(key).toString());
            str.append("\n");
        }
        return str.toString();
    }
    
    private static List<Meeting> createMeetings(String[] array){
        List<Meeting> list = new ArrayList<>();
        for(int i=0; i<array.length; i=i+2){
            list.add(new Meeting(array[i].trim(), Integer.parseInt(array[i+1].trim())));
        }
        return list;
    }
    
    private static List<Meeting> getMeetings(){
        Meeting met1 = new Meeting("Sales meeting", 60);
        Meeting met2 = new Meeting("Stock inventory", 45);
        Meeting met3 = new Meeting("Prepare for customer presentation", 45);
        Meeting met4 = new Meeting("Daily Balance", 30);
        List<Meeting> list = new ArrayList<>();
        list.add(met1);
        list.add(met2);
        list.add(met3);
        list.add(met4);
        return list;
    }
}
