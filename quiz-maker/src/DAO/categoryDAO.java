package DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import entityBeans.category;


public class categoryDAO  {

	public void ADD(category c){
	    Session session = HibernateUtil.getSessionFactory().openSession();
	    try {
	        session.beginTransaction();
	        session.save(c);
	        session.getTransaction().commit();
	    } finally {
	        session.flush();
	        session.close();
	    }
	}
	public void DELETE(int id){
		
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
           session.beginTransaction();
           category c = (category) session.load(category.class, new Integer(id));
            session.delete(c);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
	}
	public void UPDATE(category c){
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.update(c);
            session.getTransaction().commit();
        } finally {
            session.close();
        }
	}
	
	@SuppressWarnings("unchecked")
	public List<category> getCategories(){
    	List<category> categories = new ArrayList<category>();
         Session session = HibernateUtil.getSessionFactory().openSession();
         try 
         {   session.beginTransaction();
             categories = session.createQuery("from category").getResultList();
         } finally {
             session.close();
         }
         return categories;
    	
    }
}
