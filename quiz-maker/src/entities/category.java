package entities;



import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="category")
public class category  {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) 
	@Column(name="id")
	private int id;
	@Column(name="name")
	private String name;
	@OneToMany(mappedBy="category",cascade=CascadeType.ALL)
	private List<question> questions;
	
		public category() {
		super();
	}
		public int getId() {
			return id;
		}
		public void setId(int id){
			this.id = id;
		}
		public String getName(){
			return name;
		}
		public void setName(String name){
			this.name = name;
		}
		public List<question> getQuestions() {
			return questions;
		}
		public void setQuestions(List<question> questions) {
			this.questions = questions;
		}
	
}
