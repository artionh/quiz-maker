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

public class CategoryBean implements actions {
	
	
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
	
	 public void add(){
	    	
	    	categoryDao.add(category);
	    	
	    	categories.add(category);
	    	
	    	category = new category();
	    	
	    	categories  = categoryDao.getCategories();
	    	
	    	
	    }
	 
	 public void delete(int category){
	    	
	    	categories.remove(categoryDao.get(category));	
	    	
	    	categoryDao.delete(category);
	    	
	    	categories  = categoryDao.getCategories();
	    	
	    	this.category = new category();
	    }
	 
	 public String update(){
		
		categoryDao.update(category);
		
		categories = categoryDao.getCategories();
		
		category = new category();
		
		return "administrator/category";
	}
  
  
	public String select(int category){
		
		this.category = categoryDao.get(category);
		
		return "administrator/categoryUpdate";
		
	} 
	
	 public String view(int category){
		 
		 this.category = categoryDao.get(category);
		 
		 return "administrator/categoryQuestions";
		 
	 }
	 
	 
	 public String turnBack(){
		 
		 category = new category();
		 
		return "administrator/adminpage";
		 
	 }
	
}
