package fa.training.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
//import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Embeddable
@SuppressWarnings("serial")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class MovieTypeKey implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@ManyToOne(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
	private Movie movie;
	
	@ManyToOne(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
	private Type type;

}
