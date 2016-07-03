package managebeans;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import daos.SessionUtils;
import daos.UserDao;
import entities.user;


@ManagedBean(name = "loginBean")
@SessionScoped
public class LoginBean {

	private String username;
	private String password;
	private user user;

	@ManagedProperty(value = "#{userDao}")
	UserDao userDao;

	@PostConstruct
	public void init() {
	}
	
	public String login() {
		user = userDao.getUser(password, username);
		setData(user);
		return null;
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
		SessionUtils.getSession().setAttribute("username", user.getUsername());
	}
}
