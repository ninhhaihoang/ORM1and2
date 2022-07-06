package fa.training.entities;

import java.io.Serializable;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@SuppressWarnings("serial")
@Entity @Getter @Setter @AllArgsConstructor @NoArgsConstructor @ToString
@Table(name = "SEAT")
public class Seat implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SEAT_ID")
    private int seatId;
    @Column(name = "SEAT_COLUMN")
    private String seatColumn;
    @Column(name = "SEAT_ROW")
    private int seatRow;
    @Column(name = "SEAT_STATUS")
    private String seatStatus;
    @Column(name = "SEAT_TYPE")
    private String seatType;


    @ManyToOne
    @JoinColumn(name = "CINEMA_ROOM_ID")
    private CinemaRoom cinemaRoom;

    public Seat(String seatColumn, int seatRow, String seatStatus, String seatType, CinemaRoom cinemaRoom) {
        this.seatColumn = seatColumn;
        this.seatRow = seatRow;
        this.seatStatus = seatStatus;
        this.seatType = seatType;
        this.cinemaRoom = cinemaRoom;
    }
}