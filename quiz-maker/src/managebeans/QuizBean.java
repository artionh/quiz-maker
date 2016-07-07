package managebeans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import daos.QuestionDao;

@ManagedBean(name = "quizBean")
@ViewScoped
public class QuizBean {
	


	private List<entities.question> questions;
	@ManagedProperty(value = "#{questionDao}")
	private QuestionDao questionDao;
	
	@PostConstruct
	public void init() {
		
		questions = questionDao.getQuestion();
    	
	}

	public List<entities.question> getQuestions() {
		questions = questionDao.createQuiz();
		return questions;
	}

	public void setQuestions(List<entities.question> questions) {
		this.questions = questions;
	}
	public QuestionDao getQuestionDao() {
		return questionDao;
	}

	public void setQuestionDao(QuestionDao questionDao) {
		this.questionDao = questionDao;
	}
	
}
