package fa.training.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.ToString.Exclude;

@SuppressWarnings("serial")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "TYPE")
public class Type implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TYPE_ID")
	private int typeId;
	@Column(name = "TYPE_NAME")
	private String typeName;
	@Column(name = "TYPE_DESCRIPTION")
	private String typeDescription;

	/**
	 * -- Fetch Lazy is much faster and less memory then Eager, but sometimes it lead to LazyInitializationException --
	 * When we use Eager, it will generate n+1 query (n = entity) which cause slow down in the program
	 * But if we use lazy, we just have to use 1 sql statement to select all the data we need, so it will take less memory and be
	 * faster in big projects which have hundreds of tables. But the only problem is that it could lead to LazyInitializationException.
	 */
	@OneToMany(cascade = CascadeType.REMOVE, mappedBy = "movieTypeKey.type")
	@ToString.Exclude
	private Set<MovieType> movieTypes;
	
	public Type(String typeName, String typeDescription) {
		super();
		this.typeName = typeName;
		this.typeDescription = typeDescription;
	}
	
}
