package DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import entityBeans.question;

public class questionDAO {
	public void ADD(question q){
		
	    Session session = HibernateUtil.getSessionFactory().openSession();
	    try {
	        session.beginTransaction();
	        session.save(q);
	        session.getTransaction().commit();
	    } 
	       
	     finally {
	        session.close();
	    }
	}
	public void DELETE(int id){
		Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
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
	public void UPDATE(question q){
		Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
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
         Session session = HibernateUtil.getSessionFactory().openSession();
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
        Session session = HibernateUtil.getSessionFactory().openSession();
        try 
        {   session.beginTransaction();
            questions = session.createQuery("from question where category_id="+id_categ+"  order by rand() ").setFetchSize(m).getResultList();
      
        } finally {
            session.close();
        }
        return questions; 
		
		
	}
	
}
