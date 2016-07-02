package daos;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import org.hibernate.Session;
import org.hibernate.Transaction;
import entityBeans.question;

@ManagedBean(name="questionDao")
@ApplicationScoped
public class QuestionDao {
public void add(question q){
		
	    Session session = hibernateUtil.getSessionFactory().openSession();
	    try {
	        session.beginTransaction();
	        session.save(q);
	        session.getTransaction().commit();
	    } 
	       
	     finally {
	        session.close();
	    }
	}
	public void delete(int id){
		Transaction trns = null;
        Session session = hibernateUtil.getSessionFactory().openSession();
        try {
        	
            trns = session.beginTransaction();
            question q = (question) session.load(question.class, new Integer(id));
            session.delete(q);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
	}
	public void update(question q){
		Transaction trns = null;
        Session session = hibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            session.update(q);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
	}
	@SuppressWarnings("unchecked")
	public List<question> getQuestion(){
    	List<question> questions = new ArrayList<question>();
         Session session = hibernateUtil.getSessionFactory().openSession();
         try 
         {   session.beginTransaction();
             questions = session.createQuery("from question").getResultList();
         } finally {
             session.close();
         }
         return questions; 	
    }
	@SuppressWarnings("unchecked")
	public List<question> getQuestionRandom(int id_categ,int m)
	{
		
		List<question> questions = new ArrayList<question>();
        Session session = hibernateUtil.getSessionFactory().openSession();
        try 
        {   session.beginTransaction();
            questions = session.createQuery("from question where category_id="+id_categ+"  order by rand() ").setFetchSize(m).getResultList();
      
        } finally {
            session.close();
        }
        return questions; 
		
		
	}
	

}
