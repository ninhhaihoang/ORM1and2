package fa.training.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@SuppressWarnings("serial")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "CINEMA_ROOM")
public class CinemaRoom implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CINEMA_ROOM_ID")
    private int cinemaRoomId;
    @Column(name = "CINEMA_ROOM_NAME")
    private String cinemaRoomName;
    @Column(name = "SEAT_QUANTITY")
    private int seatQuantity;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "cinemaRoom", cascade = CascadeType.REMOVE)
	@ToString.Exclude
	private Set<Seat> seats;

    @OneToOne(mappedBy = "cinemaRoom", cascade = CascadeType.REMOVE)
    private CinemaRoomDetail cinemaRoomDetail;

    public CinemaRoom(String cinemaRoomName, int seatQuantity) {
        this.cinemaRoomName = cinemaRoomName;
        this.seatQuantity = seatQuantity;
    }
}