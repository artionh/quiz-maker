
package managebeans;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;
import java.io.ByteArrayInputStream;
import org.primefaces.model.DefaultStreamedContent;

import daos.AnswerDao;
import daos.QuestionDao;
import entities.answer;
import entities.category;
import entities.question;

@ManagedBean(name = "questionBean")

@SessionScoped

public class QuestionBean implements actions  {

	@ManagedProperty(value = "#{questionDao}")
	private QuestionDao questionDao;
	
	List<question> questions;
	
	@ManagedProperty(value = "#{answerDao}")
	private AnswerDao answerDao;
	  
	@ManagedProperty(value = "#{categoryBean}")
	private CategoryBean categoryBean;
	
	@ManagedProperty(value = "#{loginBean}")
	private LoginBean loginBean;
	
	private answer answer = new answer();
	
	private question question = new question();
	
	private List<question> allQuestions;
	
	private UploadedFile file ;
	
	private StreamedContent file1;


	@PostConstruct
	public void init() {
		
		questions = questionDao.getQuestionUser(loginBean.getUser().getId());	
		
		allQuestions = questionDao.getQuestion();
			
	}

	public List<question> getQuestions() {
		
		questions = questionDao.getQuestionUser(loginBean.getUser().getId());
		
      	return questions;
	}
	

	public void setQuestions(List<question> questions) {
	
		this.questions = questions;
	}

	public QuestionDao getQuestionDao() {
		return questionDao;
	}

	public void setQuestionDao(QuestionDao questionDao) {
		
		this.questionDao = questionDao;
	}

	public AnswerDao getAnswerDao() {
		return answerDao;
	}

	public void setAnswerDao(AnswerDao answerDao) {
		this.answerDao = answerDao;
	}
	
	public CategoryBean getCategoryBean() {
		return categoryBean;
	}

	public void setCategoryBean(CategoryBean categoryBean) {
		this.categoryBean = categoryBean;
	}

	public LoginBean getLoginBean() {
		return loginBean;
	}

	public void setLoginBean(LoginBean loginBean) {
		this.loginBean = loginBean;
	}
	
	public question getQuestion() {
		return question;
	}
	
	public answer getAnswer() {
		return answer;
	}
	
	public void setAnswer(answer answer) {
		this.answer = answer;
	}

	public void setQuestion(question question) {
		this.question = question;
	}
	
	
	public void setAllQuestions(List<question> allQuestions) {
		
		this.allQuestions = allQuestions;
	}
	
	public List<question> getAllQuestions() {
		
		allQuestions = questionDao.getQuestion();
		
		return allQuestions;
	}
	
	
    public UploadedFile getFile() {
		return file;
	}

	public void setFile(UploadedFile file) {
		this.file = file;
	}

	public StreamedContent getFile1() {
		file1 = new DefaultStreamedContent(new ByteArrayInputStream(question.getImage()));
	return file1;	
	}

	public void setFile1(StreamedContent file1) {
		this.file1 = file1;
	}

	public void add(){
		
		if(file != null){
			byte[] bFile = file.getContents();
			question.setImage(bFile);
		}
		
		question.setName(question.getName());
		
		question.setCategory(categoryBean.getCategoryDao().get(categoryBean.getId()));
		
		question.setUseri(loginBean.getUser());
		
		questionDao.add(question);
		
		answer.setQuestion(question);
		
		answerDao.add(answer);
		
		questions.add(question);
		
		allQuestions.add(question);
		
		question = new question();
		
		answer = new answer();
		
		
		categoryBean.setId(0);
		
		questions = questionDao.getQuestionUser(loginBean.getUser().getId());	
		
		allQuestions = questionDao.getQuestion();	
		
	}
	
	public void delete(int question) {
		
		
		questionDao.delete(question);
		
		questions.remove(questionDao.get(question));
		
		questions = questionDao.getQuestionUser(loginBean.getUser().getId());	
		
		allQuestions = questionDao.getQuestion();	
		
		
	}
	public String update(){
		
		   question.setCategory(categoryBean.getCategoryDao().get(categoryBean.getId()));
		   
		   if(file != null){
			   
				byte[] bFile = file.getContents();
				question.setImage(bFile);
				
			}
		   
			questionDao.update(question);
			
			question =  new question();
			
			categoryBean.setId(0);
	     
			
			questions = questionDao.getQuestionUser(loginBean.getUser().getId()) ;	
			
			allQuestions = questionDao.getQuestion();
			
			if(loginBean.getUser().getRoli().getId()==1)
				
				return "question";
			
				else
					
			return "userpage";
		}

	 public String select(int question) {
			
			this.question = questionDao.get(question);
			
			List<category> cs = categoryBean.getCategories();
			
			for(int i=0; i<cs.size();i++){
				
				if(cs.get(i).getId()==this.question.getCategory().getId()){
					
					category c = cs.get(i);
					
					cs.set(i,  categoryBean.getCategories().get(0));
					
					cs.set(0, c);
				}	
			}
			
			categoryBean.setCategories(cs);
			
			categoryBean.setId(this.question.getCategori().getId());
			
			questions = questionDao.getQuestionUser(loginBean.getUser().getId());	
			
			allQuestions = questionDao.getQuestion();
			
			file1 = new DefaultStreamedContent(new ByteArrayInputStream(this.question.getImage()));
			
			if(loginBean.getUser().getRoli().getId()==1)
				
				return "questionUpdateAdmin";
			
				else
				
					
			return "questionUpdate";
				
		}

	public String view(int question){
		
		this.question = questionDao.get(question);
		
		System.out.println(this.question.getName());
		
		return "questionView";
		
	}
	public String turnBack(){
		
		question = new question();
		
		return "adminpage";
	}
	
	
}
