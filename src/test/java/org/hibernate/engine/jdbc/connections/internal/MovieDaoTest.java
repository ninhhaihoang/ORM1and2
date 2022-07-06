package org.hibernate.engine.jdbc.connections.internal;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import fa.training.dao.MovieDao;
import fa.training.dao.MovieDaoImpl;
import fa.training.entities.Movie;
import fa.training.utils.DateUtils;

public class MovieDaoTest {
	static MovieDao movieDao;

    @BeforeAll
    static void setUpBeforeClass() throws Exception {
        movieDao = new MovieDaoImpl();
    }
    
    @Test
    public void testSave1() throws Exception {
        Movie movie = new Movie();
        movie.setMovieId("movie00001");
        movie.setActor("Tom Holand");
        movie.setContent("spriderman fight with himself");
        movie.setDirector("Ninh Hoang");
        movie.setDuration(new BigDecimal(1.5));
        movie.setFromDate(DateUtils.convertStringToUtilDate("01/01/2022"));
        movie.setToDate(DateUtils.convertStringToUtilDate("02/01/2022"));
        movie.setMovieProductionCompany("Marvel");
        movie.setVersion("vietsub");
        movie.setMovieNameEng("Sprider-man Far From Home");
        movie.setMovieNameVn("nguoi nhen xa nha");
        movie.setLargeImage("this is url to large image");
        movie.setSmallImage("this is url to small image");
        
        movieDao.save(movie);
//        assertEquals(null, cinemaRoomDao.save(cinemaRoom));
    }
}
