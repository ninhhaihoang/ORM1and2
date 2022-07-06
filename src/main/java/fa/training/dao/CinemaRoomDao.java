package fa.training.dao;

import fa.training.entities.CinemaRoom;

import java.util.List;

public interface CinemaRoomDao {
    List<CinemaRoom> findAll();
    CinemaRoom findById(int id);
    void save(CinemaRoom cinemaRoom);
    void saveAll(List<CinemaRoom> cinemaRooms);
    void delete(int id);
}
