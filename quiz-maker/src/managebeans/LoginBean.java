package managebeans;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped; 
import javax.servlet.http.HttpSession;

import daos.SessionUtils;
import daos.UserDao;
import entities.user;
   
@ManagedBean(name="loginBean")

@SessionScoped 

public class LoginBean {
	
	
	private String username;
	
	private String password;
	
	private user user = new user();

	
	@ManagedProperty(value="#{userDao}")
	UserDao userDao;

	
	@PostConstruct
	public void init() {
	}

	public String login() {
		
		user=userDao.getUser(password,username);
		
		if(user==null)
			
			return "login";
		
		else{
			
			setData(user);
			
		return "quizz";
		
		}
	}

	public UserDao getUserDao() {
		
		return userDao;
	}

	
	public void setUserDao(UserDao userDao) {
		
		this.userDao = userDao;
	}
	

	public user getUser() {
		
		return user;
	}

	
	public void setUser(user user) {
		
		this.user = user;
		
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

	
	public void setData(user user) {
		
		HttpSession session = SessionUtils.getSession();
		
		session.setAttribute("username", user.getUsername());
		
		session.setAttribute("id", user.getId());
		
	
	}
	public String logout() {
		
		HttpSession session = SessionUtils.getSession();
		
		session.invalidate();
		
		return "login";
	}
	
}
