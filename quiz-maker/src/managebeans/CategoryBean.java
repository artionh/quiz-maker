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
	private int id;
	private category category = new category();
	
	@PostConstruct
	public void init() {
		 categories  = categoryDao.getCategories();	 
	}
	public List<category> getCategories() {
		
			return categories;
	} 
	
    public void add(){
    	categoryDao.add(category);
    	categories.add(category);
    	category = new category();
    	categories  = categoryDao.getCategories();
    	
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
	public category getCategory() {
		return category;
	}
	public void setCategory(category category) {
		this.category = category;
	} 
	public String select(int category){
		this.category = categoryDao.get(category);
		return "categoryUpdate";
	}
	public String update(){
		categoryDao.update(category);
		categories = categoryDao.getCategories();
		category = new category();
		return "category";
	}
  
    public void delete(int category){
    	categories.remove(categoryDao.get(category));	 
    	categoryDao.delete(category);
    	categories  = categoryDao.getCategories();
    	this.category = new category();
    }

	 public String view(int category){
		 this.category = categoryDao.get(category);
		 return "categoryQuestions";
		 
	 }
	 public String turnBack(){
		 category = new category();
		return "adminpage";
		 
	 }
	
}
