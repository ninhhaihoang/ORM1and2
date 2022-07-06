package fa.training.dao;

import fa.training.entities.Seat;

import java.util.List;

public interface SeatDao {
    List<Seat> findAll();
    Seat findById(int id);
    void save(Seat seat);
    void saveAll(List<Seat> seats);
    void delete(int id);
}
