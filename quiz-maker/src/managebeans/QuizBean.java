package managebeans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;


import daos.QuestionDao;

@ManagedBean(name = "quizBean")
@SessionScoped
public class QuizBean {
	


	private List<entities.question> questions;
	@ManagedProperty(value = "#{questionDao}")
	private QuestionDao questionDao;
	
	private String userSelection;
	
	
	private int trueAnswer=0;
	
	private int wrongAnswer=0;
	

	public int getTrueAnswer() {
		return trueAnswer;
	}

	public void setTrueAnswer(int trueAnswer) { 
		this.trueAnswer = trueAnswer;
	}

	public int getWrongAnswer() {
		return wrongAnswer;
	}

	public void setWrongAnswer(int wrongAnswer) {
		this.wrongAnswer = wrongAnswer;
	}

	public String getUserSelection() {
		return userSelection;
	}

	public void setUserSelection(String userSelection) {
		this.userSelection = userSelection;
	}

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
	
	
	public String calculateSelections(){
		
       for(int i = 0 ;i<this.userSelection.length();i++)
       {
    	   if (this.questions.get(i).getAnswer().getTrue1().equals(this.userSelection)){
    		   
    		   this.trueAnswer++;
    	   }else{
    		   
    		   this.wrongAnswer++;
    	   }
       }
       
       return "results";
		
	}
	
}
