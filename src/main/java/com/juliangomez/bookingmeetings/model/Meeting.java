package com.juliangomez.bookingmeetings.model;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * This class represents a meeting in a real life
 * It has 3 properties: title or description, 
 * duration and schedule of the meeting
 * @author Julian G
 */
public class Meeting implements Comparable<Meeting>{
    
    private String title;
    private int durationMinutes;
    private Calendar startDate;

    public Meeting(){
        
    }
    
    public Meeting(String title, int durationMinutes){
        this.title = title;
        this.durationMinutes = durationMinutes;
    }
    
    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the durationMinutes
     */
    public int getDurationMinutes() {
        return durationMinutes;
    }

    /**
     * @param durationMinutes the durationMinutes to set
     */
    public void setDurationMinutes(int durationMinutes) {
        this.durationMinutes = durationMinutes;
    }

    /**
     * @return the startDate
     */
    public Calendar getStartDate() {
        return startDate;
    }

    /**
     * @param startDate the startDate to set
     */
    public void setStartDate(Calendar startDate) {
        this.startDate = startDate;
    }
    
    @Override
    public String toString() {
        return getStartDate().get(Calendar.HOUR_OF_DAY) + ":"
                + getStartDate().get(Calendar.MINUTE)
                + " " + getTitle() + " (" + getDurationMinutes() + ")";
    }

    @Override
    public int compareTo(Meeting o) {
        return Integer.compare(this.durationMinutes, o.getDurationMinutes());
    }
    
    
    
}
