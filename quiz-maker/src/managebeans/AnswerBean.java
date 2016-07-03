package managebeans;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import entities.answer;

@ManagedBean(name = "answerBean")
@ViewScoped
public class AnswerBean {
	private answer answer = new answer();

	@PostConstruct
	public void init() {
	}

	public answer getAnswer() {
		return answer;
	}

	public void setAnswer(entities.answer answer) {
		this.answer = answer;
	}

	


}
