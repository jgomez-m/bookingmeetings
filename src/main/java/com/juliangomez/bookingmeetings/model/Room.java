package com.juliangomez.bookingmeetings.model;

import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class represents the Meeting Room
 * which should be organized with meetings
 * during the day
 * @author Julian G
 */
public class Room {
    private Map<String, Meeting> meetings;
    
    public Room() throws Exception{
        if (meetings == null){
            meetings = new HashMap<>();
            initialize();
        }
    }
        
    public Map<String, Meeting> getMeetings(){
        return meetings;
    }
    
    /**
     * This method sort meetings in descending mode
     * in order to be showed into the console
     */
    public void sortingMeetings(List<Meeting> listOfMeetings) throws Exception{
        //Only for Java 8
        listOfMeetings.sort((Meeting o1, Meeting o2)-> 
                Integer.compare(o1.getDurationMinutes(),
                o2.getDurationMinutes()));
        Collections.reverse(listOfMeetings);
        for(Meeting m : listOfMeetings){
            addMeeting(m);
        }
    }

    private void initialize() throws Exception {
            Meeting lunch = new Meeting();
            lunch.setDurationMinutes(60);
            Calendar date1 = Calendar.getInstance();
            date1.set(Calendar.HOUR_OF_DAY, 12);
            date1.set(Calendar.MINUTE, 0);
            lunch.setStartDate(date1);
            lunch.setTitle("Lunch");
            meetings.put(""+lunch.getStartDate().get(Calendar.HOUR_OF_DAY)
                    +":"+lunch.getStartDate().get(Calendar.MINUTE),
                    lunch);
           
            Meeting finalday = new Meeting();
            finalday.setDurationMinutes(15);
            Calendar date2 = Calendar.getInstance();
            date2.set(Calendar.HOUR_OF_DAY, 17);
            date2.set(Calendar.MINUTE, 45);
            finalday.setStartDate(date2);
            finalday.setTitle("Final day meeting");
            meetings.put(""+finalday.getStartDate().get(Calendar.HOUR_OF_DAY)
                    +":"+finalday.getStartDate().get(Calendar.MINUTE),
                    finalday);
    }
    
    /**
     * Add new meeting to the list of meetings into the room (Map)
     * @param m
     * @throws Exception 
     */
    private void addMeeting(Meeting m) throws Exception{
        if(meetings.size() > 2){
            int durationMeeting = m.getDurationMinutes();
            for(Meeting meeting : meetings.values()){
                Calendar startDate = meeting.getStartDate();
                Calendar endDate = (Calendar) startDate.clone();
                endDate.add(Calendar.MINUTE, meeting.getDurationMinutes());
                String endDateStr = ""+endDate.get(Calendar.HOUR_OF_DAY) + ":"
                        + endDate.get(Calendar.MINUTE);
                // If does not exist a meeting with endDate as StartDate
                if(!meetings.containsKey(endDateStr) && 
                    endDate.get(Calendar.HOUR_OF_DAY) != 18)
                {
                    Calendar otherStartDate = (Calendar)endDate.clone();
                    otherStartDate.add(Calendar.MINUTE, durationMeeting);
                    String otherStartDateStr = ""+otherStartDate.get(Calendar.HOUR_OF_DAY) + ":"
                        + otherStartDate.get(Calendar.MINUTE);
                  
                    if(!meetings.containsKey(otherStartDateStr)){
                        m.setStartDate(endDate);
                        String dateKey = ""+endDate.get(Calendar.HOUR_OF_DAY)
                                            +":"+endDate.get(Calendar.MINUTE);
                                            
                        meetings.put(dateKey, m);
                        break;
                    }
                    else{
                        m.setStartDate(endDate);
                        String dateKey = ""+endDate.get(Calendar.HOUR_OF_DAY)
                                            +":"+endDate.get(Calendar.MINUTE);
                                            
                        meetings.put(dateKey, m);
                        break;
                    }
                } 
            }
        }
        // First Time!!
        else{
            String dateKey = "9:00";
            Calendar cal = Calendar.getInstance();
            cal.set(Calendar.HOUR_OF_DAY, 9);
            cal.set(Calendar.MINUTE, 0);
            m.setStartDate(cal);
            meetings.put(dateKey, m);
        }
    }

}
