package entityBeans;

import java.util.List;
import java.util.Random;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;



import DAO.questionDAO;

@ManagedBean(name="quiz")
@SessionScoped
public class Quiz {
 private List<question> questions;
 private int points;
private String[] question;
private List<String[]> answer;
private int[] p;//Marrim pozicionet e pyetjeve te perdoruesve
private int[] v;//Ruajme pozicionin e pyetjeve te verteta

 public  Quiz(){
	 
 }
 
 public String Play(){
	 //Mbush listen me pyetje random te marra per cdo kategori ne menyre te barabarte. 
	createQuiz();
	randomizeQuestions();
	return "quiz"; 
 }
 public void createQuiz(){
	 List<category> m ;
	 questionDAO obj = new questionDAO();
	AllData categories = new AllData();
	m = categories.listCategories();
	//Llogarisim sa pyetje na duken per kategori me perafersi kur vendosim nje nr max pyetjesh prej 20  
	int max_nr = 20/m.size();
	for(int i = 0 ; i < m.size();i++){
		questions.addAll(obj.getQuestionRandom(i,max_nr));
	}	
	}
	
public void randomizeQuestions(){
	int n = questions.size();
    Random random = new Random();
    random.nextInt();
    for (int i = 0; i < n; i++) {
      int change = i + random.nextInt(n - i);
      swap(questions, i, change);
    }	
	}



private void swap(List<question> questions1, int i, int change) {
	// TODO Auto-generated method stub
	 question helper = questions1.get(i);
	    @SuppressWarnings("unused")
		question p=questions1.get(i);
	    question q=questions1.get(change);
	    p=q;
	    q = helper;
	    
}
public void randomizeAnswer(){
	
	for(int i=0;i<questions.size();i++)
	{
		question[i] = questions.get(i).getName();	
	}
	for(int i = 0 ; i<questions.size();i++){
	    Random random = new Random();
	    random.nextInt();
		int change = random.nextInt(3);
		answer.get(i)[change]=questions.get(i).getAnswer().getTrue1();
		v[i] = change;
	    if(change==0){
	    	answer.get(i)[1] = questions.get(i).getAnswer().getFalse2();
	    	answer.get(i)[2] = questions.get(i).getAnswer().getFalse1();;
	    	answer.get(i)[3] = questions.get(i).getAnswer().getFalse3();
	    }
	    if(change==1){
	    	answer.get(i)[3] = questions.get(i).getAnswer().getFalse2();
	    	answer.get(i)[0] = questions.get(i).getAnswer().getFalse1();;
	    	answer.get(i)[2] = questions.get(i).getAnswer().getFalse3();
	    }
	    if(change==2){
	    	answer.get(i)[1] = questions.get(i).getAnswer().getFalse2();
	    	answer.get(i)[0] = questions.get(i).getAnswer().getFalse1();;
	    	answer.get(i)[3] = questions.get(i).getAnswer().getFalse3();
	    }
	    if(change==3){
	    	answer.get(i)[0] = questions.get(i).getAnswer().getFalse2();
	    	answer.get(i)[2] = questions.get(i).getAnswer().getFalse1();;
	    	answer.get(i)[1] = questions.get(i).getAnswer().getFalse3();
	    }
	}
}
@SuppressWarnings("unused")
private int getPoints(){
	points = 0;
	for(int i = 0;i<v.length;i++)
	{
		if(v[i]==p[i])
			points++;
	}
	return points;
}

}


