package entityBeans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@ManagedBean(name="answer")
@SessionScoped
@Entity
@Table(name="answer")
public class answer {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)  
	private int id;
	private String true1;
	private String false1;
	private String false2;
	private String false3;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="question_id")
	private question question;
	
		public answer() {
		super();
	}
		
		public answer(String true1, String false1, String false2, String false3) {
			super();
			this.true1 = true1;
			this.false1 = false1;
			this.false2 = false2;
			this.false3 = false3;
		}

		public String getTrue1() {
			return true1;
		}
		public void setTrue1(String true1) {
			this.true1 = true1;
		}
		
		public String getFalse1() {
			return false1;
		}
		public void setFalse1(String false1) {
			this.false1 = false1;
		}
		public String getFalse2() {
			return false2;
		}
		public void setFalse2(String false2) {
			this.false2 = false2;
		}
		public String getFalse3() {
			return false3;
		}
		public void setFalse3(String false3) {
			this.false3 = false3;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public question getQuestion() {
			return question;
		}
		public void setQuestion(question question) {
			this.question = question;
		}
		
}
