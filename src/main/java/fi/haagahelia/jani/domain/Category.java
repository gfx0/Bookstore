package fi.haagahelia.jani.domain;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Category {

	@Id
	@GeneratedValue( strategy =GenerationType.AUTO )
	private long cId;
	private String cName;
	
	@OneToMany ( cascade =CascadeType.ALL, mappedBy ="category")
	private List<Book> books;
	public Category() { }
	public Category( String cName)
	{
		this.cName = cName;
	}
	public long getcId() {
		return cId;
	}
	public void setcId(long cId) {
		this.cId = cId;
	}
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	
	
}
