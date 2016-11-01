/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juliangomez.bookingmeetings;

import com.juliangomez.bookingmeetings.model.Meeting;
import com.juliangomez.bookingmeetings.model.Room;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

/**
 *
 * @author Julian G
 */
@RunWith(MockitoJUnitRunner.class)
public class RoomTest {
    private Room room;
    
    @Before
    public void setUp() throws Exception{
        room = new Room();
    }
    
    
    @Test
    public void testInitializeRoomSuccess(){
        try {
            room = new Room();
            assertTrue(!room.getMeetings().equals(null));
            assertEquals(room.getMeetings().size(), 2);
            
        } catch (Exception ex) {
            fail();
        }
        
    }
    
    @Test
    public void testAddMeetingSuccess(){
        try {
            room.sortingMeetings(getMeeting());
            assertEquals(3, room.getMeetings().size());
            assertEquals("Test Title", room.getMeetings().get("9:00").getTitle());
            assertEquals(60, room.getMeetings().get("9:00").getDurationMinutes());
            assertEquals(9, room.getMeetings().get("9:00").getStartDate(). 
                    get(Calendar.HOUR_OF_DAY));
            assertEquals(0, room.getMeetings().get("9:00").getStartDate(). 
                    get(Calendar.MINUTE));
        } catch (Exception ex) {
            fail();
        }
        
    }
    
    @Test
    public void testAddMeetingFail(){
        try {
            Meeting m1 = new Meeting();
            List<Meeting> listOfMeetings = new ArrayList<>();
            listOfMeetings.add(m1);
            room.sortingMeetings(listOfMeetings);
        } catch (Exception ex) {
            fail();
        }
    }
    
    @Test
    public void testAddMultiMeetingSuccess(){
        try {
            room.sortingMeetings(getMeetings());
            assertEquals(5, room.getMeetings().size());
        } catch (Exception ex) {
            fail();
        }
        
    }
    
    private List<Meeting> getMeeting(){
        Meeting m1 = new Meeting("Test Title", 60);
        List<Meeting> listOfMeetings = new ArrayList<>();
        listOfMeetings.add(m1);
        return listOfMeetings;
    }
    
    private List<Meeting> getMeetings(){
        Meeting m1 = new Meeting("Test 1", 60);
        Meeting m2 = new Meeting("Test 2", 30);
        Meeting m3 = new Meeting("Test 3", 45);
        List<Meeting> listOfMeetings = new ArrayList<>();
        listOfMeetings.add(m1);
        listOfMeetings.add(m2);
        listOfMeetings.add(m3);
        return listOfMeetings;
    }
    
}
