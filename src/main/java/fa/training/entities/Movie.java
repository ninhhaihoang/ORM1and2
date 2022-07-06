package fa.training.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@SuppressWarnings("serial")
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "MOVIE")
public class Movie implements Serializable{
	
	@Id
	@Column(name = "MOVIE_ID")
	private String movieId;
	@Column(name = "ACTOR")
	private String actor;
	@Column(name = "CONTENT")
	private String content;
	@Column(name = "DIRECTOR")
	private String director;
	@Column(name = "DURATION")
	private BigDecimal duration;
	@Column(name = "FROM_DATE")
	private Date fromDate;
	@Column(name = "TO_DATE")
	private Date toDate;
	@Column(name = "MOVIE_PRODUCTION_COMPANY")
	private String movieProductionCompany;
	@Column(name = "VERSION")
	private String version;
	@Column(name = "MOVIE_NAME_ENG")
	private String movieNameEng;
	@Column(name = "MOVIE_NAME_VN")
	private String movieNameVn;
	@Column(name = "LARGE_IMAGE")
	private String largeImage;
	@Column(name = "SMALL_IMAGE")
	private String smallImage;

	
	/**
	 * Fetch Lazy is much faster and less memory then Eager, but sometimes it lead to LazyInitializationException
	 */
	@OneToMany(cascade = CascadeType.REMOVE, mappedBy = "movieTypeKey.movie")
	@ToString.Exclude
	private Set<MovieType> movieTypes;
	
	public Movie(String movieId, String actor, String content, String director, BigDecimal duration, Date fromDate,
			Date toDate, String movieProductionCompany, String version, String movieNameEng, String movieNameVn,
			String largeImage, String smallImage) {
		super();
		this.movieId = movieId;
		this.actor = actor;
		this.content = content;
		this.director = director;
		this.duration = duration;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.movieProductionCompany = movieProductionCompany;
		this.version = version;
		this.movieNameEng = movieNameEng;
		this.movieNameVn = movieNameVn;
		this.largeImage = largeImage;
		this.smallImage = smallImage;
	}
}
