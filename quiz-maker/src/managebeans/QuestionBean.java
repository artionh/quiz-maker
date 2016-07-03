package managebeans;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import daos.AnswerDao;
import daos.QuestionDao;
import daos.UserDao;
import entities.question;


@ManagedBean(name = "questionBean")
@ViewScoped
public class QuestionBean {
	question question = new question();
	@ManagedProperty(value = "#{questionDao}")
	QuestionDao questionDao;
	List<question> questions;
	@ManagedProperty(value = "#{loginBean}")
	LoginBean user;
	@ManagedProperty(value = "#{userDao}")
	UserDao userDao;
	@ManagedProperty(value = "#{answerDao}")
	AnswerDao answerDao;
	@ManagedProperty(value = "#{answerBean}")
	AnswerBean answerBean;
	

	@PostConstruct
	public void init() {
	}

   public String add(){  
	 question.setUseri(userDao.getUser(user.getPassword(), user.getUsername()));
     questionDao.add(question); 
     answerBean.getAnswer().setQuestion(question);
     answerDao.add(answerBean.getAnswer());
     
	return null;
	   
   }
   
   public String update(){
	   questionDao.update(question);
	   answerDao.update(question.getAnswer());
	return null;  
   }
	public String delete(){
		questionDao.delete(question.getId());
		return null;	
	}

	public List<question> getQuestions() {
		questions = questionDao.getQuestion();
		return questions;
	}

	public void setQuestions(List<question> questions) {
		this.questions = questions;
	}

	public question getQuestion() {
		return question;
	}

	public void setQuestion(question question) {
		this.question = question;
	}
	
	

}
