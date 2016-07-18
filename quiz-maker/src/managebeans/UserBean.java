package managebeans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import daos.UserDao;

@ManagedBean(name = "userBean")
@SessionScoped
public class UserBean implements actions {
	
	private entities.user user = new entities.user();
	
	@ManagedProperty(value = "#{userDao}")
	private UserDao userDao;
	
	private List<entities.user> users;
	
	private String password;
	
	private String newPassword;
	
	@ManagedProperty(value = "#{loginBean}")
	private LoginBean loginBean;
	
	

	@PostConstruct
	public void init() {
	}

	public entities.user getUser() {
		return user;
	}

	public void setUser(entities.user user) {
		this.user = user;
	}

	public List<entities.user> getUsers() {
		
		users = userDao.getUsers();
		
		return users;
	}

	public void setUsers(List<entities.user> users) {
		
		this.users = users;
	}

	public UserDao getUserDao() {
		
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		
		this.userDao = userDao;
	}

	public String getPassword() {
		
		return password;
	}

	public void setPassword(String password) {
		
		this.password = password;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	
	public LoginBean getLoginBean() {
		return loginBean;
	}

	public void setLoginBean(LoginBean loginBean) {
		this.loginBean = loginBean;
	}

	public void changePassword(){
		
		if((loginBean.getUser().getPassword().equals(this.password)))
			{	
			loginBean.getUser().setPassword(newPassword);
			    
			userDao.update(loginBean.getUser());
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "INFO", "The password was sucessfully changed! "));
			
			}
			else
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "The Old password you enter doesnt match the password"));
	
	}
	
	public void add(){
		if(userDao.Exist(user.getUsername())){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warn!", "This username exist . Try another."));
		}
		else{
		user.setRoli(userDao.setRoli(2));
		userDao.add(user);
		user = new entities.user();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Attention! ", "Your account was sucessfully created"));
		}
	}

	public void delete(int user) {
		
		users.remove(userDao.get(user));
		
		userDao.delete(user); 
		
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "INFO", "The account was sucessfully deleted"));
		
		
		users = userDao.getUsers();
	}
	
	public String update(){
		
		userDao.update(user);
		
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "INFO", "The account was sucessfully updated"));
		
		user = new entities.user();
		
	return "user";	
	}
	
	public String select (int user){
		
		this.user = userDao.get(user);
		
		return "userUpdate";
	}
	
	public String view(int user){
		
		this.user = userDao.get(user);  
		
		return "userQuestions";
		
	}
	
	public String turnBack(){
		
		user = new entities.user();
		
		return "adminpage";
	}
	
	
    
}
