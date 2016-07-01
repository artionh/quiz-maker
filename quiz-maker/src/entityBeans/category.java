package entityBeans;

import java.util.List;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import DAO.categoryDAO;


@ManagedBean(name="category")
@SessionScoped
@Entity
public class category implements CRUDActions {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private int id;
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
		public String add(){
			categoryDAO categoryDao = new categoryDAO();
			categoryDao.ADD(this);
			clearALL();
			return null;
		}
		public String update(){
			categoryDAO obj = new categoryDAO();
			obj.UPDATE(this);
			clearALL();
			return null;
			
		}
		public String delete(){
			categoryDAO obj = new categoryDAO();
			obj.DELETE(id);
			clearALL();
			return null;
		}
		public void clearALL(){
			this.name = null;
			this.questions = null;
		}
		public void setData(category c){
			this.id = c.id;
			this.name = c.name;
			this.questions = c.questions;
		}
}
