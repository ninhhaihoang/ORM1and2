package fa.training.dao;

import fa.training.entities.CinemaRoomDetail;

import java.util.List;

public interface CinemaRoomDetailDao {
    CinemaRoomDetail findById(int id);
    List<CinemaRoomDetail> findAll();
    void save(CinemaRoomDetail cinemaRoomDetail);
    void delete(int id);
}
