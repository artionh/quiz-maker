package managebeans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import daos.CategoryDao;
 
import entities.category;


@ManagedBean(name = "categoryBean")
@SessionScoped
public class CategoryBean {
	
	private List<category> categories;
	@ManagedProperty(value = "#{categoryDao}")
	private CategoryDao categoryDao;
	private String name;		
	private int id;
	
	@PostConstruct
	public void init() {
		 categories  = categoryDao.getCategories();	 
	}
	public List<category> getCategories() {
		
			return categories;
	}

	public void setCategories(List<category> categories) {
		this.categories = categories;
	}

 

	public CategoryDao getCategoryDao() {
		return categoryDao;
	}


	public void setCategoryDao(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
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
    

	 
	
}
