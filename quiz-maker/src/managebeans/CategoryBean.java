package managebeans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import daos.CategoryDao;
import entities.category;


@ManagedBean(name = "categoryBean")
@ViewScoped
public class CategoryBean {
	private category category;
	private List<category> categories;
	@ManagedProperty(value = "#{categoryDao}")
	private CategoryDao categoryDao;
	
	@PostConstruct
	public void init() {
	}


	public category getCategory() {
		return category;
	}


	public void setCategory(category category) {
		this.category = category;
	}


	public List<category> getCategories() {
		categories = categoryDao.getCategories();
		return categories;
	}

	public void setCategories(List<category> categories) {
		this.categories = categories;
	}
	
	public String add(){
	 categoryDao.add(category);
	return null;
	}
	public String update(){
	
		categoryDao.update(category);
		return null;
		
	}
	public String delete(){
		categoryDao.delete(category.getId());
		return null;
		
	}

	
}
