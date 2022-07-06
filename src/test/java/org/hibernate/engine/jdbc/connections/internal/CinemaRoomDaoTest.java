package org.hibernate.engine.jdbc.connections.internal;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

import fa.training.dao.CinemaRoomDao;
import fa.training.dao.CinemaRoomDaoImpl;
import fa.training.entities.CinemaRoom;

public class CinemaRoomDaoTest {
	static CinemaRoomDao cinemaRoomDao;

    @BeforeAll
    static void setUpBeforeClass() throws Exception {
        cinemaRoomDao = new CinemaRoomDaoImpl();
    }

    @Test
    public void testSave1() throws Exception {
        CinemaRoom cinemaRoom = new CinemaRoom();
        cinemaRoom.setCinemaRoomName("heelo");
        cinemaRoom.setSeatQuantity(1);

//        verify(cinemaRoomDao.save(cinemaRoom)); ;
//        assertEquals(null, cinemaRoomDao.save(cinemaRoom));
    }
    
    @Test
    public void testAdd() {
    	String str = "Hello world";
    	assertEquals("Hello world", str);
    }
    
    
}
