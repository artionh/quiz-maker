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
import javax.persistence.Table;


@ManagedBean(name="role")
@SessionScoped
@Entity
@Table(name = "role")
public class role {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) 
	int id;
	private String name;
	@OneToMany(mappedBy="roli",cascade=CascadeType.ALL)
	private List<user> user;
	public role() {
	}
	public role(String name) {
		this.name = name;
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
	public List<user> getUser() {
		return user;
	}
	public void setUser(List<user> user) {
		this.user = user;
	}
	
	
}
