package fa.training.entities;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "MOVIE_TYPE")
@AssociationOverrides({
	@AssociationOverride(name  = "movieTypeKey.movie", joinColumns = @JoinColumn(name="MOVIE_ID")),
	@AssociationOverride(name = "movieTypeKey.type", joinColumns =  @JoinColumn(name="TYPE_ID"))
})
public class MovieType{

	@EmbeddedId
	private MovieTypeKey movieTypeKey;

	@Column(name = "MT_DESCRIPTION")
	private String MTDescription;

	@Transient
	public Movie getMovie() {
		return getMovieTypeKey().getMovie();
	}
	
	@Transient
	public Type getType() {
		return getMovieTypeKey().getType();
	}
	
}
