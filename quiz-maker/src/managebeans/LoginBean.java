package managebeans;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import daos.UserDao;
import entityBeans.SessionUtils;
import entityBeans.user;

@ManagedBean(name = "loginBean")
@ViewScoped
public class LoginBean {

	private String username;
	private String password;

	@ManagedProperty(value = "#{userDao}")
	UserDao userDao;

	@PostConstruct
	public void init() {
	}

	public String login() {
		user user = userDao.getUser(password, username);
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

	public void setData(user obj) {
		SessionUtils.getSession().setAttribute("username", obj.getUsername());
	}
}
