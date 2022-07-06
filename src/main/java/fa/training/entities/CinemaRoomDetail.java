package fa.training.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@SuppressWarnings("serial")
@Entity
@Getter
@Setter
@RequiredArgsConstructor
@ToString
@Table(name = "CINEMA_ROOM_DETAIL")
public class CinemaRoomDetail implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CINEMA_ROOM_DETAIL_ID")
    private int cinemaRoomDetailId;
    @Column(name = "ROOM_RATE")
    private int roomRate;
    @Column(name = "ACTIVE_DATE")
    private Date activeDate;
    @Column(name = "ROOM_DESCRIPTION")
    private String roomDescription;

    @OneToOne
    @JoinColumn(name = "CINEMA_ROOM_ID")
    @ToString.Exclude
    private CinemaRoom cinemaRoom;
}