package daos;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import org.hibernate.Session;

import DAO.HibernateUtil;
import entityBeans.role;
import entityBeans.user;

@ManagedBean(name="userDao")
@ApplicationScoped
public class UserDao {
	public void add(user u){
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
        	 session.beginTransaction();
	        session.save(u);
	        session.getTransaction().commit();
	    } finally {
	    	 session.flush();
	         session.close();
	    }
	}
	public void delete(int id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            user u = session.load(user.class, new Integer(id));
            session.delete(u);
        } finally {
            session.close();
        }}
        public void update(user u){
    	
            Session session = HibernateUtil.getSessionFactory().openSession();
            try {
                session.beginTransaction();
                session.update(u);
                session.getTransaction().commit();}
            finally {
            	 session.flush();
                 session.close();
            }
    		
    	}
       
		@SuppressWarnings("unchecked")
		public List<user> getUsers(){
        	List<user> users = new ArrayList<>();
             Session session = HibernateUtil.getSessionFactory().openSession();
             try 
             {  session.beginTransaction();
                users = session.createQuery("from user").getResultList();
             } finally {
            	 session.flush();
                 session.close();
             }
             return users;
        	
        }
		public user getUser(String password,String username){
	        Session session = HibernateUtil.getSessionFactory().openSession();
	        try 
	        {  session.beginTransaction();
	       String sql =  "from user s where"
					+ " s.username='"+username+"' AND s.password='"+password+"'";
	           return    (user) session.createQuery(sql).getSingleResult();
	        } finally {
	        	 session.flush();
	             session.close();
	        }}
	
		public role setRoli(int id){
			
			 Session session = HibernateUtil.getSessionFactory().openSession();
		        try {
		           session.beginTransaction();
		           return( session.load(role.class, new Integer(id)));
		            
		        } finally {
		        	 session.flush();
		             session.close();
		        }
		      
		}
		
}
