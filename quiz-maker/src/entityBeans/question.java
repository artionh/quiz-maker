

package entityBeans;
import java.sql.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import DAO.questionDAO;


@ManagedBean(name="question")
@SessionScoped
@Entity
@Table(name="question")
public class question implements CRUDActions {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)  
	private int id;
	private String name;
	private Date date = new Date(System.currentTimeMillis()) ;
	@ManyToOne
	@JoinColumn(name="category_id")
	private category category ;
	@ManyToOne 
	@JoinColumn(name="user_id")
	@ManagedProperty(value="#{user}")
	private user useri;
	@OneToOne(mappedBy="question",cascade=CascadeType.ALL)
	private answer answer;
		
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
		
		public String add(){
			questionDAO obj = new questionDAO();
			obj.ADD(this);
			clearAll();
			return null;

		}
		public String update(){
			questionDAO obj = new questionDAO();
			obj.UPDATE(this);
			clearAll();
			return null;
			
		}
		public String delete(){
			questionDAO obj = new questionDAO();
			obj.DELETE(id);
			clearAll();
			return null;
		}
		
		
		public void setData(question q){
			this.id = q.id ;
			this.name = q.name;
			this.category = q.category;
			this.useri = q.useri;
			this.date = q.date;
			this.answer = q.answer;
			
		}
		
	public void clearAll(){
		this.name = "";
		this.answer = null;
		this.useri = null;
		this.category = null;
	}
	
}
