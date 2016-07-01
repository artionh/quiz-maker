package entityBeans;

import java.util.List;
import java.util.Set;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.servlet.http.HttpSession;

import daos.UserDao;

@ManagedBean(name = "user")
@SessionScoped
@Entity
@Table(name = "user")
public class user implements CRUDActions {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String username;
	private String password;
	@ManyToOne
	@JoinColumn(name = "role_id")
	private role roli;
	@OneToMany(mappedBy = "useri", cascade = CascadeType.ALL)
	private Set<question> questions;

	public user() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public role getRoli() {
		return roli;
	}

	public void setRoli() {
		UserDao obj = new UserDao();
		this.roli = obj.setRoli(1);
	}

	public Set<question> getQuestions() {
		return questions;
	}

	public void setQuestions(Set<question> questions) {
		this.questions = questions;
	}

	public String add() {
		clearALL();
		UserDao obj = new UserDao();
		setRoli();
		obj.ADD(this);
		clearALL();
		return null;

	}

	public String update() {
		UserDao obj = new UserDao();
		obj.UPDATE(this);
		clearALL();
		return null;

	}

	public String delete() {
		UserDao obj = new UserDao();
		obj.DELETE(id);
		clearALL();
		return null;
	}

	public List<user> listUsers() {
		UserDao obj = new UserDao();
		return obj.getUsers();
	}

	public String getUser() {
		UserDao obj1 = new UserDao();
		user objus = obj1.getUser(password, username);

		if (objus != null) {
			setData(objus);
			if (objus.getRoli().getName().equals("FFF"))
				return "admin";
			else
				return "userpage";
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
					"Incorrect Username and Password", "Please enter correct username and Password"));
			return "login";
		}
	}

	public void clearALL() {
		this.username = "";
		this.password = "";
		this.roli = null;
		this.questions = null;
	}



	public String logout() {
		HttpSession session = SessionUtils.getSession();
		session.invalidate();
		return "login";
	}

}
