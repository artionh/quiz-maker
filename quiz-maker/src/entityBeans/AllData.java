package entityBeans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import DAO.categoryDAO;
import DAO.questionDAO;

@ManagedBean(name="allData")
@SessionScoped
public class AllData {
	private List<category> categories;
	private String option;
	public List<category> getCategories() {
		categoryDAO obj = new categoryDAO();
		 categories = obj.getCategories();
	    return categories;
	}

	public String getOption() {
		return option;
	}

	public void setOption(String option) {
		this.option = option;
	}

	public void setCategories(List<category> categories) {
		this.categories = categories;
	}

	public List<category> listCategories(){	
		categoryDAO obj = new categoryDAO();
		return obj.getCategories();
		}
	public List<question> listQuestions(){	
		questionDAO obj = new questionDAO();
		return obj.getQuestion();
		}
}
