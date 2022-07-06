package fa.training;

import fa.training.dao.*;
import fa.training.entities.*;
import fa.training.utils.DateUtils;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AssignmentApplication {

    public static void main(String[] args) {
/**
 * CinemaRoom CRUD is below (checked)
 * */
//        CinemaRoomDao cinemaRoomDao = new CinemaRoomDaoImpl();
//		CinemaRoom cinemaRoom2 = new CinemaRoom("Room 2", 4);
//		CinemaRoom cinemaRoom3 = new CinemaRoom("Room 3", 5);
//		CinemaRoom cinemaRoom4 = new CinemaRoom("Room 4", 4);

//		List<CinemaRoom> cinemaRooms = new ArrayList<>();

//		cinemaRooms.add(cinemaRoom1);
//		cinemaRooms.add(cinemaRoom2);
//		cinemaRooms.add(cinemaRoom3);
//		cinemaRooms.add(cinemaRoom4);

//	        Save list of cinema rooms

//		cinemaRoomDao.saveCinemaRooms(cinemaRooms);
        // get all cinema rooms
//	        cinemaRoomDao.findAll().forEach(c -> {
//	            System.out.println(c);
//	        });

        // find by id include its seats
//        System.out.println(cinemaRoomDao.findById(5));

        // update
//        CinemaRoom cinemaRoom = cinemaRoomDao.findById(5);
//        cinemaRoom.setCinemaRoomName("updated");
//        cinemaRoomDao.save(cinemaRoom);


        // delete
//	        cinemaRoomDao.delete(5);
/**
 * Seat CRUD is below (checked)
 * */
//	        SeatDao seatDao = new SeatDaoImpl();
        // save new seat
//	        Seat seat1 = new Seat();
//	        seat1.setSeatColumn("B");
//	        seat1.setSeatRow(1);
//	        seat1.setSeatType("VIP");
//	        seat1.setSeatStatus("available");
//	        seat1.setCinemaRoom(cinemaRoomDao.findById(2));
//	        seatDao.save(seat1);
        // update seat by id
//	        Seat seat = seatDao.findById(5);
//	        seat.setSeatStatus("unavailable");
//	        seatDao.save(seat);
        // delete
//	        seatDao.delete(7);
/**
 * CinemaRoomDetail CRUD is below (checked)
 * */
//		CinemaRoomDetailDao cinemaRoomDetailDao = new CinemaRoomDetailDaoImpl();

        // save new cinema room detail
//	        CinemaRoomDetail cinemaRoomDetail = new CinemaRoomDetail();
//	        cinemaRoomDetail.setCinemaRoom(cinemaRoomDao.findById(2));
//	        cinemaRoomDetail.setRoomRate(5);
//	        cinemaRoomDetail.setRoomDescription("this is description");
//	        cinemaRoomDetail.setActiveDate(DateUtils.convertToDateViaSqlDate(LocalDate.now()));
//	        cinemaRoomDetailDao.save(cinemaRoomDetail);

        // update by id
//        CinemaRoomDetail crd = cinemaRoomDetailDao.findById(4);
//        crd.setRoomDescription("updated");
//        cinemaRoomDetailDao.save(crd);

//	        cinemaRoomDetailDao.delete(4);
/**
 * Type CRUD is below (checked)
 * */
//		TypeDao typeDao = new TypeDaoImpl();
//		MovieTypeDao movieTypeDao = new MovieTypeDaoImpl();

//		Type type1 = new Type("Adventure", "Adventure movie type");
//		Type type2 = new Type("Comedy", "Comedy movie type");
//		Type type3 = new Type("Drama", "Drama movie type");
//		Type type4 = new Type("Horror", "Horror movie type");
//		Type type5 = new Type("Science fiction", "Science fiction movie type");

		// save types by list or just one type
//		List<Type> types = new ArrayList<>();
//		types.add(type1);
//		types.add(type2);
//		types.add(type3);
//		types.add(type4);
//		types.add(type5);
//		typeDao.save(type1);
//		typeDao.saveAll(types);

		// get all types
//		typeDao.findAll().forEach(t -> {
//			System.out.println(t);
//		});

		// get type by id
//		System.out.println(typeDao.findById(1).getMovieTypes());

		// update type by id
//		Type type = typeDao.findById(5);
//		type.setTypeDescription("updated");
//		typeDao.save(type);

		// delete type and its relative
//		typeDao.delete(1);
/**
 * Movie and MovieType CRUD is below (checked)
 */
		MovieDao movieDao = new MovieDaoImpl();

		// add new movie
//		Movie movie = new Movie();
//        movie.setMovieId("movie00004");
//        movie.setActor("Tom Holand");
//        movie.setContent("spriderman lost everything");
//        movie.setDirector("Ninh Hoang");
//        movie.setDuration(new BigDecimal(2.5));
//        movie.setFromDate(DateUtils.convertStringToUtilDate("05/01/2022"));
//        movie.setToDate(DateUtils.convertStringToUtilDate("07/01/2022"));
//        movie.setMovieProductionCompany("Marvel");
//        movie.setVersion("vietsub");
//        movie.setMovieNameEng("this is a test record");
//        movie.setMovieNameVn("cai nay de thu thoi");
//        movie.setLargeImage("this is url to large image");
//        movie.setSmallImage("this is url to small image");
//
//        movieDao.save(movie);

		// add types to the movie
//        movieTypeDao.save(new MovieType(new MovieTypeKey(movieDao.findById("movie00004"), typeDao.findById(4)),"description movie00004"));
//        movieTypeDao.save(new MovieType(new MovieTypeKey(movieDao.findById("movie00004"), typeDao.findById(2)), "description movie00004"));
//        movieTypeDao.save(new MovieType(new MovieTypeKey(movieDao.findById("movie00004"), typeDao.findById(3)), "description movie00004"));

		// this is another way to add type to the movie
//		MovieType movieType = new MovieType();
//		MovieTypeKey key = new MovieTypeKey();
//		key.setMovie(movieDao.findById("movie00002"));
//		key.setType(typeDao.findById(1));
//		movieType.setMovieTypeKey(key);
//		movieType.setMTDescription("description movie00002");
//		movieTypeDao.save(movieType);

		// get movie by id
//		Movie movie = movieDao.findById("movie00004");
//		System.out.println(movie.getMovieTypes());

		// get all movies without type
//		movieDao.findAll().forEach(m -> {
//			System.out.println(m);
//		});

		// delete movie by id and its relative
		movieDao.delete("movie00003");

    }

}
