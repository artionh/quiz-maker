package entities;


import java.util.List;
import daos.QuestionDao;

public class demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QuestionDao c = new QuestionDao();
		List<question> q= c.createQuiz();
		for(int i=0;i <q.size();i++){
			System.out.println(q.get(i).getId());
		}
	}

}
