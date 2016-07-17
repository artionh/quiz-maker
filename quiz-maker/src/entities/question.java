package entities;



import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="question")
public class question  {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)  
	private int id;
	
	private String name;
	
	private Date date=new Date(System.currentTimeMillis());
	
	@ManyToOne
	@JoinColumn(name="category_id")
	
	private category category ;
	
	@ManyToOne 
	@JoinColumn(name="user_id")
	private user useri;
	
	@OneToOne(mappedBy="question",cascade=CascadeType.ALL)
	private answer answer;
	
	@Lob
	@Column(name="image",nullable=true,columnDefinition="longblob")
	private byte[] image;
	
		
		public question() {
		super();
		
	}
		
		public int getId() {
			return id;
		}
		
		public void setId(int id) {
			this.id = id;
		}
		
		public String getName() {
			return name;
		}
		
		public void setName(String name) {
			this.name = name;
		}
		
		public Date getDate() {
			return date;
		}
		
		public void setDate(Date date) {
			this.date = date;
		}
		
		public category getCategori() {
			return category;
		}
		
		public void setCategory(category categori) {
			this.category = categori;
		}
		
		public user getUseri() {
			return useri;
		}
		
		public void setUseri(user useri) {
			this.useri = useri;
		}
		
		public answer getAnswer() {
			return answer;
		}
		
		public void setAnswer(answer answer) {
			this.answer = answer;
		}
		
		public category getCategory() {
			return category;
		}

		public byte[] getImage() {
			return image;
		}

		public void setImage(byte[] image) {
			this.image = image;
		}
		

		

		

	
}

