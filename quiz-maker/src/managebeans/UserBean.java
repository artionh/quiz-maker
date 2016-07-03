package managebeans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import daos.UserDao;

@ManagedBean(name = "userBean")
@ViewScoped
public class UserBean {
	private entities.user user = new entities.user();
	@ManagedProperty(value = "#{userDao}")
	private UserDao userDao;
	private List<entities.user> users;
	

	@PostConstruct
	public void init() {
	}

	public entities.user getUser() {
		return user;
	}

	public void setUser(entities.user user) {
		this.user = user;
	}
	public String add(){
		userDao.add(user);
	return null;
	}
	public String update(){
		userDao.update(user);
	return null;	
	}
    public String delete(){
    	userDao.delete(user.getId());
    return null;	
    }

	public List<entities.user> getUsers() {
		users = userDao.getUsers();
		return users;
	}

	public void setUsers(List<entities.user> users) {
		this.users = users;
	}

	
    
}
