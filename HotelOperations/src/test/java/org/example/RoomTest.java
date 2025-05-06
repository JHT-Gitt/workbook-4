package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RoomTest {


    Room room = new Room(true, false, false, 150, 2);

    @Test
    public void testCheckIn() {
        room.checkIn();
        assertTrue(room.isOccupied);
        assertTrue(room.isDirty);
    }

    @Test
    public void testCheckout() {
        room.checkIn();
        room.checkout();
        assertTrue(room.isAvailable);
        assertFalse(room.isOccupied);
        assertFalse(room.isDirty);
    }

    @Test
    public void testCleanRoom() {
     //   room.checkIn();
     //   room.checkout();
        room.cleanroom();
        assertFalse(room.isDirty);
    }

}
