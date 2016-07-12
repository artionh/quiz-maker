package managebeans;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import daos.AnswerDao;
import daos.QuestionDao;
import daos.UserDao;
import entities.answer;
import entities.category;
import entities.question;

@ManagedBean(name = "questionBean")

@SessionScoped

public class QuestionBean {

	@ManagedProperty(value = "#{questionDao}")
	private QuestionDao questionDao;
	
	List<question> questions;
	
	@ManagedProperty(value = "#{answerDao}")
	private AnswerDao answerDao;
	
	@ManagedProperty(value = "#{userDao}")
	private UserDao userDao;
	
	@ManagedProperty(value = "#{categoryBean}")
	private CategoryBean categoryBean;
	
	@ManagedProperty(value = "#{loginBean}")
	private LoginBean loginBean;
	
	private int id;
	
	private answer answer = new answer();
	
	private question question = new question();
	
	private List<question> allQuestions;


	@PostConstruct
	public void init() {
		
		questions = questionDao.getQuestionUser(loginBean.getUser().getId());	
		
		allQuestions = questionDao.getQuestion();
			
	}

	public void add(){
		
		question.setName(question.getName());
		
		question.setCategory(categoryBean.getCategoryDao().get(categoryBean.getId()));
		
		question.setUseri(loginBean.getUser());
		
		answer.setQuestion(question);
		
		questionDao.add(question);
		
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

	public UserDao getUserDao() {
		return userDao;
	}
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
		System.out.println(cs.get(0).getName());
		
		categoryBean.setCategories(cs);
		
		categoryBean.setId(this.question.getCategori().getId());
		
		questions = questionDao.getQuestionUser(loginBean.getUser().getId());	
		
		allQuestions = questionDao.getQuestion();
		
		if(loginBean.getUser().getRoli().getId()==1)
			
			return "questionUpdateAdmin";
		
			else
				
		return "questionUpdate";
		
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
	
	public String update(){
		
	   question.setCategory(categoryBean.getCategoryDao().get(categoryBean.getId()));
	   
		questionDao.update(question);
		
		question =  new question();
		
		categoryBean.setId(0);
		
		questions.clear();
		
		allQuestions.clear();
		
		questions = loginBean.getUser().getQuestions();	
		
		allQuestions = questionDao.getQuestion();
		
		if(loginBean.getUser().getRoli().getId()==1)
			
			return "question";
		
			else
				
		return "userpage";
	}

	public List<question> getAllQuestions() {
		
		allQuestions = questionDao.getQuestion();
		
		return allQuestions;
	}

	public void setAllQuestions(List<question> allQuestions) {
		
		this.allQuestions = allQuestions;
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
