package managebeans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import daos.AnswerDao;
import daos.QuestionDao;
import daos.UserDao;

import entities.answer;
import entities.category;
import entities.question;
import entities.user;

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
	private String true1;
	private String false1;
	private String false2;
	private String false3;
	private String name;
	private int id;
	private question question;
	private List<question> questionUser;

	@PostConstruct
	public void init() {
		questions = questionDao.getQuestion();
		questionUser = loginBean.getUser().getQuestions();

	}

	public void add() {
		question question = new question();
		question.setName(name);
		category category = new category();
		category = categoryBean.getCategoryDao().get(categoryBean.getId());
		question.setCategory(category);
		user user = new user();
		user = loginBean.getUser();
		question.setUseri(user);
		questionDao.add(question);
		answer answer = new answer();
		answer.setTrue1(true1);
		answer.setFalse1(false1);
		answer.setFalse2(false2);
		answer.setFalse3(false3);
		answer.setQuestion(question);
		answerDao.add(answer);

		questions = questionDao.getQuestion();

	}

	public void delete() {
		questionDao.delete(id);

	}

	public List<question> getQuestions() {

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

	public String getTrue1() {
		return true1;
	}

	public void setTrue1(String true1) {
		this.true1 = true1;
	}

	public String getFalse1() {
		return false1;
	}

	public void setFalse1(String false1) {
		this.false1 = false1;
	}

	public String getFalse2() {
		return false2;
	}

	public void setFalse2(String false2) {
		this.false2 = false2;
	}

	public String getFalse3() {
		return false3;
	}

	public void setFalse3(String false3) {
		this.false3 = false3;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String UpdateQuestion(int question) {
		return "questionUpdate";
	}

	public List<question> getQuestionUser() {
		return questionUser;
	}

	public void setQuestionUser(List<question> questionUser) {
		this.questionUser = questionUser;
	}

	public question getQuestion() {
		return question;
	}

	public void setQuestion(question question) {
		this.question = question;
	}

}
