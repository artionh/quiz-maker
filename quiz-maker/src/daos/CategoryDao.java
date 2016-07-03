package daos;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import org.hibernate.Session;

import entities.category;


@ManagedBean(name="categoryDao")
@ApplicationScoped
public class CategoryDao {
	
	public void add(category c){
	    Session session = hibernateUtil.getSessionFactory().openSession();
	    try {
	        session.beginTransaction();
	        session.save(c);
	        session.getTransaction().commit();
	    } finally {
	        session.flush();
	        session.close();
	    }
	}
	public void delete(int id){
		
        Session session = hibernateUtil.getSessionFactory().openSession();
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
	public void update(category c){
        Session session = hibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.update(c);
            session.getTransaction().commit();
        } finally {
        	 session.flush();
             session.close();
        }
	}
	
	@SuppressWarnings("unchecked")
	public List<category> getCategories(){
    	List<category> categories = new ArrayList<category>();
         Session session = hibernateUtil.getSessionFactory().openSession();
         try 
         {   session.beginTransaction();
             categories = session.createQuery("from category").getResultList();
         } finally {
             session.close();
         }
         return categories;
    	
    }

}
